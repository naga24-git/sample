package com.pge.ei.sample.gateway;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SoapGateway {

	private static final Logger LOGGER = Logger.getLogger(SoapGateway.class);

	@Value("${baseURI}")
	private String baseURI;
	
	@Value("${serviceURI}")
	private String serviceURI;

	private WebServiceTemplate getServiceTemplate() {
		LOGGER.info("Entered  getServiceTemplate method..");
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		/*
		 * copy the wsdl file in src/main/resources and give the wsdl name in pom.xml
		 * and then generate the stubs
		 */
		marshaller.setContextPath("com.sample.stubs");
		WebServiceTemplate template = new WebServiceTemplate();
		template.setDefaultUri(baseURI);
		template.setMarshaller(marshaller);
		template.setUnmarshaller(marshaller);
		template.setMessageSender(new Authorization());
		LOGGER.info("Exiting getServiceTemplate method..");
		return template;
	}

	//This method calls the WebServiceTemplate 
	public SampleResponse submit(SampleRequest request) {
		SampleResponse response = (SampleResponse) getServiceTemplate()
			          .marshalSendAndReceive(baseURI, request, new SoapActionCallback(serviceURI));
		return response;
	}
	

	public class SampleRequest {

	}
	
	public class SampleResponse {
		
	}

}
