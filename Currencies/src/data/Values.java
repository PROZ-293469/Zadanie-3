package data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ExchangeRatesSeries")
public class Values {
	
	private String name;	//nazwa waluty
	private String table;	//oznaczenia tabeli
	private String code;	//trzyliterowy kod waluty
	private List<Value> values = new ArrayList<Value>();	//wartosci kursow
	
	public Values() {
		
	}
	
	public Values(String name, String table, String code, List<Value> values) {
		this.name=name;
		this.table=table;
		this.code=code;
		this.values=values;
	}
	
	@XmlElement(name = "Currency")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "Table")
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
	
	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@XmlElementWrapper(name = "Rates")
	@XmlElement(name = "Rate")
	public List<Value> getValues() {
		return values;
	}
	
	public void setValues(List<Value> values) {
		this.values = values;
	}
	
	public double getAverageBid() {		//dla tablicy C
		double average = 0;
		for (Value v: values)
			average += v.getBid();
		average /= values.size();
		average = average * 10000;		//zaokraglenie wyniku do 4 miejsc po przecinku
		average = Math.round(average);
		average = average / 10000;
		if (average>0)
			return average;
		else
			return 0.0;
	}
		
	public double getAverageAsk() {		//dla tablicy C
		double average = 0;
		for (Value v: values)
			average += v.getAsk();
		average /= values.size();
		average = average * 10000;
		average = Math.round(average);
		average = average / 10000;
		if (average>0)
			return average;
		else
			return 0.0;			
	}
	
	public double getAverageMid() {		//dla tablicy A,B
		double average = 0;
		for (Value v: values)
			average += v.getMid();
		average /= values.size();
		average = average * 10000;
		average = Math.round(average);
		average = average / 10000;
		if (average>0)
			return average;
		else
			return 0.0;		
		
	}	

}
