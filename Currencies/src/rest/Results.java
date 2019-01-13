package rest;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import data.Infos;
import data.Value;
import data.Values;

public class Results {
	
	public static String calculateResults(String table, String code, int topCount) throws JAXBException {
		RestClient restClient = new RestClient(table,code,topCount);
		String xmlAnswer =  new String (restClient.getXmlAnswer());	
		Infos infos = Results.unmarshalling(xmlAnswer);
		String xmlString = Results.marshalling(infos);
		return xmlString;			
	}
	
	//transformacja struktury XML w obiekt Javy
	private static Infos unmarshalling(String xmlAnswer) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Values.class, Value.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StringReader stringReader = new StringReader(xmlAnswer);
		Values values = (Values) jaxbUnmarshaller.unmarshal(stringReader);
		Infos infos = new Infos(values);
		return infos;
	}
	
	//transformacja obiektu Javy w strukture XML
	private static String marshalling(Infos infos) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Infos.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		StringWriter stringWriter = new StringWriter();
		jaxbMarshaller.marshal(infos, stringWriter);
		String xmlString = stringWriter.toString();
		return xmlString;
	}

}
