package cn.xuyi.ws.clientCode;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cn.xuyi.ws.HelloService;

public class App {

	public static void main(String[] args) throws MalformedURLException {
		URL wsUrl = new URL("http://192.168.100.107:6789/hello");
		Service s = Service.create(wsUrl, new QName("http://ws.xuyi.cn/","HelloServiceService"));
		HelloService hs = s.getPort(new QName("http://ws.xuyi.cn/", "HelloServicePort"), HelloService.class);
		String result = hs.sayHello("Kitty");
		System.out.println(result);
	}

}
