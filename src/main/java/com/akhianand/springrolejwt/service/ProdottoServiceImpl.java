package com.akhianand.springrolejwt.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhianand.springrolejwt.dao.ProdottoRepository;
import com.akhianand.springrolejwt.dao.UserDao;
import com.akhianand.springrolejwt.model.Categoria;
import com.akhianand.springrolejwt.model.Prodotto;
import com.akhianand.springrolejwt.model.User;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Service
public class ProdottoServiceImpl  implements ProdottoService{
	
	@Autowired
	ProdottoRepository prodottoRepository;
	
	@Autowired
	UserDao userDato;

	@Override
	public void saveProdotto(Prodotto prodotto) {
		prodottoRepository.save(prodotto);
	}

	@Override
	public Prodotto findProdottoById(Long id) {
		return prodottoRepository.findById(id).get();
	}

	@Override
	public Prodotto creaProdotto(String[] valori) {
		Prodotto prodotto = new Prodotto();
		prodotto.setNomeProdotto(valori[0]);
		Categoria categoria = Categoria.valueOf(valori[1]);
		prodotto.setCategoria(categoria);
		int prezzo = Integer.parseInt(valori[2]);
		prodotto.setPrezzo(prezzo);
		LocalDate data = LocalDate.now();
		prodotto.setDataInserimento(data);
		Long idUser = Long.parseLong(valori[3]);
		User user = userDato.findById(idUser).get();
		prodotto.setUser(user);
		prodottoRepository.save(prodotto);
		
		return prodotto;
	}
	
	public void Excel2Data(String path) throws EncryptedDocumentException, InvalidFormatException, IOException{

		Workbook workbook = WorkbookFactory.create(new File(path));
		
		for(Sheet sheet: workbook) {			 
            for (Row row: sheet) {
            	String nome_prodotto = row.getCell(0).getStringCellValue();
            	String categoria_prodotto = row.getCell(1).getStringCellValue();
            	Integer prezzoExcel = (int) row.getCell(2).getNumericCellValue();
            	Integer userExcel = (int) row.getCell(3).getNumericCellValue();
            	String prezzo = String.valueOf(prezzoExcel);
            	String user = String.valueOf(userExcel);
            	
            	String[] valori = {nome_prodotto, categoria_prodotto, prezzo, user};
            	
            	creaProdotto(valori);
            	
            	
            	
            	
            }
		}
		
	}

}
