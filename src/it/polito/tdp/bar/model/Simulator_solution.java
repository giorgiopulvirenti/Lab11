package it.polito.tdp.bar.model;

import java.util.PriorityQueue;
import java.util.TreeMap;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator_solution {


TreeMap <Integer,Tavolo> tavoli= new TreeMap<Integer,Tavolo>();

	private int clienti = 0;
	private double clientiSoddisfatti = 0;
	private double pclientiinsoddisfatti = 0;

	// Event queue
	private PriorityQueue<Event> queue;

	public Simulator_solution() {
	

		this.queue = new PriorityQueue<>();
		
	}

	public void addEvent(Event e) {
		queue.add(e) ;
		e.setType(EventType.ARRIVO_GRUPPO_CLIENTI);
		System.out.println(e);
	}

	public void run() {
		while (!queue.isEmpty()) {
			Event e = queue.poll();
		

			switch (e.getType()) {
			case ARRIVO_GRUPPO_CLIENTI:
				processArrivo(e);
				break;
			case FREE_CLIENTI:
				processFree(e);
			
			}
		}
	}

	private void processFree(Event e) {
			e.getTavolo().setOccupato(false);
		
	}

	private void processArrivo(Event e) {
		this.clienti++;
		Tavolo t=controlla(e.getNum_persone());
		if(t!=null){
			 t.setOccupato(true);
			 
			this.clientiSoddisfatti+=1;
			Event e1=new Event(e.getTime()+e.getDurata(),e.getNum_persone(),e.getDurata(),e.getTolleranza());
			this.addEvent(e1);
			e1.setType(EventType.FREE_CLIENTI);		
			e1.setTavolo(t);
		}
		
		else
		{
			
			double i=Math.random();
			if (i<=e.getTolleranza()){
				this.clientiSoddisfatti++;
			}
			else
				this.pclientiinsoddisfatti++;
			
//			this.clientiSoddisfatti+=e.getTolleranza();
//			this.pclientiinsoddisfatti+=(1-e.getTolleranza());
			
			
		}
		
	}

	private Tavolo controlla(int num_persone) {
		int min=9999;
		Tavolo tavolo=null;
		for (Tavolo t:tavoli.values()){
			if(t.getPosti()<min&&t.getPosti()>=num_persone&&!t.isOccupato())
				min=t.getPosti();
			tavolo=t;
		}
			
			if(min!=9999&&min*0.5<num_persone)
			return tavolo;
			
			return null;
	}

	public int getClienti() {
		return clienti;
	}

	public void setClienti(int clienti) {
		this.clienti = clienti;
	}

	public double getClientiSoddisfatti() {
		return clientiSoddisfatti;
	}

	public void setClientiSoddisfatti(double clientiSoddisfatti) {
		this.clientiSoddisfatti = clientiSoddisfatti;
	}

	public double getPclientiinsoddisfatti() {
		return pclientiinsoddisfatti;
	}

	public void setPclientiinsoddisfatti(int pclientiinsoddisfatti) {
		this.pclientiinsoddisfatti = pclientiinsoddisfatti;
	}

	public void addTavoli(int i, Tavolo tavolo) {
		this.tavoli.put(i, tavolo);
		
	}
	
}


	