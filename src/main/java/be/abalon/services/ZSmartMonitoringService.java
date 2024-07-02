package be.abalon.services;

import be.abalon.entities.ApplicationType;
import be.abalon.entities.Monitoring;
import be.abalon.entities.MonitoringStatus;
import be.abalon.remote.ZsmartRemoteService;
import be.abalon.repositories.MonitoringRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@ApplicationScoped
public class ZSmartMonitoringService {

    @Inject
    MonitoringRepository monitoringRepository;

    @Inject
    @RestClient
    ZsmartRemoteService zsmartRemoteService;

    private static final Logger log = LoggerFactory.getLogger(ZSmartMonitoringService.class);

    @Transactional
    public void monitor() {
        try {
            zsmartRemoteService.monitor();
            log.info("ZSmartMonitoringService: {}", MonitoringStatus.UP);
            Monitoring monitoring = new Monitoring();
            monitoring.application = ApplicationType.find("name", "ZSmart").firstResult();
            monitoring.status = MonitoringStatus.UP;
            monitoring.timestamp = LocalDateTime.now();
            monitoringRepository.persist(monitoring);
        } catch (Exception e) {
            log.error("ZSmartMonitoringService: {}", e.getMessage());
            Monitoring monitoring = new Monitoring();
            monitoring.application = ApplicationType.find("name", "ZSmart").firstResult();
            monitoring.status = MonitoringStatus.DOWN;
            monitoring.message = e.getMessage();
            monitoring.timestamp = LocalDateTime.now();
            monitoringRepository.persist(monitoring);
        }

    }
}
