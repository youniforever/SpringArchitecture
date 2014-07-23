$(function() {
	$(".btnWrite").click(function() {
		location.href = "/bbs/write.do";
	});
	
	$(".chkAll").click(function() {
		var isChecked = $(this).prop("checked");
		
		if ( isChecked ) {
			$(".bbsList .chkIdx").prop("checked", true);
		}
		else {
			$(".bbsList .chkIdx").prop("checked", false);
		}
	});
	
	$(".btnDel").click(function() {
		var checkedCnt = $(".bbsList .chkIdx:checked").length;
		
		if ( checkedCnt > 0 ) {
			var articleIds = "";
			$.each($(".bbsList .chkIdx:checked"), function(idx, row) {
				articleIds += row.value;
				articleIds += ",";
			});
			articleIds = articleIds.substr(0, articleIds.length-1);
			
			$.ajax({
				url: "/bbs/delete.json"
				, type: "POST"
				, data: {"articleIds": articleIds}
				, dataType: "json"
				, success: function(json) {
					$.each($(".bbsList .chkIdx:checked"), function(idx, row) {
						$(this).closest("tr").fadeOut().remove();
					});
					
					chkIsResult();
					
					alert("삭제됐습니다.");
				}
				, error: function(responseText) {}
			});
		}
		else {
			alert("삭제하실 게시글을 먼저 선택해주세요.");
		}
	});
});

function chkIsResult() {
	var isResult = $(".bbsList tbody tr:not(.noResult)").length;
	if ( isResult == 0 ) {
		$(".noResult").removeClass("hidden");
	}
	else {
		$(".noResult").addClass("hidden");
	}
}
$(document).ready(function() {
	chkIsResult();
});