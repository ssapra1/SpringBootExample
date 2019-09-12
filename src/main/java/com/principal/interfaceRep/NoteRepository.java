package com.principal.interfaceRep;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.principal.model.Person;


	@Repository
	public interface NoteRepository extends JpaRepository<Person, Long> {

	}

