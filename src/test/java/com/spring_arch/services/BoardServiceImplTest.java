package com.spring_arch.services;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.spring_arch.board.dao.BoardDao;
import com.spring_arch.board.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
public class BoardServiceImplTest extends AbstractApplicationContextTest {
	
	@Resource(name = "BoardDao")
	private BoardDao boardDao;
	
	@Value("${common.upload.dir}")
	private String uploadDir;
	
//	@Test
	public void getBoardList() throws Exception {
		
		List<BoardDto> boardDto = boardDao.getBoardList();
		
		int resultListCnt = 0;
		if ( boardDto.size() > 0 ) 
			resultListCnt = 1;
		else
			resultListCnt = 0;
		
		Assert.assertEquals(resultListCnt, 1);
	}
	
	public BoardDto getArticle(Integer articleId) throws Exception {
		return boardDao.getArticle(articleId);
	}
	
	public void setInsertArticleWrite(BoardDto boardDto) throws Exception {
		long articleId = 0;
		
		if ( 0 == boardDto.getArticleId() ) {
			articleId = boardDao.insertArticle(boardDto);
		}
		else {
			boardDao.updateArticle(boardDto);
			articleId = boardDto.getArticleId();
		}
		
		if ( boardDto.getFile() != null && (int) boardDto.getFile().getSize() > 0 ) {
			moveUploadFile(boardDto.getFile(), articleId);
		}
		
	}
	
	private void moveUploadFile(MultipartFile file, long articleId) throws Exception {
		File tempFileName = new File(uploadDir, String.valueOf(articleId));
		file.transferTo(tempFileName);
	}

	public long deleteArticle(String getArticleIds) throws Exception {
		String[] articleIdArr = getArticleIds.split(",");
		
		File tempFileName = null;
		for ( String articleId : articleIdArr ) {
			tempFileName = new File(uploadDir, articleId);
			tempFileName.delete();
		}
		
		return boardDao.deleteArticle(getArticleIds);
	}
}
