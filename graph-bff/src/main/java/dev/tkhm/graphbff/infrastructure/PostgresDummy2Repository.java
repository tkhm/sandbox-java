package dev.tkhm.graphbff.infrastructure;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dev.tkhm.graphbff.domain.model.Dummy2;
import dev.tkhm.graphbff.domain.services.Dummy2Repository;
import dev.tkhm.graphbff.infrastructure.dummy2.Dummy2OrmEntity;
import io.quarkus.hibernate.orm.PersistenceUnit;

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
                    .map(each -> each.toModel()).collect(Collectors.toList());
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
