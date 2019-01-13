package rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {
	
	private String xmlAnswer;
	private String jsonAnswer;
	
	public RestClient(String table, String code, int topCount) {
		String urlAdress = "http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + code + "/last/" + topCount;
		
		//utworzenie obiektu klasy Client
		Client client = ClientBuilder.newClient();
		
		//konstruowanie adresu URI
		URI uri = URI.create(urlAdress);
		
		//reprezentacja zasobu
		WebTarget webTarget = client.target(uri);
		
		//wywolywanie zadania i odbieranie odpowiedzi
				
		xmlAnswer = webTarget.request()
				.accept(MediaType.TEXT_XML).get(String.class);
		
		jsonAnswer = webTarget.request()
				.accept(MediaType.APPLICATION_JSON).get(String.class);
		
	}

		
	public String getXmlAnswer() {
		return xmlAnswer;
	}
	
	public String getJsonAnswer() {
		return jsonAnswer;
	}
	

}
