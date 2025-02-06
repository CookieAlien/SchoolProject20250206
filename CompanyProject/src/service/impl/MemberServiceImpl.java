package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	public static void main(String[] args) {
		System.out.println(new MemberServiceImpl().isUsernameTaken("chess"));
	}
	
	private static MemberDaoImpl memberDaoImpl = new MemberDaoImpl();

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		memberDaoImpl.add(member);
	}

	@Override
	public Member login(String username, String password) {
		Member member = null;
		List<Member> mList = memberDaoImpl.selectUsernameAndPassword(username, password);
		if (mList.size()!=0) {
			member = mList.get(0);
		}
		return member;
	}

	@Override
	public boolean isUsernameTaken(String username) {
		
		return !memberDaoImpl.selectByUsername(username).isEmpty();
	}

}
