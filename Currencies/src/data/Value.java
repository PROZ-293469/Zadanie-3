package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Rate")
public class Value {
	
	private String no;
	private String effectiveDate;
	private double bid;		//cena kupna
	private double ask;		//cena sprzedazy
	private double mid;		//wartosc srednia

	
	public Value() {
		
	}
	
	public Value(String no, String effectiveDate, double bid, double ask, double mid) {
		this.no=no;
		this.effectiveDate = effectiveDate;
		this.bid=bid;
		this.ask=ask;
		this.mid=mid;
	}
	
	@XmlElement(name="No")
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no=no;
	}
	
	@XmlElement(name = "EffectiveDate")
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@XmlElement(name = "Bid")
	public double getBid() {
		return bid;
	}
	
	public void setBid(double bid) {
		this.bid = bid;
	}
	
	@XmlElement(name = "Ask")
	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}
	
	@XmlElement(name = "Mid")
	public double getMid() {
		return mid;
	}

	public void setMid(double mid) {
		this.mid = mid;
	}
	
	
}
