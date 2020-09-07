package pl.portfolio.portfolio.domain.converter;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}

