package com.datastreams.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastreams.project.vo.BoardVO;
import com.datastreams.project.vo.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	 public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BoardVO> boardList(PagingVO pagingVO) {
		System.out.println("BoardDAOImpl boardList()");
		return sqlSession.selectList("board.boardlist", pagingVO);
	}

	@Override
	public BoardVO boardDetail(int test) {
		System.out.println("BoardDAOImpl boardDetail()");
		return sqlSession.selectOne("board.boarddetail", test);
	}

	@Override
	public void boardUpHits(int test) {
		System.out.println("BoardDAOImpl boardUpHits()");
		sqlSession.update("board.boarduphit",test);
	}

	@Override
	public void boardUpdate(BoardVO boardVO) {
		System.out.println("BoardDAOImpl boardUpdate");
		sqlSession.update("board.boardupdate", boardVO);
	
	}

	@Override
	public int boardInsert(BoardVO boardVO) {
		System.out.println("BoardDAOImpl boardUpdate");
		return sqlSession.insert("board.boardinsert", boardVO);
	}

	@Override
	public void boardDelete(int test) {
		System.out.println("BoardDAOImpl boardDelete");
		sqlSession.delete("board.boarddelete", test);
	}

	@Override
	public int boardCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.boardcount");
	}
}
