package com.packtpub.mjbeap7.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by foogaro on 07/02/16.
 */
@Path("/whoami")
public class Endpoint {

    @Inject
    private Service service;

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Response whoamiLocally() {
        return Response.status(Response.Status.OK).entity(new Wrapper(service.whoamiLocally())).build();
    }

    @GET
    @Path("/remotely")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Response whoamiRemotely() {
        return Response.status(Response.Status.OK).entity(new Wrapper(service.whoamiRemotely())).build();
    }

    @GET
    @Path("/stats")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public Response stats() {
        return Response.status(Response.Status.OK).entity(new Wrapper(service.stats())).build();
    }

}
