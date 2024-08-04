package com.syi.project.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syi.project.mapper.member.MemberMapper;
import com.syi.project.model.member.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;

	// 로그인
	@Override
	public MemberVO selectLoginMember(MemberVO member) {
		return memberMapper.selectLoginMember(member);
	}

}
