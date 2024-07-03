package be.abalon.controllers;

import be.abalon.entities.ApplicationType;
import be.abalon.entities.Monitoring;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/monitoring")
public class MonitoringController {

    @Path("/")
    @GET
    public Response getMonitoring() {
        return Response.ok(Monitoring.listAll()).build();
    }

    @Path("/applications")
    @GET
    public List<ApplicationType> getApplications() {
        return ApplicationType.listAll();
    }
}
