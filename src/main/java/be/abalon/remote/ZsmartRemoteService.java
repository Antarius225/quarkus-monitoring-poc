package be.abalon.remote;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(baseUri = "https://www.githubstatus.com/api/v2/scheduled-maintenances/")
@ApplicationScoped
public interface ZsmartRemoteService {

    @GET
    @Path("/active.json")
    String monitor();

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        if (response.getStatus() != 200) {
            return new RuntimeException("Github status is not available");
        }
        return null;
    }
}
