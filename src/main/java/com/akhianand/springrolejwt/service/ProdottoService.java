package com.akhianand.springrolejwt.service;

import com.akhianand.springrolejwt.model.Prodotto;

public interface ProdottoService {

	void saveProdotto(Prodotto prodotto);
	Prodotto findProdottoById(Long id);
	Prodotto creaProdotto(String[] valori);
}
