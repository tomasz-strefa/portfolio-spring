package pl.portfolio.portfolio.domain.mapper;

import org.springframework.stereotype.Component;
import pl.portfolio.portfolio.domain.converter.Converter;
import pl.portfolio.portfolio.domain.dto.MovieCounterDto;

@Component
public class MovieCounterMapper implements Converter<Long, MovieCounterDto> {

    @Override
    public MovieCounterDto convert(Long counter) {
        return new MovieCounterDto.Builder()
                .counter(counter)
                .build();
    }
}

