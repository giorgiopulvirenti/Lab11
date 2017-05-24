package it.polito.tdp.bar.model;

public class Tavolo {
 int posti;
 boolean occupato;
 
public Tavolo(int posti, boolean occupato) {
	super();
	this.posti = posti;
	this.occupato = occupato;
}
public int getPosti() {
	return posti;
}
public void setPosti(int posti) {
	this.posti = posti;
}
public boolean isOccupato() {
	return occupato;
}

@Override
public String toString() {
	return "Tavolo [posti=" + posti + ", occupato=" + occupato + "]";
}
public void setOccupato(boolean occupato2) {
	this.occupato = occupato2;
	
}
 

}
