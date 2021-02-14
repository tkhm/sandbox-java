package dev.tkhm.graphbff.domain.services;

import java.util.Collection;
import dev.tkhm.graphbff.domain.model.Film;

public interface FilmRepository {
    Collection<Film> allFilms();
    Film filmOfId(int id);
    void remove(Film film);
    void save(Film film);
}
