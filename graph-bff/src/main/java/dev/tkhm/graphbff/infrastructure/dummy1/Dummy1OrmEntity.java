package dev.tkhm.graphbff.infrastructure.dummy1;

import dev.tkhm.graphbff.domain.model.Dummy1;
import io.quarkus.agroal.DataSource;
import io.quarkus.hibernate.orm.PersistenceUnit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy1")
public class Dummy1OrmEntity {
    @Id
    public String id;
}
