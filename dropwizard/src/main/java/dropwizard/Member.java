package dropwizard;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {

	private long id;

    @Length(max = 10)
    private String initials;

    @Length(max = 20)
    private String name;
    
    public Member(String initials, String name){
    	this.name = name;
    	this.initials = initials;
    }
    
    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
    
    @JsonProperty
    public String getInitials() {
        return initials;
    }
}
