package org.acme;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.arc.profile.UnlessBuildProfile;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
@IfBuildProfile("prod")
public class PostgresGreetingRepository implements GreetingRepository {
    @Inject
    EntityManager em;

    @Override
    public Collection<GreetingModel> allGreetings() {
        TypedQuery<GreetingModelDto> fetchQuery = em
                .createQuery("SELECT greeting FROM GreetingModelDto greeting", GreetingModelDto.class);
        Collection<GreetingModelDto> greetings = new ArrayList<>(fetchQuery.getResultList());
        List<GreetingModel> greetingResultList = new ArrayList<>();
        greetings.forEach(each -> {
            GreetingModel result = new GreetingModel();
            result.id = each.id;
            greetingResultList.add(result);
        });
        return greetingResultList;
    }

    @Override
    public void save(final GreetingModel greeting) {
        GreetingModelDto modelDto = new GreetingModelDto();
        modelDto.id = greeting.id;
        em.persist(modelDto);
    }
}
