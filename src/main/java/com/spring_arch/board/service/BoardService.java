package com.spring_arch.board.service;

import java.util.List;

import com.spring_arch.board.dto.BoardDto;

public interface BoardService {
	List<BoardDto> getBoardList() throws Exception;
	
	long setInsertArticleWrite(BoardDto boardDto) throws Exception;
	
	BoardDto getArticle(Integer articleId) throws Exception;

	long deleteArticle(String getArticleIds) throws Exception;
}
