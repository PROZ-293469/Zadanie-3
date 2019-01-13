package rest;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;


@Path("293469/exchangerates/rates/{table}/{code}/{topCount}")
public class GETRequests {
	
	@GET		//format XML
	@Produces({ MediaType.APPLICATION_XML })
	public String getXML(@PathParam("table") String table, 
			@PathParam("code") String code,
			@PathParam("topCount") int topCount) throws JAXBException {
		return Results.calculateResults(table,code,topCount);
	}
	
	/*
	@GET		//format JSON
	@Produces({ MediaType.APPLICATION_JSON })
	public String getJSON(@PathParam("table") String table, 
			@PathParam("code") String code,
			@PathParam("topCount") int topCount) throws JAXBException, JSONException {

		String results = new String (Results.calculateResults(table,code,topCount));
		JSONObject jsonObject = XML.toJSONObject(results); 		//konwersja XML na JSON
		return jsonObject.toString();
	}
	*/

}
