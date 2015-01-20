<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>
    Edit a Currency
</h1>
<c:url var="add_action" value='/admin/currencies'/>
<form:form commandName="item" action="${add_action}" method="POST">
<form:errors path="*" cssClass="errorblock" element="div" />
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
                value="<spring:message text="Update Currency"/>" />
        </td>
    </tr>
</table>  
</form:form>