<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/common_header.jsp" %>

<script src="/js/board/boardWrite.js"></script>

<div class="page-header">
  <h3>게시글 수정</h3>
</div>

<form method="POST" action="/bbs/write.json" class="form-horizontal frmBoardWrite" role="form" enctype="multipart/form-data">
	<input type="hidden" name="name" value="이태성" />
	<input type="hidden" name="articleId" value="${articleInfo.articleId }" />
	<div class="form-group">
		<label class="col-sm-2 control-label">제목</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="title" value="${articleInfo.title }" placeholder="제목을 입력해주세요.">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">내용</label>
		<div class="col-sm-10">
			<textarea class="form-control" name="content" placeholder="내용을 입력해주세요." rows="6">${articleInfo.content }</textarea>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">파일</label>
		<div class="col-sm-10">
			<input type="file" class="form-control" name="file" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">작성자</label>
		<div class="col-sm-10">
			<p class="form-control-static">이태성</p>
		</div>
	</div>
	
	<p class="text-right">
		<button type="submit" class="btn btn-success btnSave-">저장</button>
		<button type="button" class="btn btn-default btnCancel">취소</button>
	</p>
</form>
