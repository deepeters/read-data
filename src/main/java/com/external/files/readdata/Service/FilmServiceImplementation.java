package com.external.files.readdata.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.external.files.readdata.Model.Film;
import com.external.files.readdata.Repository.FilmRepository;

@Service
@Transactional
public class FilmServiceImplementation implements FilmService {
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public List<Film> findAll() {
		// TODO Auto-generated method stub
		return (List<Film>) filmRepository.findAll();
	}
	
	

}
