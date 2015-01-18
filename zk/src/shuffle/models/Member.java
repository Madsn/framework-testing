package shuffle.models;

public class Member {
	
	private Integer id;
	
	private String initials;
	
	private String name;
	
	public Member(Integer id, String initials, String name){
		this.id = id;
		this.initials = initials;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
