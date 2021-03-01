package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class GreetingService {
    @Singleton
    @Default
    GreetingRepository repo;

    public void addGreeting(String id) {
        GreetingModel greeting = new GreetingModel();
        greeting.id = id;
        repo.save(greeting);
    }

    public List<GreetingModel> fetchAllGreetings() {
        Collection<GreetingModel> greetings = repo.allGreetings();
        return new ArrayList<>(greetings);
    }
}
