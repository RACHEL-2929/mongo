package com.syi.project.controller.chat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syi.project.model.chat.ChatRoomVO;
import com.syi.project.model.member.MemberVO;
import com.syi.project.service.chat.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // @Controller와 @ResponseBody의 조합, 컨트롤러 클래스가 JSON이나 XML 형태로 응답을 반환하도록 한다,//
				// RESTful 웹 서비스를 쉽게 구현
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chatroom")
public class ChatRoomController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ChatController.class);

	private final ChatService chatService;

	// 채팅 리스트 화면
	@GetMapping("/")
	public ResponseEntity<ResultResponse<List<ChatRoomVO>>> goChatRoom() {
		List<ChatRoomVO> chatRooms = chatService.findAllChatRoom();
		ResultResponse<List<ChatRoomVO>> response = ResultResponse.of(true, // 성공 여부
				"Chat rooms fetched successfully", // 메시지
				chatRooms // 데이터
		);
		return ResponseEntity.ok(response);

	}

	/*
	 * @GetMapping("/main") public String chatRoomGET(HttpServletRequest request,
	 * Model model) { // 세션에서 학생번호 가지고 오기 HttpSession session =
	 * request.getSession(); MemberVO loginMember = (MemberVO)
	 * session.getAttribute("loginMember"); int chatRoomMemberNo =
	 * loginMember.getMemberNo();
	 * 
	 * // 채팅방 목록 뿌리기 List<ChatRoomVO> chatRoomList = //
	 * chatService.selectChatRoomList(chatRoomMemberNo);
	 * 
	 * // 메시지 뿌리기
	 * 
	 * // model.addAttribute("chatRoomList", chatRoomList); //
	 * model.addAttribute("", return "redirect:/chatroom/main"; }
	 */

	// 채팅방 생성
	@GetMapping("/room") // =>PostMapping으로 바꾸자
	public ResponseEntity<ResultResponse<String>> createRoom(@RequestParam String name) {
		ChatRoomVO room = chatService.createChatRoom(name);
		ResultResponse<String> response = ResultResponse.of(true, // 성공 여부
				"Chat rooms fetched successfully", // 메시지
				room.getChatRoomNo() // 데이터
		);
		return ResponseEntity.ok(response);
	}

	// 채팅에 참여한 유저 리스트 반환
	@GetMapping("/userlist")
	public ArrayList<String> userList(String chatRoomNO) {
		return chatService.getUserList(chatRoomNO);
	}

	/*
	 * @PostMapping public ChatRoomVO createChatRoom(@RequestBody String
	 * chatRoomName) { return chatService.createChatRoom(chatRoomName); }
	 * 
	 * 
	 * @GetMapping public List<ChatRoomVO> findAllChatRoom(){ return
	 * chatService.findAllChatRoom(); }
	 */

	/*
	 * // chatRoom 입장(채팅방 화면 보여주기)
	 * 
	 * @GetMapping("/main") public void chatRoomGET(HttpServletRequest request,
	 * Model model) { logger.info("chatRoomGET() 진입....");
	 * 
	 * // 세션에서 학생번호 가지고 오기 HttpSession session = request.getSession(); MemberVO
	 * loginMember = (MemberVO) session.getAttribute("loginMember"); int
	 * chatRoomMemberNo = loginMember.getMemberNo();
	 * 
	 * // 채팅방 목록 뿌리기 List<ChatRoomVO> chatRoomList =
	 * chatService.selectChatRoomList(chatRoomMemberNo);
	 * 
	 * // 메시지 뿌리기
	 * 
	 * model.addAttribute("chatRoomList", chatRoomList); // model.addAttribute("",
	 * );
	 * 
	 * }
	 * 
	 * // 채팅방 개설
	 * 
	 * @PostMapping("/create") public String createChatRoomPost(HttpServletRequest
	 * request, ChatRoomVO chatRoom, RedirectAttributes rttr) {
	 * logger.info("createChatRoomPost() 진입....");
	 * 
	 * // jsp에서 수강테이블로 선택한 chatRoomAdminNo 가지고 오기 // chatRoom에 이미 설정되어 있음
	 * 
	 * // 수강생 번호 HttpSession session = request.getSession(); MemberVO loginMember =
	 * (MemberVO) session.getAttribute("loginMember"); int chatRoomMemberNo =
	 * loginMember.getMemberNo();
	 * 
	 * //chatRoom.setChatRoomMemberNo(chatRoomMemberNo);
	 * 
	 * // 담당자와 수강생은 같음, but, 반이 다름 => charRoomNo도 다름 // count가 0 보다 크면 이미 있는 채팅방 int
	 * count = chatService.selectCountByMemberNoAndAdminNo(chatRoom); if(count > 0)
	 * { //이미 채팅방이 개설되어 있음 rttr.addAttribute("result", "이미 채팅방이 존재합니다."); }else
	 * {//개설된 채팅방 없음 chatService.insertChatRoom(chatRoom);
	 * rttr.addAttribute("result", "채팅방이 개설되었습니다"); }
	 * 
	 * return "redirect:/chatroom/main"; }
	 * 
	 * 
	 * 
	 * // 모달로 보내는 데이터
	 * 
	 * @GetMapping("/choice/admin") public void choiceAdminGET(HttpServletRequest
	 * request, Model model) { // 세션에서 회원번호 가져오기 HttpSession session =
	 * request.getSession(); MemberVO loginMember = (MemberVO)
	 * session.getAttribute("loginMember"); int chatRoomMemberNo =
	 * loginMember.getMemberNo();
	 * 
	 * // 회원번호로 수강테이블에서 수강하는 클래스 번호 리스트로 가지고 오기 List<EnrollVO> enrollList =
	 * chatService.selectEnrollListByMemberNo(chatRoomMemberNo);
	 * 
	 * // 클래스 번호에 따른 담당자명, 담당자 코드, 클래스 명 가지고 오기 List<SyclassVO> classList = new
	 * ArrayList<>(); int previousAdminNo = 0;
	 * 
	 * for (EnrollVO enrollVO : enrollList) {
	 * 
	 * SyclassVO syclass = chatService.selectClassByClassNo(enrollVO.getClassNo());
	 * 
	 * // adminNo를 오름차순으로 정렬해서 가지고 오기 // 담당자 번호가 같으면 나머지 enrollVo에서 담당자명 지우기 if
	 * (syclass.getAdminNo() == previousAdminNo) { syclass.setManagerName(""); }
	 * previousAdminNo = syclass.getAdminNo();
	 * 
	 * classList.add(syclass); } model.addAttribute("classList", classList); }
	 */
}