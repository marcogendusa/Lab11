package it.polito.tdp.bar.model;

public class Statistiche {
	
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	private int numero_totale_gruppi = 0;
	private int numTavoli = 0;
	private int gruppi_soddisfatti = 0;
	private int gruppi_insoddisfatti = 0;
	
	public void nuovoGruppo (Gruppo g) {
		numero_totale_gruppi++;
		numero_totale_clienti += g.getNumPersone();
		
		if(g.isSoddisfatti()) {
			gruppi_soddisfatti++;
			numero_clienti_soddisfatti += g.getNumPersone();
		} else {
			gruppi_insoddisfatti++;
			numero_clienti_insoddisfatti += g.getNumPersone();
		}
	}
	
	public void setNumTavoli(int n) {
		numTavoli = n;
	}
	
	public String toString() {

		String ris = "Numero totale Gruppi:  " + this.numero_totale_gruppi + "\n";
		ris += "Numero totale Gruppi Soddisfatti:  " + this.gruppi_soddisfatti + "\n";
		ris += "Numero totale Gruppi Insoddisfatti:  " + this.gruppi_insoddisfatti + "\n";
		ris += "Numero totale Clienti:  " + this.numero_totale_clienti + "\n";
		ris += "Numero totale Clienti Soddisfatti:  " + this.numero_clienti_soddisfatti + "\n";
		ris += "Numero totale Clienti Insoddisfatti:  " + this.numero_clienti_insoddisfatti + "\n";
		ris += "Numero tavoli con cui lavora il simulatore:  " + this.numTavoli + "\n\n\n";
		return ris;
	}

}
