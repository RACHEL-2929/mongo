package com.syi.project.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syi.project.model.member.MemberVO;
import com.syi.project.service.member.MemberServiceImpl;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	/*
	 * @Autowired private BCryptPasswordEncoder bcryptPasswordEncoder;
	 * 
	 * 
	 * @Autowired private MemberServiceImpl memberservice;
	 */
		 
	
	// 로그인 페이지 이동
	@GetMapping("login")
	public void loginGet() {
		logger.info("로그인 페이지 이동");
	}
	
	// 회원가입 페이지 이동
	@GetMapping("join")
	public void joinGet() {
		logger.info("회원가입 페이지 이동");
	}
	
	/*
	 * // 로그인 기능
	 * 
	 * @PostMapping("login") public String loginPost(HttpServletRequest request,
	 * MemberVO requestMember, RedirectAttributes rttr) { HttpSession session =
	 * request.getSession(); String rawPw = ""; String encodePw = "";
	 * 
	 * MemberVO lvo = memberservice.selectLoginMember(requestMember); // 제출한아이디와
	 * 일치하는 아이디 있는지
	 * 
	 * if(lvo != null) { // 일치하는 아이디 존재시
	 * 
	 * rawPw = requestMember.getMemberPwd(); // 사용자가 제출한 비밀번호 encodePw =
	 * lvo.getMemberPwd(); // 데이터베이스에 저장한 인코딩된 비밀번호
	 * 
	 * if(true == bcryptPasswordEncoder.matches(rawPw, encodePw)) { // 비밀번호 일치여부 판단
	 * 
	 * lvo.setMemberPwd(""); // 인코딩된 비밀번호 정보 지움 session.setAttribute("member", lvo);
	 * // session에 사용자의 정보 저장 return "redirect:/main"; // 메인페이지 이동
	 * 
	 * 
	 * } else {
	 * 
	 * rttr.addFlashAttribute("result", 0); return "redirect:/member/login"; // 로그인
	 * 페이지로 이동
	 * 
	 * }
	 * 
	 * } else { // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)
	 * 
	 * rttr.addFlashAttribute("result", 0); return "redirect:/member/login"; // 로그인
	 * 페이지로 이동
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */
 	

}
