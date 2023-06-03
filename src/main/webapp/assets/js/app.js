var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider,$locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
  .when("/", {
    templateUrl : "index.html"
  })
  .when("/nhanvien", {
    templateUrl : "../../views/nhanvien/index.jsp"
  })
  .when("/cuahang", {
    templateUrl : "../../views/cuahang/index.jsp"
  })
  .when("/chitietsanpham", {
    templateUrl : "../../views/chitietsanpham/index.jsp"
  });
});