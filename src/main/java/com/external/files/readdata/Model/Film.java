package com.external.files.readdata.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "film")
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "film-name")
	private String filmName;
	
	@Column(name = "film-year")
	private String filmYear;
	
	@Column(name = "main-character")
	private String mainCharacter;
	
	@Column(name = "main-planet")
	private String mainPlanet;
	
	@Column(name = "film-summary")
	public String filmSummary;
	
	@Column(name = "film-rating")
	public String filmRating;
	
	@Column(name = "file-type")
	public String fileType;
	
	@Transient
	private MultipartFile file;
	
	//Constructors
	public Film(Long id, String filmName, String filmYear, String mainCharacter, String mainPlanet, String filmSummary,
			String filmRating, String fileType) {
		super();
		this.id = id;
		this.filmName = filmName;
		this.filmYear = filmYear;
		this.mainCharacter = mainCharacter;
		this.mainPlanet = mainPlanet;
		this.filmSummary = filmSummary;
		this.filmRating = filmRating;
		this.fileType = fileType;
	}
	public Film() {
		super();
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public String getFilmName() {
		return filmName;
	}
	public String getFilmYear() {
		return filmYear;
	}
	public String getMainCharacter() {
		return mainCharacter;
	}
	public String getMainPlanet() {
		return mainPlanet;
	}
	public String getFilmSummary() {
		return filmSummary;
	}
	public String getFilmRating() {
		return filmRating;
	}
	public String getFileType() {
		return fileType;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public void setFilmYear(String filmYear) {
		this.filmYear = filmYear;
	}
	public void setMainCharacter(String mainCharacter) {
		this.mainCharacter = mainCharacter;
	}
	public void setMainPlanet(String mainPlanet) {
		this.mainPlanet = mainPlanet;
	}
	public void setFilmSummary(String filmSummary) {
		this.filmSummary = filmSummary;
	}
	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
