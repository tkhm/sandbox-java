package dev.tkhm.graphbff.domain.services;

import dev.tkhm.graphbff.domain.model.Dummy2;

import java.util.Collection;

public interface Dummy2Repository {
    Collection<Dummy2> allDummies();
    void remove(Dummy2 dummy);
    void save(Dummy2 dummy);
}
