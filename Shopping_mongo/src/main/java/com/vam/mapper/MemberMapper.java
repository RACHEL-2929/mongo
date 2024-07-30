package com.vam.mapper;

import org.springframework.stereotype.Repository;

import com.vam.model.MemberVO;

@Repository
public interface MemberMapper {

	public void memberJoin(MemberVO member);

	public int idCheck(String memberId);

	public MemberVO memberLogin(MemberVO member);
	
}
