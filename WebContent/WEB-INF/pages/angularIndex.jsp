<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" ng-app="ngdemo">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My AngularJS App</title>
   

    <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap/bootstrap-responsive.min.css" />" rel="stylesheet">
    
    <script src="<c:url value="/resources/js/app.js" />"></script>

</head>
<body>
<ul class="menu">
    <li><a href="#/dummy">dummy</a></li>
    <li><a href="#/user-list">user-list</a></li>
    <li><a href="#/user-detail/1">user-detail/1</a></li>
    <li><a href="#/user-creation">user-creation</a></li>
</ul>

<div ng-view></div>

<!-- JQuery ================================================================ -->
<script src="<c:url value="/resources/js/jquery/jquery-2.0.3.js" />"></script>
<!-- Bootstrap ============================================================= -->

<script src="<c:url value="/resources/js/bootstrap/bootstrap.js" />"></script>

<!-- AngularJS ============================================================= -->
<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
-->

<script src="<c:url value="/resources/lib/angular/angular.js" />"></script>
<script src="<c:url value="/resources/lib/angular/angular-resource.js" />"></script>

<!-- AngularJS App Code ==================================================== -->

<script src="<c:url value="/resources/js/app.js" />"></script>
<script src="<c:url value="/resources/js/services.js" />"></script>
<script src="<c:url value="/resources/js/controllers.js" />"></script>
<script src="<c:url value="/resources/js/filters.js" />"></script>
<script src="<c:url value="/resources/js/directives.js" />"></script>

</body>
</html>
