package com.orbes.articlesapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.orbes.articlesapp.model.Supplier;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {

	Page<Supplier> findAll(Pageable pageable);
}
