package it.polito.tdp.bar.model;


public class Evento implements Comparable<Evento> {
	
	public enum EventTypeEnum {
		ARRIVO_GRUPPO_CLIENTI, PARTENZA_GRUPPO_CLIENTI;
	}
	
	public EventTypeEnum eventType;
	private long timeStamp;
	private Gruppo customer;
	
	public Evento(EventTypeEnum eventType, long timeStamp, Gruppo customer) {
		this.eventType = eventType;
		this.timeStamp = timeStamp;
		this.customer = customer;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Gruppo getCustomer() {
		return customer;
	}

	public void setCustomer(Gruppo customer) {
		this.customer = customer;
	}

	public int compareTo(Evento e) {
		return Long.compare(this.timeStamp, e.timeStamp);
	}

	

}
