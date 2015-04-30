package com.datastreams.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.datastreams.project.service.BoardService;
import com.datastreams.project.vo.BoardVO;

@Controller
@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class}) //트랜잭션 설정
@RequestMapping("/board")
public class BoardController {
	
	
	private ModelAndView mav;
	
	@Autowired 
	private BoardService boardService; //서비스 객체 생성 및 autowired 사용
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	int new1 = 0;
	//리스트 페이지
	@RequestMapping(value="/boardList", method = RequestMethod.GET )
	public ModelAndView boardList(){
		
		System.out.println("controller boardList()");
		mav= new ModelAndView();
		mav.addObject("boardList", boardService.boardList());
		mav.setViewName("board/boardlist");
		/*mav.setViewName("jsonView"); */    // JsonView 로 지정해두면 자동으로 json 형식으로 데이터 전달
		return mav;
	}
	//상세보기 페이지
	@RequestMapping(value="/boardDetail", method= RequestMethod.POST)
	public ModelAndView boardDetail(int test){
	
		System.out.println("controller boardDetail()");
		mav = new ModelAndView();	
		boardService.upHits(test);  		// 조회수 증가
		mav.addObject("boardDetail", boardService.boardDetail(test));
		mav.setViewName("board/boarddetail");
		return mav;
	}
	//글작성페이지로 이동
	@RequestMapping(value="/boardInsertPage", method= RequestMethod.POST)
	public ModelAndView boardInsertPage(){
		
		mav.setViewName("board/boardwrite");
		return mav;
	}
	//글작성 완료
	/*
		@Validated 사용으로 server 단에서 유효성검사
		validate 관련 디펜던시 추가
		<annotaion-driven> 으로 인해 글로벌 validator로 등록
	 */
	@RequestMapping(value="/boardInsert", method= RequestMethod.POST)
	public ModelAndView boardInsert( @Validated BoardVO boardVO, Errors errors){ 
	
		if(errors.hasErrors()){
			return mav;
		}
		System.out.println("controller boardInsert()"); //insertCheck가 0 이아니면 작성 값들을 받아와 글 작성기능 실행
		int insertok=boardService.boardInsert(boardVO);
		 boardDetail(boardVO.getTest());    //글 등록 완료후 해당글 상세보기를 하기 위해 db에 반영된 객체 사용
		 // mybatis mapper.xml 에서 쿼리문에 selectKey를 이용하여 db에 저장된 값을 객체에 저장해서 반환
		if(insertok==1){
			new1++;
		}
		return mav;
	}
	//글삭제 
	@RequestMapping(value="/boardDelete", method= RequestMethod.POST)
	public ModelAndView boardDelete(int test){
		
			System.out.println("controller boardDelete()");
			boardService.boardDelete(test);
			boardList();
		return mav;
		
	}
	//글수정페이지
	@RequestMapping(value="/boardUpdate", method= RequestMethod.POST)
	public ModelAndView boardUpdate(int updateCheck, BoardVO boardVO){
		
		System.out.println("controller boardUpdate()");
		if(updateCheck==1){
			mav.setViewName("board/boardupdate");
			return mav;
		}
			boardService.boardUpdate(boardVO);
			boardDetail(boardVO.getTest());
		return mav;
	}
	
	@RequestMapping(value="/boardNew", method= RequestMethod.GET)
	@ResponseBody
	public String boardNew(){
		
				String kkk = String.valueOf(new1);
		return kkk;
	}
	
	//로그아웃
	@RequestMapping(value="/logOut", method= RequestMethod.POST)
	@ResponseBody
	public String logOut(HttpSession httpSession, String name){
		
		if(name.equals(httpSession.getAttribute("user"))){
		httpSession.removeAttribute("user");
			return "home";
		}
		return "home";
	}
}
