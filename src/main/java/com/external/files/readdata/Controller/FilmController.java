package com.external.files.readdata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.external.files.readdata.Model.Film;
import com.external.files.readdata.Service.FilmService;

@Controller
public class FilmController {
	
	@Autowired 
	private FilmService filmService;
	
	@GetMapping(value="/")
	public String home (Model model) {
		model.addAttribute("film", new Film());
		List <Film> films = filmService.findAll();
		model.addAttribute("films", films);
		
		return "View/films";
	}
	
	@PostMapping(value="/fileupload")
	public String uploadFile(@ModelAttribute Film film, RedirectAttributes redirectAttributes) {
		boolean isFlag = filmService.saveDataFromUploadfile(film.getFile());
		
		if(isFlag) {
			redirectAttributes.addFlashAttribute("successmessage", "File Upload Successful!");
		}
		else {
			redirectAttributes.addFlashAttribute("errormessage", "File Upload NOT Successful!");
		}
		
		return "redirect:/";
	}

}
