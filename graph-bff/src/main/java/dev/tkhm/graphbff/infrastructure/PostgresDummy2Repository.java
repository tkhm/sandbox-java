package dev.tkhm.graphbff.infrastructure;

import dev.tkhm.graphbff.domain.model.Dummy1;
import dev.tkhm.graphbff.domain.model.Dummy2;
import dev.tkhm.graphbff.domain.services.Dummy2Repository;

import dev.tkhm.graphbff.infrastructure.dummy2.Dummy2OrmEntity;
import io.quarkus.hibernate.orm.PersistenceUnit;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@ApplicationScoped
@Default
public class PostgresDummy2Repository implements Dummy2Repository {
    @Inject
    @PersistenceUnit("dummy2")
    EntityManager em;

    @Override
    public Collection<Dummy2> allDummies() {
        try {
            TypedQuery<Dummy2OrmEntity> dummy2Query = em
                    .createQuery("SELECT dummy2 FROM Dummy2OrmEntity dummy2", Dummy2OrmEntity.class);
            Collection<Dummy2> dummyEntities = dummy2Query.getResultList()
                    .stream()
                    .map(each -> {
                        return new Dummy2().setId(each.id);
                    }).collect(Collectors.toList());
            return dummyEntities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void remove(final Dummy2 dummy) {

    }

    @Override
    public void save(final Dummy2 dummy) {

    }
}
