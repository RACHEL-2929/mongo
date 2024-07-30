package com.vam.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	private static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);

	@GetMapping("join")
	public void joinGET() {
		logger.info("회원가입 페이지 진입");
	}

	@GetMapping("login")
	public void loginGET() {
		logger.info("로그인 페이지 진입");
	}

	@PostMapping("join")
	public String joinPOST(MemberVO member) throws Exception {
		/*
		 * logger.info("join 진입"); memberService.memberJoin(member);
		 * logger.info("join Service 성공");
		 */

		String rawPw = "";
		String encodePw = "";

		rawPw = member.getMemberPw();
		encodePw = pwEncoder.encode(rawPw);
		member.setMemberPw(encodePw);

		memberService.memberJoin(member);

		return "redirect:/main";

	}

	@PostMapping("/memberIdChk")
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		// logger.info("memberIdChk() 진입");
		int result = memberService.idCheck(memberId);
		logger.info("결과값 = " + result);

		if (result != 0) {
			return "fail";// 중복 아이디 있음
		} else {
			return "success";// 중복 아이디 없음
		}
	}

	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheckGET(String email) {
		// 뷰로부터 넘어온 데이터 확인
		logger.info("이메일 데이터 전송 확인");
		logger.info("이메일 : " + email);

		// 인증 번호(난수) 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호 : " + checkNum);

		// 이메일 보내기
		String setFrom = "@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 가입하여 주세요.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String num = Integer.toString(checkNum);
		return num;
	}

	@PostMapping("/login.do")
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {
		/*
		 * System.out.println("login 메서도 진입"); System.out.println("전달된 데이터 : " +
		 * member);
		 */

		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";

		MemberVO lvo = memberService.memberLogin(member);
		if (lvo != null) {

			rawPw = member.getMemberPw();
			encodePw = lvo.getMemberPw();

			if (pwEncoder.matches(rawPw, encodePw) == true) {
				lvo.setMemberPw("");
				session.setAttribute("member", lvo);
				return "redirect:/main";
			} else {
				rttr.addFlashAttribute("result", 0);
				return "redirect:/member/login";
			}

		} else {
			rttr.addFlashAttribute("result", 0);
			return "redirect:/member/login";

		}

	}

	
	/* 비동기방식 로그아웃 메서드 */
	@PostMapping("/logout.do")
	@ResponseBody
    public void logoutPOST(HttpServletRequest request){
        
        logger.info("비동기 로그아웃 메서드 진입");
        
        request.getSession().invalidate();
        
    }
    
    
	/* 메인페이지 로그아웃 */
	@GetMapping("/logout.do")
	public String logoutMainGET(HttpServletRequest request){
        
        logger.info("logoutMainGET메서드 진입");
        
        request.getSession().invalidate();
        
        return "redirect:/main";  
    }
	
}