package be.abalon.controllers;

import be.abalon.entities.ApplicationType;
import be.abalon.entities.Monitoring;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/monitoring")
public class MonitoringController {

    @Path("/")
    @GET
    public List<Monitoring> getMonitoring() {
        return Monitoring.listAll();
    }

    @Path("/applications")
    @GET
    public List<ApplicationType> getApplications() {
        return ApplicationType.listAll();
    }
}
