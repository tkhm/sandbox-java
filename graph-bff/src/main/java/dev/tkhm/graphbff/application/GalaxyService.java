package dev.tkhm.graphbff.application;

import dev.tkhm.graphbff.domain.model.Film;
import dev.tkhm.graphbff.domain.model.Hero;
import dev.tkhm.graphbff.domain.services.FilmRepository;
import dev.tkhm.graphbff.domain.services.HeroRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.stream.Collectors;

@ApplicationScoped
public class GalaxyService {

    @Singleton
    @Default
    FilmRepository filmRepo;

    @Singleton
    @Default
    HeroRepository heroRepo;

    public GalaxyService() {
    }

    public Collection<Film> getAllFilms() {
        return filmRepo.allFilms();
    }

    public Film getFilm(int id) {
        return filmRepo.filmOfId(id);
    }

    public Collection<Hero> getHeroesByFilm(Film film) {
        return heroRepo.allHeroes().stream()
                .filter(hero -> hero.getEpisodeIds().contains(film.getEpisodeID()))
                .collect(Collectors.toList());
    }

    public void addHero(Hero hero) {
        heroRepo.save(hero);
    }

    public Collection<Hero> getHeroesBySurname(String surname) {
        return heroRepo.allHeroes().stream()
                .filter(hero -> hero.getSurname().equals(surname))
                .collect(Collectors.toList());
    }
}
