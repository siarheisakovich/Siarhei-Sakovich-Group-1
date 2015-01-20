<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>" />
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
</style>
</head>
<body>
    <header class="header">
        <tiles:insertAttribute name="header" />
    </header>
    <section class="menu">
        <tiles:insertAttribute name="menu" />
    </section>
    <main class="content">
        <tiles:insertAttribute name="content" />
    </main>
    <footer class="footer">
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>