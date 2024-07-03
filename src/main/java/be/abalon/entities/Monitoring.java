package be.abalon.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Monitoring extends PanacheEntity {
    public LocalDateTime timestamp;
    @ManyToOne
    public ApplicationType application;
    @Enumerated(EnumType.STRING)
    public MonitoringStatus status;
    public String message;
}
