package org.acme;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.arc.profile.UnlessBuildProfile;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Qualifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@ApplicationScoped
@Default
@UnlessBuildProfile("prod")
public class InMemoryGreetingRepository implements GreetingRepository {
    private Map<String, GreetingModel> store;

    public InMemoryGreetingRepository() {
        if (Objects.isNull(this.store)) {
            this.store = new HashMap<>();

            // initial sample data
            GreetingModel sample = new GreetingModel();
            sample.id = "Hello";
            this.save(sample);
        }
    }

    @Override
    public Collection<GreetingModel> allGreetings() {
        Set<GreetingModel> entries = new HashSet<>();

        for (GreetingModel greeting : this.store.values()) {
            entries.add(greeting);
        }

        return entries;
    }

    @Override
    public void save(final GreetingModel greeting) {
        this.store.put(greeting.id, greeting);
    }
}
