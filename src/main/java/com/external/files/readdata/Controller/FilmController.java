package com.external.files.readdata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.external.files.readdata.Service.FilmService;

@Controller
public class FilmController {
	
	@Autowired 
	private FilmService filmService;

}
