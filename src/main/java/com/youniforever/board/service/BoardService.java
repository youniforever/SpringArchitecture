package com.youniforever.board.service;

import java.util.List;

import com.youniforever.board.dto.BoardDto;

public interface BoardService {
	List<BoardDto> getBoardList() throws Exception;
	
	long setInsertArticleWrite(BoardDto boardDto) throws Exception;
	
	BoardDto getArticle(Integer articleId) throws Exception;

	long deleteArticle(String getArticleIds) throws Exception;
}
