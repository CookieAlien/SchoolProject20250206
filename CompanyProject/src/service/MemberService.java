package service;

import model.Member;

public interface MemberService {
	//create
	void addMember(Member member);
	//read
	Member login(String username, String password);
	boolean isUsernameTaken(String username);
	//update
	
	//delete
}
