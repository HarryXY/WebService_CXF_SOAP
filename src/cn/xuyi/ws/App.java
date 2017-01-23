package cn.xuyi.ws;

/**
 * use "wsimport" command generate client code to call remote server 
 * @author xuyi
 *
 */
public class App {

	public static void main(String[] args) {
		/*
		 * WSDL:
		 * <service name="HelloServiceService">
		 */
		HelloServiceService hss = new HelloServiceService();
		
		/*
		 * WSDL:
		 * <port name="HelloServicePort" binding="tns:HelloServicePortBinding">
		 */
		HelloService hs = hss.getHelloServicePort();
		
		String result = hs.sayHello("Harry");
		System.out.println(result);
		System.out.println(hs.getClass().getName());
	}

}
