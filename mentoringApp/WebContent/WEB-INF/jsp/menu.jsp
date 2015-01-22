<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<nav>
    <a href="<c:url value='/'/>">User Main</a> 
    <a href="<c:url value='/accounts'/>">User Accounts</a> 
    <a href="<c:url value='/exchange'/>">User Exchange</a>
    <a href="<c:url value='/admin/currencyOperations'/>">Admin Currency Operations</a>
    <a href="<c:url value='/admin/currencies'/>">Admin Currencies</a>
    <a href="<c:url value='/admin/users'/>">Admin Users</a>
</nav>