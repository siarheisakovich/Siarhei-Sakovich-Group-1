<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<nav>
    <a href="<c:url value='/main'/>">Main</a> 
    <a href="<c:url value='/accounts'/>">Accounts</a> 
    <a href="<c:url value='/exchange'/>">Exchange</a>
    <a href="<c:url value='/profile'/>">Profile</a>
</nav>