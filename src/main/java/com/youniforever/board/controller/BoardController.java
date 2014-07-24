package com.youniforever.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youniforever.board.dto.BoardDto;
import com.youniforever.board.service.BoardService;
import com.youniforever.common.lib.message.MessageCode;
import com.youniforever.common.lib.message.MessageSetter;

@Controller
public class BoardController {
	@Resource(name = "MessageSetter")
	private MessageSetter messageSetter;
	
	@Resource(name = "BoardService")
	private BoardService boardService;
	
	@Value("${common.upload.dir}")
	private String uploadDir;
	
	@RequestMapping(value="/bbs/list.do")
	public String loadList(HttpServletRequest request, Model model) throws Exception {
		List<BoardDto> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/bbs/write.do")
	public String loadWrite(Model model) throws Exception {
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/bbs/{articleId}/mod.do")
	public String loadModify(Model model, @PathVariable(value="articleId") Integer articleId) throws Exception {
		BoardDto articleInfo = new BoardDto();
		
		articleInfo = boardService.getArticle(articleId);
		
		model.addAttribute("articleInfo", articleInfo);
		
		return "board/boardModify";
	}
	
	@RequestMapping(value="/bbs/write.json", method=RequestMethod.POST)
	public String writeArticle(Model model, BoardDto boardDto) throws Exception {
		long articleId = boardService.setInsertArticleWrite(boardDto);

		HashMap<String,Object> data = new HashMap<String,Object>();
		data.put("articleId", articleId);

		messageSetter.message0000(model, data);
		
		return "redirect:/bbs/" + articleId + "/detail.do";
	}
	
	@RequestMapping(value="/bbs/{articleId}/detail.do")
	public String loadDetail(Model model, @PathVariable(value="articleId") Integer articleId) throws Exception {
		BoardDto articleInfo = boardService.getArticle(articleId);
		File file = new File(uploadDir + "/" + articleId);
		boolean isFile = file.isFile();
		
		model.addAttribute("articleInfo", articleInfo);
		model.addAttribute("isFile", isFile);
		return "board/boardDetail";
	}
	
	@RequestMapping(value="/bbs/delete.json", method=RequestMethod.POST)
	public String delArticle(Model model, HttpServletRequest request) throws Exception {
		String getArticleIds = request.getParameter("articleIds");
		
		long result = boardService.deleteArticle(getArticleIds);

		if ( result > 0 ) {
			messageSetter.message0000(model);
		}
		else {
			messageSetter.messageSet(model, MessageCode.result1000, "", "");
		}
		
		return "jsonViewer";
	}
	
	@RequestMapping(value="/bbs/{articleId}/download", method=RequestMethod.GET)
	public String downloadFile(Model model, HttpServletRequest request, @PathVariable int articleId) throws Exception {
		BoardDto articleInfo = boardService.getArticle(articleId);
		
		model.addAttribute("originalFileName", articleInfo.getFileName());
		model.addAttribute("downloadFile", new File(uploadDir + "/" + articleId));
		return "download";
	}
}
