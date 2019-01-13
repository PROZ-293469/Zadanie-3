package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Data")
public class Infos {
	
	private String name;
	private String table;
	private String code;
	private double averageBid;
	private double averageAsk;
	private double averageMid;
	

	public Infos () {
		
	}
	
	public Infos(Values values) {
		this.name=values.getName();
		this.table=values.getTable();
		this.code=values.getCode();
		this.averageBid=values.getAverageBid();
		this.averageAsk=values.getAverageAsk();
		this.averageMid=values.getAverageMid();
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
	
	@XmlElement(name = "AverageBid")
	public double getAverageBid() {
		return averageBid;
	}
	
	public void setAverageBid(double averageBid) {
		this.averageBid = averageBid;
	}
	
	@XmlElement(name = "AverageAsk")
	public double getAverageAsk() {
		return averageAsk;
	}
	
	public void setAverageAsk(double averageAsk) {
		this.averageAsk = averageAsk;
	}	
	

	@XmlElement(name = "AverageMid")
	public double getAverageMid() {
		return averageMid;
	}

	public void setAverageMid(double averageMid) {
		this.averageMid = averageMid;
	}
	
}
