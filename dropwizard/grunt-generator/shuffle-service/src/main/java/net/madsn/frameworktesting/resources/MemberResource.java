package net.madsn.frameworktesting.resources;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.params.BooleanParam;
import io.dropwizard.jersey.params.DateTimeParam;
import io.dropwizard.jersey.params.IntParam;
import io.dropwizard.jersey.params.LongParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Member")
public class MemberResource {

    private static final Logger LOG = LoggerFactory.getLogger(MemberResource.class);

    
    @Path("/members")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed 
    public String list(
        
        
        ) {
        StringBuilder sb = new StringBuilder();
        sb.append("Received parameters:\n");
        
        return sb.toString();
    }
    
    @Path("/members/{memberId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed 
    public String show(
        
        @PathParam("memberId") String memberId
        ) {
        StringBuilder sb = new StringBuilder();
        sb.append("Received parameters:\n");
        
        sb.append("memberId=");
        sb.append(memberId);
        sb.append("\n");
        
        return sb.toString();
    }
    
    @Path("/members/new")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Timed 
    public String create(
        
        @FormParam("name") String name,
        @FormParam("initials") String initials
        ) {
        StringBuilder sb = new StringBuilder();
        sb.append("Received parameters:\n");
        
        sb.append("name=");
        sb.append(name);
        sb.append("\n");
        
        sb.append("initials=");
        sb.append(initials);
        sb.append("\n");
        
        return sb.toString();
    }
    
}
