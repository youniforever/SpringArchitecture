error_message = {
		"failLogin": "로그인할 수 없습니다."
};

$(function() {
	$(".btnLogin").click(function() {
		var loginId = $(".loginId").val();
		var loginPassword = $(".loginPassword").val();
		
		if ( loginId.length > 0 && loginPassword.length > 0 ) {
			$.ajax({
				url: "/login.json",
				type: "POST",
				data: {"loginId": loginId, "loginPassword": loginPassword},
				dataType: "json",
				success: function(json) {
					if ( json.result == "0000" ) {
						location.href = "/bbs/list.do";
					}
					else {
						alert("로그인 아이디 또는 비밀번호를 다시 한번 확인해주세요.");
					}
				},
				error: function(responseText) {
					alert("관리자에 문의해주세요.");
				}
			});
		}
		else {
			alert("로그인 아이디와 비밀번호를 입력해주세요.");
			return false;
		}
	});
});

function valid_null(e, rej_msg) {
	if ( e.val() == "" ) {
		alert(rej_msg);
		e.focus();
		return false;
	}
	else {
		return true;
	}
}

function valid_format(e, rej_msg, regex) {
	re = new RegExp(regex, "gi");
	if ( ! re.test(e.val()) ) {
		alert(rej_msg);
		e.focus();
		return false;
	}
	else {
		return true;
	}
}

$(document).ready(function() {
});