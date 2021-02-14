package dev.tkhm.graphbff.domain.services;

import dev.tkhm.graphbff.domain.model.Hero;

import java.util.Collection;

public interface HeroRepository {
    Collection<Hero> allHeroes();
    void remove(Hero film);
    void save(Hero film);
}
