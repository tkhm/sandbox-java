package dev.tkhm.graphbff.presentation;

import dev.tkhm.graphbff.domain.model.Film;
import dev.tkhm.graphbff.application.GalaxyService;
import dev.tkhm.graphbff.domain.model.Hero;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import java.util.Collection;

@GraphQLApi
public class FilmResource {

    @Inject
    GalaxyService service;

    @Query("allFilms")
    @Description("Get all Films from a galaxy far far away")
    public Collection<Film> getAllFilms() {
        return service.getAllFilms();
    }

    @Query
    @Description("Get a Films from a galaxy far far away")
    public Film getFilm(@Name("filmId") int id) {
        return service.getFilm(id);
    }

    @Query
    public Collection<Hero> heroes(@Source Film film) {
        return service.getHeroesByFilm(film);
    }

    @Query
    public Collection<Hero> getHeroesWithSurname(@DefaultValue("Skywalker") String surname) {
        return service.getHeroesBySurname(surname);
    }

    @Mutation
    public Hero createHero(Hero hero) {
        service.addHero(hero);
        return hero;
    }
}