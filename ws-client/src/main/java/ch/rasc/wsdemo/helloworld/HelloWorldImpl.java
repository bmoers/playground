package ch.rasc.wsdemo.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.6 in JDK 6 Generated
 * source version: 2.1
 *
 */
@WebService(name = "HelloWorldImpl", targetNamespace = "http://wsdemo.ralscha.ch/")
@XmlSeeAlso({ ObjectFactory.class })
public interface HelloWorldImpl {

	/**
	 *
	 * @param arg0
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "sayHi", targetNamespace = "http://wsdemo.ralscha.ch/", className = "ch.rasc.wsdemo.helloworld.SayHi")
	@ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://wsdemo.ralscha.ch/", className = "ch.rasc.wsdemo.helloworld.SayHiResponse")
	public String sayHi(@WebParam(name = "arg0", targetNamespace = "") String arg0);

}
