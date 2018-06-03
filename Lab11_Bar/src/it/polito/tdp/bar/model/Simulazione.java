package it.polito.tdp.bar.model;

import java.util.*;

public class Simulazione {
	
	private Random rd;
	private Statistiche statistiche;
	private Queue<Evento> queue;
	private Map<Integer, Tavolo> tavoli;
	
	public void init() {
		this.rd = new Random(35);
		this.statistiche = new Statistiche();
		this.queue = new PriorityQueue<Evento>();
		this.tavoli = new HashMap<Integer, Tavolo>();
		
	}
	
	public void run() {
		while(!queue.isEmpty())
			this.processEvent();
	}
	
	private long processEvent() {
		
		if(queue.isEmpty())
			return Long.MAX_VALUE;
		
		Evento e = queue.remove();
		
		switch (e.eventType) {
		
		case ARRIVO_GRUPPO_CLIENTI:
			Tavolo t = this.trovaTavolo(e.getCustomer().getNumPersone());
			if(t!=null) {
				t.setIdGruppo(e.getCustomer().getId());
				t.setLibero(false);
				e.getCustomer().setSoddisfatti(true);
				
				Evento gruppoUscente = new Evento(Evento.EventTypeEnum.PARTENZA_GRUPPO_CLIENTI,
											e.getTimeStamp() + e.getCustomer().getDurata(), e.getCustomer());

				queue.add(gruppoUscente);
			} else {
				float tolleranza = e.getCustomer().getTolleranza();
				float probabilita = rd.nextFloat();
				
				if(tolleranza>=probabilita) { // vanno al banco
					e.getCustomer().setSoddisfatti(true);
				} else { // vanno a casa
					e.getCustomer().setSoddisfatti(false);
				}
			}
			
			statistiche.nuovoGruppo(e.getCustomer());
			break;
			
		case PARTENZA_GRUPPO_CLIENTI:
			Tavolo tav = this.getTavoloFromIdGruppo(e.getCustomer().getId());
			tav.setLibero(true);
			tav.setIdGruppo(0);
			
			break;

		default:
			throw new IllegalArgumentException();
		}
		
		return e.getTimeStamp();

	}
	
	private Tavolo trovaTavolo(int numeroPersone) {
		List<Tavolo> tavoliLiberi = new LinkedList<Tavolo>(); // ordino la lista per num persone crescente
		for(Tavolo t: this.tavoli.values()) {
			if(t.isLibero())
				tavoliLiberi.add(t);
			}
		for(Tavolo t1: tavoliLiberi) { // il primo tavolo libero li assegno
			if(numeroPersone>=0.5*t1.getNumPosti()) {
				return t1;
			}
		}
		return null;
		}
	
	private Tavolo getTavoloFromIdGruppo(int id) {
		for(Tavolo t: this.tavoli.values()) {
			if(t.getIdGruppo()==id)
				return t;
		}
		return null;
	}
	
	
	}
	
	


