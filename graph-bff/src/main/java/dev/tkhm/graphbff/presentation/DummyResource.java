package dev.tkhm.graphbff.presentation;

import dev.tkhm.graphbff.application.GalaxyService;
import dev.tkhm.graphbff.domain.model.Dummy1;
import dev.tkhm.graphbff.domain.model.Dummy2;
import dev.tkhm.graphbff.domain.model.Film;
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
public class DummyResource {

    @Inject
    GalaxyService service;

    @Query
    @Description("Get all dummies no.1")
    public Collection<Dummy1> getAllDummies1() {
        return service.getAllDummies1();
    }

    @Query
    @Description("Get all dummies no.2")
    public Collection<Dummy2> getAllDummies2() {
        return service.getAllDummies2();
    }
}