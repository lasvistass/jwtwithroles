package com.akhianand.springrolejwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhianand.springrolejwt.excel.Excel;
import com.akhianand.springrolejwt.service.ExcelService;

@RestController
@RequestMapping(value="/excel")
public class ExcelController {
	
	@Autowired
	ExcelService excelService;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/save")
	public Excel save(@RequestBody Excel excel) {
		return excelService.salva(excel);
	}
	
	@GetMapping(value="/free")
	public List<Excel> getAll(){
		return excelService.listFile();
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value="/token")
	public List<Excel> getAllSecuity(){
		return excelService.listFile();
	}
}
