<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>
    Add a User
</h1>
<c:url var="add_user_action" value='/admin/users'/>
<form:form commandName="user" action="${add_user_action}" method="POST">
<table>
    <tr>
        <td>
            <form:label path="login">
                <spring:message text="Login"/>
            </form:label>
        </td>
        <td>
            <form:input path="login" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="password">
                <spring:message text="Password"/>
            </form:label>
        </td>
        <td>
            <form:input path="password" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"
                value="<spring:message text="Add Person"/>" />
        </td>
    </tr>
</table>  
</form:form>
<h3>Users List</h3>
<c:if test="${not empty users}">
    <table class="tg">
    <tr>
        <th width="80">Person ID</th>
        <th width="120">Person Login</th>
        <th width="120">Person Password</th>
        <th width="60">Edit</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td><a href="<c:url value='/admin/users/${user.id}' />" >Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>