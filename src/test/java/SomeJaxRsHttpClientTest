package nl.mypackage;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeJaxRsHttpClientTest {
	
	@Mock Client client;
	@Mock WebTarget target;
	@Mock Builder builder;
	@Mock Response response;
	
	@InjectMocks
	private SomeJaxRsHttpClient yourClient = new SomeJaxRsHttpClient();
	
	@Before
	public void setup() {
		when(client.target(anyString())).thenReturn(target);
		when(target.request(anyString())).thenReturn(builder);
		when(builder.get()).thenReturn(response);
	}
	
	@Test
	public void testHttpCall() {
		// given
		when(response.getStatus()).thenReturn(200);
		when(response.readEntity(Boolean.class)).thenReturn(true);
		
		// when
		boolean valid = yourClient.invokeCall("XXX");
		
		// then
		assertEquals(true, valid);
	}

}
