package be.abalon.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class ApplicationType extends PanacheEntity {
    public String name;
}
