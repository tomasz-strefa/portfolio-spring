package pl.edu.pwsztar.service;

import pl.portfolio.portfolio.domain.dto.CreateMovieDto;
import pl.portfolio.portfolio.domain.dto.MovieCounterDto;
import pl.portfolio.portfolio.domain.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAll();

    List<MovieDto> findAllByYearDesc();

    void createMovie(CreateMovieDto createMovieDto);

    void deleteMovie(Long movieId);

    MovieCounterDto countMovies();
}
