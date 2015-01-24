package dropwizard;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {
	
    @GET
    @Timed
    public List<Member> getMembers() {
    	List<Member> members = new ArrayList<Member>();
    	members.add(new Member("MIKMA", "Mikkel"));
    	members.add(new Member("JMN", "Jacob"));
        return members;
    }

}
