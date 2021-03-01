package org.acme;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
@IfBuildProfile("prod")
public class PostgresGreetingRepository implements GreetingRepository, PanacheRepository<GreetingModelDto> {
    @Override
    public Collection<GreetingModel> allGreetings() {
        List<GreetingModel> greetingResultList = new ArrayList<>();
            listAll().forEach(each -> {
                GreetingModel result = new GreetingModel();
                result.id = each.id;
                greetingResultList.add(result);
            });
        return greetingResultList;
    }

    @Override
    @Transactional
    public void save(final GreetingModel greeting) {
        GreetingModelDto modelDto = new GreetingModelDto();
        modelDto.id = greeting.id;
        persist(modelDto);
    }
}
