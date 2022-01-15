package com.akhianand.springrolejwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idUtente;
    
    @Column
    private String nome;
    
    @Column
    private String cognome;
    
    @Column
    private int eta;
    
    

	public Long getId() {
		return idUtente;
	}

	public void setId(Long id) {
		this.idUtente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
    
    
    
    
}
