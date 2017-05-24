package it.polito.tdp.bar.model;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Simulator_solution sim = new Simulator_solution() ;
		
		
		sim.addTavoli(1,new Tavolo(10,false));
		sim.addTavoli(2,new Tavolo(10,false));
		sim.addTavoli(3,new Tavolo(8,false));
		sim.addTavoli(4,new Tavolo(8,false));
		sim.addTavoli(5,new Tavolo(8,false));
		sim.addTavoli(6,new Tavolo(8,false));
		sim.addTavoli(7,new Tavolo(6,false));
		sim.addTavoli(8,new Tavolo(6,false));
		sim.addTavoli(9,new Tavolo(6,false));
		sim.addTavoli(11,new Tavolo(6,false));
		sim.addTavoli(12,new Tavolo(4,false));
		sim.addTavoli(13,new Tavolo(4,false));
		sim.addTavoli(14,new Tavolo(4,false));
		sim.addTavoli(15,new Tavolo(4,false));
		sim.addTavoli(16,new Tavolo(4,false));

		
		
		
		int time=0;
		Random random = new Random();
		int j = 60;
		int n = 120-j;
			for(int i=0; i<2000; i++,time=(int) (time+( Math.random() * 10))) {
			
		
				Event p = new Event(time,(int) (Math.random()*10),random.nextInt(n)+j,Math.random()*0.9) ;
				sim.addEvent(p);
		
		}
		
		sim.run();
		
		System.out.println("Clienti:   " + sim.getClienti());
		System.out.println("Clienti soddisfatti: " + (int) sim.getClientiSoddisfatti());
		System.out.println("Clienti insoddisfatti:      " +(int) sim.getPclientiinsoddisfatti());


	}

}
