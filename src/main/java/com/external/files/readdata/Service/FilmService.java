package com.external.files.readdata.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.external.files.readdata.Model.Film;

public interface FilmService {

	List<Film> findAll();

	boolean saveDataFromUploadfile(MultipartFile file);

}
