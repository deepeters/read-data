package com.external.files.readdata.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.external.files.readdata.Model.Film;
import com.external.files.readdata.Repository.FilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

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

	@Override
	public boolean saveDataFromUploadfile(MultipartFile file) {
		// TODO Auto-generated method stub
		boolean isFlag = false;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if (extension.equalsIgnoreCase("json")) {
			isFlag = readDataFromJson(file);
		}
		else if (extension.equalsIgnoreCase("csv")) {
			isFlag = readDataFromCsv(file);
		}
		return isFlag;
	}

	private boolean readDataFromCsv(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader reader = new InputStreamReader(file.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String[]> rows = csvReader.readAll();
			
			for (String[] row : rows) {
				filmRepository.save(new Film(row[0], row[1], row[2], row[3], row[4], row[5], FilenameUtils.getExtension(file.getOriginalFilename())));
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	private boolean readDataFromJson(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			InputStream inputStream = file.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			List<Film> films = Arrays.asList(mapper.readValue(inputStream, Film[].class));
			
			if(films!= null && films.size()>0) {
				for (Film film : films) {
					film.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
					filmRepository.save(film);
				}
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	

}
