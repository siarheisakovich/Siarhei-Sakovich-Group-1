<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="add_user_action" value='/admin/users'/>
<form:form commandName="user" action="${add_user_action}" method="POST">
<table>
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input readonly="true" path="id" />
        </td> 
    </tr>
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