package com.orbes.articlesapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.orbes.articlesapp.model.Supplier;

public interface SupplierService extends CrudService<Supplier, Long> {

	Page<Supplier> findAll(Pageable pageable);
}