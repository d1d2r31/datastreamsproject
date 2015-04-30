package com.datastreams.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastreams.project.dao.BoardDAO;
import com.datastreams.project.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public List<BoardVO> boardList() {
		System.out.println("service boardList()");
		return boardDAO.boardList();
	}

	public BoardVO boardDetail(int test) {
		System.out.println("service boardDetail()");
			return boardDAO.boardDetail(test);
	}

	public void upHits(int test) {
		System.out.println("service uphits()");
		boardDAO.boardUpHits(test);
	}

	public void boardUpdate(BoardVO boardVO) {
		System.out.println("service boardUpdate()");
		boardDAO.boardUpdate(boardVO);
	}

	public int boardInsert(BoardVO boardVO) {
		System.out.println("service boardInsert()");		
		return boardDAO.boardInsert(boardVO);
	}

	public void boardDelete(int test) {
		System.out.println("service boardDelete()");
		boardDAO.boardDelete(test);
	}
}
