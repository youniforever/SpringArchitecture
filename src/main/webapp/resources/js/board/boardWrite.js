$(function() {
	$(".btnSave").click(function() {
		if ( ! validForm() ) {
			return false;
		}
		
		$.ajax({
			url: "/bbs/write.json",
			type: "POST",
			data: $(".frmBoardWrite").serialize(),
			dataType: "json",
			success: function(json) {
				alert("저장됐습니다.");
				location.href = "/bbs/" + json.data.articleId + "/detail.do";
			},
			error: function(responseText) {
				
			}
		});
	});
	
	$(".btnCancel").click(function() {
		location.href = "/bbs/list.do";
	});
});

function validForm() {
	var inpTitle = $("input[name=title]");
	var inpContent = $("textarea[name=content]");
	
	if ( ! isNull(inpTitle) ) {
		alert("제목을 입력해주세요.");
		inpTitle.focus();
		return false;
	}
	
	if ( ! isNull(inpContent) ) {
		alert("내용을 입력해주세요.");
		inpContent.focus();
		return false;
	}
	
	return true;
}

function isNull(obj) {
	var validResult = true;
	
	if ( typeof obj == "undefined" ) {
		validResult = false;
	}
	
	if ( obj.val() == "" ) {
		validResult = false;
	}
	
	return validResult;
}