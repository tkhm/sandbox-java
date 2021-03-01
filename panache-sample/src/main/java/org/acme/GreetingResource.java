package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/greetings")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGreetings() {
        return String.valueOf(greetingService.fetchAllGreetings().size());
    }

    // it must be POST, but atm I'll use this as POST
    @GET
    @Path("/greetings/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void postGreetingsId(@PathParam("id") String id) {
        greetingService.addGreeting(id);
    }
}