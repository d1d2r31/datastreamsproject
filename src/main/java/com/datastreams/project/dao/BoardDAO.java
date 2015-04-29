package com.datastreams.project.dao;

import java.util.List;

import com.datastreams.project.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> boardList();

	BoardVO boardDetail(int test);

	void boardUpHits(int test);

	void boardUpdate(BoardVO boardVO);

	int boardInsert(BoardVO boardVO);

	void boardDelete(int test);

}
