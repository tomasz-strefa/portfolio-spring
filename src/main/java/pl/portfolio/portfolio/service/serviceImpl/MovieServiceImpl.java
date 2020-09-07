package pl.portfolio.portfolio.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.service.MovieService;
import pl.portfolio.portfolio.domain.converter.Converter;
import pl.portfolio.portfolio.domain.dto.CreateMovieDto;
import pl.portfolio.portfolio.domain.dto.MovieCounterDto;
import pl.portfolio.portfolio.domain.dto.MovieDto;
import pl.portfolio.portfolio.domain.entity.Movie;
import pl.portfolio.portfolio.domain.mapper.MovieListMapper;
import pl.portfolio.portfolio.domain.mapper.MovieMapper;
import pl.portfolio.portfolio.domain.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;
    private final Converter<List<Movie>, List<MovieDto>> movieListMapper;
    private final Converter<CreateMovieDto, Movie> movieMapper;
    private final Converter<Long, MovieCounterDto> movieCounterMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieListMapper movieListMapper,
                            MovieMapper movieMapper,
                            Converter<Long, MovieCounterDto> movieCounterMapper) {

        this.movieRepository = movieRepository;
        this.movieListMapper = movieListMapper;
        this.movieMapper = movieMapper;
        this.movieCounterMapper = movieCounterMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieListMapper.convert(movies);
    }

    @Override
    public List<MovieDto> findAllByYearDesc() {
        List<Movie> movies = movieRepository.findByOrderByYearDesc();
        return movieListMapper.convert(movies);
    }

    @Override
    public void createMovie(CreateMovieDto createMovieDto) {
        Movie movie = movieMapper.convert(createMovieDto);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        movieOptional.ifPresent(movieRepository::delete);
    }

    @Override
    public MovieCounterDto countMovies() {
        return movieCounterMapper.convert(movieRepository.count());
    }
}

