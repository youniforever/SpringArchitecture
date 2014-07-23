<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/common_header.jsp" %>

<script src="/js/board/boardList.js"></script>

<div class="page-header">
  <h3>게시글 목록</h3>
</div>

<table class="table table-bordered bbsList">
	<colgroup>
		<cols style="width: 30px;"></cols>
		<cols style="width: 40%;"></cols>
		<cols style="width: 8%;"></cols>
		<cols style="width: 10%;"></cols>
		<cols style="width: 30px;"></cols>
		<cols style="width: *;"></cols>
	</colgroup>
	<thead>
		<tr>
			<th><input type="checkbox" class="chkAll"></th>
			<th>제목</th>
			<th>내용</th>
			<th>이름</th>
			<th>작성일</th>
			<th>파일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="boardRow" items="${boardList}" varStatus="status">
		<tr>
			<td><input type="checkbox" class="chkIdx" name="chkbxBoardRowId" value="${boardRow.articleId }"></td>
			<td><a href="/bbs/${boardRow.articleId }/detail.do" target="_self">${boardRow.title }</a></td>
			<td>${boardRow.content }</td>
			<td>${boardRow.name }</td>
			<td>${boardRow.insertDateDt }</td>
			<td>
				<c:if test="${boardRow.fileSize > 0 }">
					<span class="glyphicon glyphicon-save"></span>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		<tr class="hide noResult">
			<td colspan="5">작성된 게시글이 없습니다.</td>
		</tr>
	</tbody>
</table>

<p class="text-right">
	<button type="button" class="btn btn-default btnDel">삭제</button>
	<button type="button" class="btn btn-success btnWrite">글쓰기</button>
</p>

<div class="text-center">
	<ul class="pagination">
		<li><a href="javascript: void(0);">&laquo;</a></li>
		<li><a href="javascript: void(0);">1</a></li>
		<li><a href="javascript: void(0);">&raquo;</a></li>
	</ul>
</div>
