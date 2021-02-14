package dev.tkhm.graphbff.domain.services;

import dev.tkhm.graphbff.domain.model.Dummy1;

import java.util.Collection;

public interface Dummy1Repository {
    Collection<Dummy1> allDummies();
    void remove(Dummy1 dummy);
    void save(Dummy1 dummy);
}
