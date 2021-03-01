package org.acme;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.arc.profile.UnlessBuildProfile;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Qualifier;
import java.util.Collection;

@ApplicationScoped
@IfBuildProfile("prod")
public class PostgresGreetingRepository implements GreetingRepository, PanacheRepository<GreetingModel> {
    @Override
    public Collection<GreetingModel> allGreetings() {
        return listAll();
    }

    @Override
    public void save(final GreetingModel greeting) {
        persist(greeting);
    }
}
