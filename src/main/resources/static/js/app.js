angular.module('app', [ 'ngRoute','ngAnimate','ui.bootstrap' ])

.config(function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'MenuController as menuList',
		templateUrl : 'list.html'
	}).when('/detail/:menuId', {
		controller : 'MenuDetailController as menuDetail',
		templateUrl : 'detail.html'
	}).otherwise({
		redirectTo : '/'
	});
})

.service('MenuService', function($q, $http) {

			var factory = {};

			factory.findById = function(menuId) {
				var deferred = $q.defer();
				
				$http.get('/menu/' + menuId + '/')
					.success(function(data, status, headers, config) {
							deferred.resolve(data);
						})
					.error(function(err) {
							deferred.reject(err);
						});
				
				return deferred.promise;
			}

			factory.findAll = function() {
				var deferred = $q.defer();
				
				$http.get('/menu/')
					.success(function(data, status, headers, config) {
							deferred.resolve(data);
						})
					.error(function(err) {
						deferred.reject(err);
						});
				
				return deferred.promise;
			}

			return factory;
		})

.controller('MenuController', function($scope, MenuService) {
	
	$scope.dateRangeFilter = function (property) {
		return function (item) {
			if (!property) return true;
			
//			var itemDate = moment(item[property]);
//			var s = moment(startDate, "DD-MM-YYYY");
//			var e = moment(endDate, "DD-MM-YYYY");
			var itemDate = property.toISOString();
			var s = item.dateFrom;
			var e = item.dateTo;
			console.info(itemDate);
			console.info(s);
			console.info(e);
			if (itemDate >= s && itemDate <= e) return true;
			return false;
		}
	}
	
	$scope.search={};
	
	$scope.popup1 = {
	    opened: false
	  };
	
	$scope.open1 = function() {
	    $scope.popup1.opened = true;
	  };

	MenuService.findAll()
		.then(function(data) {
			$scope.menues = data;
		});
})

.controller('MenuDetailController', function($scope, $routeParams, MenuService) {
	
	$scope.popup1 = {
		    opened: false
		  };
		
	$scope.open1 = function() {
	    $scope.popup1.opened = true;
	  };
	  
	$scope.popup2 = {
		    opened: false
		  };
		
	$scope.open2 = function() {
	    $scope.popup2.opened = true;
	  };
	
	MenuService.findById($routeParams.menuId)
		.then(function(data) {
			for(var item in data) {
				$scope[item] = data[item];
			}
			$scope.dateFromD = new Date($scope.dateFrom);
			$scope.dateToD = new Date($scope.dateTo);
			
			var timeFrom = new Date();
			var time = $scope.timeFrom.match(/(\d+)(?::(\d\d))?\s*(p?)/);
			timeFrom.setHours( parseInt(time[1]) + (time[3] ? 12 : 0) );
			timeFrom.setMinutes( parseInt(time[2]) || 0 );
			$scope.timeFrom=timeFrom;
			
			var timeTo = new Date();
			var time = $scope.timeTo.match(/(\d+)(?::(\d\d))?\s*(p?)/);
			timeTo.setHours( parseInt(time[1]) + (time[3] ? 12 : 0) );
			timeTo.setMinutes( parseInt(time[2]) || 0 );
			$scope.timeTo=timeTo;
			
			$scope.daysT = {};
			
			for(var item in $scope.days) {
				$scope.daysT[$scope.days[item]] = true;
			}
		});
});
