package it.polito.tdp.bar.model;

public class Gruppo {
	
	static private int n = 0;
	private int id;
	private long arrivo;
	private int numPersone;
	private long durata;
	private float tolleranza;
	private boolean soddisfatti;
	
	public Gruppo(long arrivo, int numPersone, long durata, float tolleranza) {
		this.id = n++;
		this.arrivo = arrivo;
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.soddisfatti = false;
	}

	public int getId() {
		return id;
	}

	public long getArrivo() {
		return arrivo;
	}

	public void setArrivo(long arrivo) {
		this.arrivo = arrivo;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public long getDurata() {
		return durata;
	}

	public void setDurata(long durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public boolean isSoddisfatti() {
		return soddisfatti;
	}

	public void setSoddisfatti(boolean soddisfatti) {
		this.soddisfatti = soddisfatti;
	}

	@Override
	public String toString() {
		return "Gruppo numero: "+id;
	}
	
	

}
