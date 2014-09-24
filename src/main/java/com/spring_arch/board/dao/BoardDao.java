package com.spring_arch.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.spring_arch.board.dto.BoardDto;

@Repository("BoardDao")
public class BoardDao {
	
	@Resource(name = "userSqlSessionFactory")
	SqlSessionTemplate userSqlSessionFactory;
	
	public List<BoardDto> getBoardList() {
		return userSqlSessionFactory.selectList("sql.board.select.selectBoardList");
	}
	
	public long insertArticle(BoardDto boardDto) {
		userSqlSessionFactory.insert("sql.board.insert.insertArticle", boardDto);
		
		return boardDto.getArticleId();
	}

	public BoardDto getArticle(Integer articleId) {
		return userSqlSessionFactory.selectOne("sql.board.select.selectArticle", articleId);
	}

	public long deleteArticle(String articleIds) {
		return userSqlSessionFactory.delete("sql.board.delete.deleteArticle", articleIds);
	}

	public void updateArticle(BoardDto boardDto) {
		userSqlSessionFactory.update("sql.board.insert.updateArticle", boardDto);
	}
}
