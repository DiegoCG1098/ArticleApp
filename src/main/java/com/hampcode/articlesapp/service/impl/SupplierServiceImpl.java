package com.hampcode.articlesapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hampcode.articlesapp.exception.ResourceNotFoundException;
import com.hampcode.articlesapp.model.Supplier;
import com.hampcode.articlesapp.repository.SupplierRepository;
import com.hampcode.articlesapp.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAll() {
		List<Supplier> suppliers = new ArrayList<>();
		supplierRepository.findAll().iterator().forEachRemaining(suppliers::add);
		return suppliers;
	}

	@Override
	public Supplier create(Supplier entity) {
		Supplier newSupplier;
		newSupplier = supplierRepository.save(entity);
		return newSupplier;
	}

	@Override
	public Supplier update(Long id, Supplier entity) {
		Supplier supplier = findById(id);

		supplier.setEnterprise(entity.getEnterprise());
		supplier.setRuc(entity.getRuc());
		supplier.setProduct(entity.getProduct());
		supplier.setPhone(entity.getPhone());
		/*supplier.setDescription(entity.getDescription());*/
		

		supplierRepository.save(supplier);
		return supplier;
	}

	@Override
	public void delete(Long id) {
		supplierRepository.delete(findById(id));
	}

	@Override
	public Supplier findById(Long id) {
		Optional<Supplier> supplier = supplierRepository.findById(id);

		if (!supplier.isPresent()) {
			throw new ResourceNotFoundException("There is no Supplier with ID = " + id);
		}

		return supplier.get();

	}

	@Override
	public Page<Supplier> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return supplierRepository.findAll(pageable);
	}

}