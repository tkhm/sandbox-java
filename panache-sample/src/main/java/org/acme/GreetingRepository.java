package org.acme;

import java.util.Collection;

public interface GreetingRepository {
    public Collection<GreetingModel> allGreetings();
    public void save(GreetingModel greeting);
}
