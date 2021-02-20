package dev.tkhm.graphbff.infrastructure.dummy2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.tkhm.graphbff.domain.model.Dummy2;

@Entity
@Table(name = "dummy2")
public class Dummy2OrmEntity {
    public Dummy2OrmEntity() {}
    public Dummy2OrmEntity(Dummy2 dummy2) {
        this.id = dummy2.getId();
    }

    @Id
    public String id;

    public Dummy2 toModel() {
        return new Dummy2().setId(this.id);
    }
}
