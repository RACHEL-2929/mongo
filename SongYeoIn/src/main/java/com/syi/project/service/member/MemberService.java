package com.syi.project.service.member;

import com.syi.project.model.member.MemberVO;

public interface MemberService {
	
	// 로그인
	public MemberVO selectLoginMember(MemberVO member); 

}
