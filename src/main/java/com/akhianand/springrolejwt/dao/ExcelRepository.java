package com.akhianand.springrolejwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhianand.springrolejwt.excel.Excel;


@Repository
public interface ExcelRepository extends JpaRepository<Excel, Integer>{
	
	

}
