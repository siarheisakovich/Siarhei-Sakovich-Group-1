<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>
    Edit Currency Operation
</h1>
<c:url var="add_action" value='/admin/currencyOperations'/>
<form:form commandName="currencyOperation" action="${add_action}" method="POST">
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
            <form:label path="coefficent">
                <spring:message text="Coefficent"/>
            </form:label>
        </td>
        <td>
            <form:input path="coefficent" />
        </td>
        <form:errors element="td" path="coefficent" cssClass="error" />
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit"
                value="<spring:message text="Update Currency Operation"/>" />
        </td>
    </tr>
</table>  
</form:form>