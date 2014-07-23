$(function() {
	$(".btnModify").click(function() {
		location.href = "/bbs/" + articleId + "/mod.do";
	});
	
	$(".btnList").click(function() {
		location.href = "/bbs/list.do";
	});
});