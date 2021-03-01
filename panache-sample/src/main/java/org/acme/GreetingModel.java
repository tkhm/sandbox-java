package org.acme;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GreetingModel {
    @Id
    public String id;
}
