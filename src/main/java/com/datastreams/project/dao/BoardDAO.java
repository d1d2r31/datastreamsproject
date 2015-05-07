package com.datastreams.project.dao;

import java.util.List;

import com.datastreams.project.vo.BoardVO;
import com.datastreams.project.vo.PagingVO;

public interface BoardDAO {

	List<BoardVO> boardList(PagingVO pagingVO);

	BoardVO boardDetail(int test);

	void boardUpHits(int test);

	void boardUpdate(BoardVO boardVO);

	int boardInsert(BoardVO boardVO);

	void boardDelete(int test);

	int boardCount();

}
