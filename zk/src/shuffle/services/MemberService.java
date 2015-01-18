package shuffle.services;

import java.util.List;

import shuffle.models.Member;

public interface MemberService {
	 
    /**
     * Retrieve all members
     * @return all members
     */
    public List<Member> findAll();
     
}
