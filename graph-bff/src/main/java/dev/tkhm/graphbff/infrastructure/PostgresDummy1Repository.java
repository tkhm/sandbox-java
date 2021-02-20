package dev.tkhm.graphbff.infrastructure;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dev.tkhm.graphbff.domain.model.Dummy1;
import dev.tkhm.graphbff.domain.services.Dummy1Repository;
import dev.tkhm.graphbff.infrastructure.dummy1.Dummy1OrmEntity;
import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
@Default
public class PostgresDummy1Repository implements Dummy1Repository {
    @Inject
    @PersistenceUnit("dummy1")
    EntityManager em;

    @Override
    public Collection<Dummy1> allDummies() {
        try {
            TypedQuery<Dummy1OrmEntity> dummy1Query = em
                    .createQuery("SELECT dummy1 FROM Dummy1OrmEntity dummy1", Dummy1OrmEntity.class);
            Collection<Dummy1> dummyEntities = dummy1Query.getResultList()
                    .stream()
                    .map(each -> each.toModel()).collect(Collectors.toList());
            return dummyEntities;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void remove(final Dummy1 dummy) {
    }

    @Override
    public void save(final Dummy1 dummy) {
    }
}
