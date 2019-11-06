package com.orbes.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orbes.articlesapp.model.Article;
import com.orbes.articlesapp.model.Incident;


@Repository
public interface IncidentRepository extends PagingAndSortingRepository<Incident, Long> {
	
	@Query(value = "SELECT MAX(id) FROM Incident")
    Long findTopByOrderByIdDesc();
	
	@Query("SELECT i FROM Incident i WHERE i.observations=:observations")
	List<Incident> findByObservations(@Param("observations") String observations);

	
	Page<Incident> findAll(Pageable pageable);


}

