package com.syi.project.mapper.member;

import com.syi.project.model.member.MemberVO;

public interface MemberMapper {
	
	// 로그인
	public MemberVO selectLoginMember(MemberVO member);

}
