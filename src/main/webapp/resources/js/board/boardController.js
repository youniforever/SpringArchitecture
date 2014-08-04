
// 게시글 목록 가져오기
var boardApp = angular.module('boardApp', []);
boardApp.controller('BoardController', function($scope, $http) {
	$http.get('/bbs/list.json').success(function(json) {
		$scope.list = json.data;
	});
})

.filter('filtIsFile', function() {
	return function(fileSize) {
		var imgPath = "";
		if ( parseInt(fileSize) > 0 ) {
			imgPath += "<img src='/img/glyphicons/glyphicons/png/glyphicons_181_download_alt.png' />";
		}
		
		return imgPath;
	};
});