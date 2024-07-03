package be.abalon.jobs;

import be.abalon.services.ZSmartMonitoringService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MonitoringJobs {

    @Inject
    ZSmartMonitoringService zSmartMonitoringService;

    private static final Logger log = LoggerFactory.getLogger(MonitoringJobs.class);

    @Scheduled(cron = "{monitoring.zsmart.cron.expr}")
    void zSmartJobs() {
        log.info("ZSmart monitoring started");
        zSmartMonitoringService.monitor();
    }

    // TODO: Create Cleaning Jobs controllers and define rules to not delete data that is still in use

    @Scheduled(cron = "{monitoring.telecomApi.cron.expr}")
    void telecomApiJobs() {
        log.info("Telecom API monitoring started");
    }
}