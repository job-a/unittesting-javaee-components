package nl.mypackage;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class SomeJaxRsHttpClient {
	private Client client;
	
	@Resource(lookup="prop/resourceUri")
	private String resourceUri;
	
	@PostConstruct
	public void setup() {
		 client = ClientBuilder.newClient();
	}
	
	public boolean invokeCall(String postcode) {
		Response res = client.target(resourceUri).request(MediaType.TEXT_PLAIN).get();
		if (Response.Status.OK.getStatusCode() == res.getStatus()) {
			Boolean valid = res.readEntity(Boolean.class);
			return valid;
		} else {
			throw new RuntimeException("Some message");
		}
	}
}
