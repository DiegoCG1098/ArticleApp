package com.hampcode.articlesapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Supplier;

public interface SupplierService extends CrudService<Supplier, Long> {

	Page<Supplier> findAll(Pageable pageable);
}