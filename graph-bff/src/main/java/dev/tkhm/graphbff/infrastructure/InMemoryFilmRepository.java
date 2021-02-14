package dev.tkhm.graphbff.infrastructure;

import dev.tkhm.graphbff.domain.model.Film;
import dev.tkhm.graphbff.domain.services.FilmRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ApplicationScoped
@Default
public class InMemoryFilmRepository implements FilmRepository {
    private Map<Integer, Film> store;

    public InMemoryFilmRepository() {
        if (Objects.isNull(this.store)) {
            this.store = new HashMap<>();

            Film aNewHope = new Film();
            aNewHope.setTitle("A New Hope");
            aNewHope.setReleaseDate(LocalDate.of(1977, Month.MAY, 25));
            aNewHope.setEpisodeID(4);
            aNewHope.setDirector("George Lucas");

            Film theEmpireStrikesBack = new Film();
            theEmpireStrikesBack.setTitle("The Empire Strikes Back");
            theEmpireStrikesBack.setReleaseDate(LocalDate.of(1980, Month.MAY, 21));
            theEmpireStrikesBack.setEpisodeID(5);
            theEmpireStrikesBack.setDirector("George Lucas");

            Film returnOfTheJedi = new Film();
            returnOfTheJedi.setTitle("Return Of The Jedi");
            returnOfTheJedi.setReleaseDate(LocalDate.of(1983, Month.MAY, 25));
            returnOfTheJedi.setEpisodeID(6);
            returnOfTheJedi.setDirector("George Lucas");

            this.save(aNewHope);
            this.save(theEmpireStrikesBack);
            this.save(returnOfTheJedi);
        }
    }

    @Override
    public Collection<Film> allFilms() {
        return this.store.values();
    }

    @Override
    public Film filmOfId(final int id) {
        Film film = this.store.getOrDefault(id, null);
        return film;
    }

    @Override
    public void remove(final Film film) {
        this.store.remove(film.getEpisodeID());
    }

    @Override
    public void save(final Film film) {
        this.store.put(film.getEpisodeID(), film);
    }
}
