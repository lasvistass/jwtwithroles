package com.akhianand.springrolejwt.controller;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhianand.springrolejwt.model.Prodotto;
import com.akhianand.springrolejwt.service.ProdottoServiceImpl;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestController
@RequestMapping(value="/prodotto")
public class ProdottoController {

	 @Autowired
	 ProdottoServiceImpl prodottoServiceImpl;
	 
	 @GetMapping(value="/{id}")
	 public Prodotto findById(@PathVariable("id") Long id) {
		 return prodottoServiceImpl.findProdottoById(id);
	 }
	 
	 @PostMapping(value="/save")
	 public String saveProdotto(@RequestBody Prodotto prodotto) {
		 prodottoServiceImpl.saveProdotto(prodotto);
		 return "Salvato!";
	 }
	 
	 @PostMapping(value="/crea")
	 public Prodotto creaProdotto(@RequestBody String[] valori) {
		 return prodottoServiceImpl.creaProdotto(valori);
	 }
	 
	 @GetMapping(value="/excel")
	 public String saveExcel() throws InvalidFormatException, EncryptedDocumentException, IOException {
		prodottoServiceImpl.Excel2Data("C:\\Users\\nosur\\OneDrive\\Desktop\\Excel\\Esempio.xlsx");
		return "Salvataggio andato a buon fine";
	 }
}
