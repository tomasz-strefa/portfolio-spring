package pl.portfolio.portfolio.domain.mapper;

import org.springframework.stereotype.Component;
import pl.portfolio.portfolio.domain.converter.Converter;
import pl.portfolio.portfolio.domain.dto.CreateMovieDto;
import pl.portfolio.portfolio.domain.entity.Movie;

@Component
public class MovieMapper implements Converter<CreateMovieDto, Movie> {

    @Override
    public Movie convert(CreateMovieDto createMovieDto) {

        return new Movie.Builder()
                .image(createMovieDto.getImage())
                .title(createMovieDto.getTitle())
                .year(createMovieDto.getYear())
                .build();
    }
}

