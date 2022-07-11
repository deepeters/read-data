package com.external.files.readdata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.external.files.readdata.Repository.FilmRepository;

@Service
@Transactional
public class FilmServiceImplementation implements FilmService {
	
	@Autowired
	private FilmRepository filmRepository;

}
