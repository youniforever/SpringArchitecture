
// 게시글 목록 가져오기
var boardApp = angular.module('boardApp', [])

.controller('BoardController', function($compile, $scope, $http) {
	$http.get('/bbs/list.json').success(function(json) {
		$scope.list = json.data;
	});
})

.filter('filtIsFile', function() {
	return function(fileSize) {
		var imgPath = "";
		if ( parseInt(fileSize) > 0 ) {
			imgPath += "/img/glyphicons/glyphicons/png/glyphicons_181_download_alt.png";
		}
		else {
			imgPath += "data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D";
		}
		
		return imgPath;
	};
});