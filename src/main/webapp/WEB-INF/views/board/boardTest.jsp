<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/common_header.jsp" %>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.min.js"></script>
<script src="/js/board/boardController.js"></script>

<!-- 
<script src="/js/board/boardList.js"></script>
-->
<style type="text/css">
.disabled {
	color: #999;
	background-color: #fff;
	border-color: #ddd;
	cursor: not-allowed;
}
</style>


<div ng-app="boardApp" ng-controller="BoardController">
	<div class="page-header">
	  <h3>게시글 목록</h3>
	</div>

	<div class="view">
	    <input type="text" class="input-medium search-query" ng-model="filtList">
	    <select ng-model="orderPropList">
			<option value="">정렬선택</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="name">이름</option>
			<option value="insertDate">작성일</option>
			<option value="fileSize">파일여부</option>
		</select>
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
			<tr ng-repeat="article in list | filter:filtList | orderBy:orderPropList">
				<td><input type="checkbox" class="chkIdx" name="chkbxBoardRowId" value="${boardRow.articleId }"></td>
				<td>{{article.title}}</td>
				<td>{{article.content}}</td>
				<td>{{article.name}}</td>
				<td>{{article.insertDateDt}}</td>
				<td><img src="{{article.fileSize | filtIsFile}}" ng-if="article.fileSize > 0" /></td>
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
</div>

</body>
</html>