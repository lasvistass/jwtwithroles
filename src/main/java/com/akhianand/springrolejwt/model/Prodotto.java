	package com.akhianand.springrolejwt.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prodotto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idProdotto;
    
    @Column
    private String nomeProdotto;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    @Column
    private double prezzo;
    
    @Column
    private LocalDate dataInserimento;
    
    @ManyToOne
    @JoinColumn(name="idUser")
    private User user;
    

	public long getId() {
		return idProdotto;
	}

	public void setId(Long id) {
		this.idProdotto = id;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public LocalDate getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Long getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




    
    
    
}
