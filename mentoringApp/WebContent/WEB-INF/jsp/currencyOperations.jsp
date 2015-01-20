<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>
    Add Currency Operation
</h1>
<c:url var="add_action" value='/admin/currencyOperations'/>
<form:form commandName="currencyOperation" action="${add_action}" method="POST">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
    <tr>
        <td>
            <form:label path="fromCurrency">
                <spring:message text="From Currency"/>
            </form:label>
        </td>
        <td>
            <form:select path="fromCurrency">
                <form:option value="0" label="--Please Select"/>
                <form:options items="${currencies}" itemValue="id" itemLabel="title"/>
            </form:select>
        </td> 
        <form:errors element="td" path="fromCurrency" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="toCurrency">
                <spring:message text="To Currency"/>
            </form:label>
        </td>
        <td>
            <form:select path="toCurrency">
                <form:option value="0" label="--Please Select"/>
                <form:options items="${currencies}" itemValue="id" itemLabel="title"/>
            </form:select>
        </td> 
        <form:errors element="td" path="toCurrency" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="fromCoefficent">
                <spring:message text="From Coefficent"/>
            </form:label>
        </td>
        <td>
            <form:input path="fromCoefficent" />
        </td>
        <form:errors element="td" path="fromCoefficent" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="toCoefficent">
                <spring:message text="To Coefficent"/>
            </form:label>
        </td>
        <td>
            <form:input path="toCoefficent" />
        </td>
        <form:errors element="td" path="toCoefficent" cssClass="error" />
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"
                value="<spring:message text="Add Currency Operation"/>" />
        </td>
    </tr>
</table>  
</form:form>
<h3>Currency Operations List</h3>
<c:if test="${not empty list}">
    <table class="tg">
    <tr>
        <th width="80">Currency ID</th>
        <th width="120">From Currency</th>
        <th width="120">To Currency</th>
        <th width="120">From Coefficent</th>
        <th width="120">To Coefficent</th>
        <th width="60">Edit</th>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.id}</td>
            <td>${item.fromCurrency.title}</td>
            <td>${item.toCurrency.title}</td>
            <td>${item.fromCoefficent}</td>
            <td>${item.toCoefficent}</td>
            <td><a href="<c:url value='/admin/currencyOperations/${item.id}' />" >Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>