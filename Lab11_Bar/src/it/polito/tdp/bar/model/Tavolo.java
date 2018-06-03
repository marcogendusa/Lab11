package it.polito.tdp.bar.model;

public class Tavolo {
	
	static private int n = 0;
	private int id;
	private int idGruppo;
	private int numPosti;
	private boolean libero;
	
	public Tavolo(int numPosti) {
		this.libero = true;
		this.id = n++;
		this.numPosti = numPosti;
		this.id = 0;
	}

	public int getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(int idGruppo) {
		this.idGruppo = idGruppo;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	public int getId() {
		return id;
	}

	public int getNumPosti() {
		return numPosti;
	}
	

}
