package dev.tkhm.graphbff.infrastructure;

import dev.tkhm.graphbff.domain.model.Hero;
import dev.tkhm.graphbff.domain.model.LightSaber;
import dev.tkhm.graphbff.domain.services.HeroRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ApplicationScoped
@Default
public class InMemoryHeroRepository implements HeroRepository {
    private Map<String, Hero> store;

    public InMemoryHeroRepository() {
        if (Objects.isNull(this.store)) {
            this.store = new HashMap<>();

            Hero luke = new Hero();
            luke.setName("Luke");
            luke.setSurname("Skywalker");
            luke.setHeight(1.7);
            luke.setMass(73);
            luke.setLightSaber(LightSaber.GREEN);
            luke.setDarkSide(false);
            luke.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

            Hero leia = new Hero();
            leia.setName("Leia");
            leia.setSurname("Organa");
            leia.setHeight(1.5);
            leia.setMass(51);
            leia.setDarkSide(false);
            leia.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

            Hero vader = new Hero();
            vader.setName("Darth");
            vader.setSurname("Vader");
            vader.setHeight(1.9);
            vader.setMass(89);
            vader.setDarkSide(true);
            vader.setLightSaber(LightSaber.RED);
            vader.getEpisodeIds().addAll(Arrays.asList(4, 5, 6));

            this.save(luke);
            this.save(leia);
            this.save(vader);
        }
    }

    @Override
    public Collection<Hero> allHeroes() {
        return this.store.values();
    }

    @Override
    public void remove(final Hero hero) {
        this.store.remove(hero.getName()+hero.getSurname());
    }

    @Override
    public void save(final Hero hero) {
        this.store.put(hero.getName()+hero.getSurname(), hero);
    }
}
