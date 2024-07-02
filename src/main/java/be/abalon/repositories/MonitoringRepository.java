package be.abalon.repositories;

import be.abalon.entities.Monitoring;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MonitoringRepository implements PanacheRepository<Monitoring> {
}
