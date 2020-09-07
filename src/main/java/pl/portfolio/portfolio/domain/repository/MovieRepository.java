package pl.portfolio.portfolio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.portfolio.portfolio.domain.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CrudRepository<Movie, Long> {

    @Modifying
    @Query("DELETE FROM Movie m WHERE m.movieId = :movieId")
    void deleteById(@Param("movieId") Long movieId);

    List<Movie> findByOrderByYearDesc();
}

