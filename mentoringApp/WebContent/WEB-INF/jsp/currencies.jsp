<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>
    Add a Currency
</h1>
<c:url var="add_action" value='/admin/currencies'/>
<form:form commandName="item" action="${add_action}" method="POST">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
    <tr>
        <td>
            <form:label path="isoCode">
                <spring:message text="ISO code"/>
            </form:label>
        </td>
        <td>
            <form:input path="isoCode" />
        </td> 
        <form:errors element="td" path="isoCode" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="title">
                <spring:message text="Title"/>
            </form:label>
        </td>
        <td>
            <form:input path="title" />
        </td>
        <form:errors element="td" path="title" cssClass="error" />
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"
                value="<spring:message text="Add Currency"/>" />
        </td>
    </tr>
</table>  
</form:form>
<h3>Currency List</h3>
<c:if test="${not empty list}">
    <table class="tg">
    <tr>
        <th width="80">Currency ID</th>
        <th width="120">Currency ISO Code</th>
        <th width="120">Currency Title</th>
        <th width="60">Edit</th>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.id}</td>
            <td>${item.isoCode}</td>
            <td>${item.title}</td>
            <td><a href="<c:url value='/admin/currencies/${item.id}' />" >Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>