<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-2.1.3.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
   <h2>${message}</h2>
</body>
</html>