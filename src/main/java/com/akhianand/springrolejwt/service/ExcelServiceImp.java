package com.akhianand.springrolejwt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhianand.springrolejwt.dao.ExcelRepository;
import com.akhianand.springrolejwt.excel.Excel;



@Service
public class ExcelServiceImp implements ExcelService {

	@Autowired
	ExcelRepository excelRepo;

	@Override
	public Excel salva(Excel excel) {
		return excelRepo.save(excel);
	}

	@Override
	public List<Excel> listFile() {
		return excelRepo.findAll();
	}

	@Override
	public List<Excel> arrayToList(Excel[] lista) {
		List<Excel> excelList = Arrays.asList(lista);
		for (int i = 0; i < excelList.size(); i++) {
			excelRepo.save(excelList.get(i));
		}
		return excelList;
	}

}
