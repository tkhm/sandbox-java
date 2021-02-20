package dev.tkhm.graphbff.infrastructure.dummy1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.tkhm.graphbff.domain.model.Dummy1;

@Entity
@Table(name = "dummy1")
public class Dummy1OrmEntity {
    public Dummy1OrmEntity() {}
    public Dummy1OrmEntity(Dummy1 dummy1) {
        this.id = dummy1.getId();
    }

    @Id
    public String id;

    public Dummy1 toModel() {
        return new Dummy1().setId(this.id);
    }
}
