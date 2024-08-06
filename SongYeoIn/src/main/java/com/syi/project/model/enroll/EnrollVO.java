package com.syi.project.model.enroll;

import com.syi.project.model.member.MemberVO;

import lombok.Data;

@Data
public class EnrollVO {

	
	private int enrollNo;
	private int classNo;
	private int memberNo;
	private MemberVO member;
}