package com.akhianand.springrolejwt.service;

import java.util.List;

import com.akhianand.springrolejwt.excel.Excel;


public interface ExcelService {

	public Excel salva(Excel excel);

	public List<Excel> listFile();

	public List<Excel> arrayToList(Excel[] lista);

}