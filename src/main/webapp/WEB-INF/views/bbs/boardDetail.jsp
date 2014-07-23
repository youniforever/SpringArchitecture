<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% pageContext.setAttribute("lineChar", "\n"); %>
<% pageContext.setAttribute("tabChar", "\t"); %>
<% pageContext.setAttribute("spaceChar", " "); %>

<%@ include file="/WEB-INF/views/common/common_header.jsp" %>


<script language="javascript">
articleId = "${articleInfo.articleId}";
</script>
<script src="/js/board/boardDetail.js"></script>

<div class="page-header">
  <h3>게시글 상세</h3>
</div>

<div class="form-horizontal" role="form">
	<input type="hidden" name="name" value="이태성" />
	<div class="form-group">
		<label class="col-sm-2 control-label">제목</label>
		<div class="col-sm-10">
			<p class="form-control-static">
				${articleInfo.title }
			</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">내용</label>
		<div class="col-sm-10">
			<p class="form-control-static">
				<c:set var="content" value="${fn:replace(articleInfo.content, spaceChar, '&nbsp;')}" />
				<c:set var="content" value="${fn:replace(content, lineChar, '<br />')}" />
				${fn:replace(content, tabChar, '&nbsp;&nbsp;&nbsp;&nbsp;')}
			</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">파일</label>
		<div class="col-sm-10">
			<p class="form-control-static">
			<c:choose>
				<c:when test="${isFile != null and isFile != ''}">
					<a href="/bbs/${articleInfo.articleId }/download">${articleInfo.fileName } (<fmt:formatNumber>${articleInfo.fileSize }</fmt:formatNumber> bytes)</a>
				</c:when>
				<c:otherwise>
					업로드된 파일이 없거나 파일이 존재하지 않습니다.
				</c:otherwise>
			</c:choose>
			</p>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">작성자</label>
		<div class="col-sm-10">
			<p class="form-control-static">${articleInfo.name }</p>
		</div>
	</div>
	
	<p class="text-right">
		<button type="button" class="btn btn-success btnModify">수정</button>
		<button type="button" class="btn btn-default btnList">목록</button>
	</p>
</div>
