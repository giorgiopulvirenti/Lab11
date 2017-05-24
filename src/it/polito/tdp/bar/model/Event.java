package it.polito.tdp.bar.model;



public class Event  implements Comparable<Event> {
	
	public enum EventType { 
		ARRIVO_GRUPPO_CLIENTI,
		FREE_CLIENTI
				} ;
		
	
	Tavolo t;
	private int time ;
	private int num_persone ;
	private int durata ;
	private double tolleranza;
	private EventType type ;
	
	public Event(int time , int num_persone , int durata , double tolleranza) {
		super();
		
		this.time = time;
	this.num_persone=num_persone;
	this.durata=durata;
	this.tolleranza=tolleranza;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getNum_persone() {
		return num_persone;
	}

	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public double getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event [time=" + time + ", num_persone=" + num_persone + ", durata=" + durata + ", tolleranza="
				+ tolleranza + ", type=" + type + "]";
	}

	public void setTavolo(Tavolo t){
	this.t=t;
	
	}
	public Tavolo getTavolo(){
		return this.t;
		
		}
	public int compareTo(Event other) {
		return this.time-other.time;
	}

}