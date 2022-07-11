package com.external.files.readdata.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.external.files.readdata.Model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

}
