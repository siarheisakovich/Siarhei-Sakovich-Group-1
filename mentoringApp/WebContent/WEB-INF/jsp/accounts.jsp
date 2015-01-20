<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>
    Add Currency Operation
</h1>
<c:url var="add_action" value='/accounts'/>
<form:form commandName="account" action="${add_action}" method="POST">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
    <tr>
        <td>
            <form:label path="currency">
                <spring:message text="Currency"/>
            </form:label>
        </td>
        <td>
            <form:select path="currency">
                <form:option value="0" label="--Please Select"/>
                <form:options items="${currencies}" itemValue="id" itemLabel="title"/>
            </form:select>
        </td> 
        <form:errors element="td" path="currency" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="amount">
                <spring:message text="Amount"/>
            </form:label>
        </td>
        <td>
            <form:input path="amount" />
        </td>
        <form:errors element="td" path="amount" cssClass="error" />
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"
                value="<spring:message text="Add Account"/>" />
        </td>
    </tr>
</table>  
</form:form>
<h3>Account List</h3>
<c:if test="${not empty list}">
    <table class="tg">
    <tr>
        <th width="80">Account ID</th>
        <th width="120">Currency</th>
        <th width="120">Amount</th>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.id}</td>
            <td>${item.currency.title}</td>
            <td>${item.amount.title}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>