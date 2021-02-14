package dev.tkhm.graphbff.infrastructure.dummy2;

import dev.tkhm.graphbff.domain.model.Dummy2;
import io.quarkus.agroal.DataSource;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy2")
public class Dummy2OrmEntity {
    @Id
    public String id;
}
