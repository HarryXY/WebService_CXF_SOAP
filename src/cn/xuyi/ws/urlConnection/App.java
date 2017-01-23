package cn.xuyi.ws.urlConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * use URLConnection to call WebService
 * @author xuyi
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		
		//URL:Server address
		URL wsUrl = new URL("http://192.168.100.107:6789/hello");
		
		//Connection
		HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
		
		//OutputStream
		OutputStream os = conn.getOutputStream();
		
		//Request Body
		String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://ws.xuyi.cn/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
					"<soapenv:Body><q0:sayHello><arg0>Harry</arg0></q0:sayHello></soapenv:Body></soapenv:Envelope>";
		os.write(soap.getBytes());
		
		InputStream is = conn.getInputStream();
		byte[] b = new byte[1024];
		int len = 0;
		String s = "";
		while((len = is.read(b)) != -1){
			String ss = new String(b, 0, len, "UTF-8");
			s += ss;
		}
		System.out.println(s);
		
		is.close();
		os.close();
		conn.disconnect();
	}

}
