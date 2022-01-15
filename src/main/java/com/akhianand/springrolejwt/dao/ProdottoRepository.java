package com.akhianand.springrolejwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akhianand.springrolejwt.model.Prodotto;

@Repository
public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {

}
