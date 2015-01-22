<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>
    Exchange Operation
</h1>
<form:form commandName="exchangeOperation" method="POST">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
    <tr>
        <td>
            <form:label path="fromAccount">
                <spring:message text="From Account"/>
            </form:label>
        </td>
        <td>
            <form:select path="fromAccount">
                <form:option value="0" label="--Please Select"/>
                <form:options items="${accounts}" itemValue="id" itemLabel="currency.title"/>
            </form:select>
        </td> 
        <form:errors element="td" path="fromAccount" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="toAccount">
                <spring:message text="To Account"/>
            </form:label>
        </td>
        <td>
            <form:select path="toAccount">
                <form:option value="0" label="--Please Select"/>
                <form:options items="${accounts}" itemValue="id" itemLabel="currency.title"/>
            </form:select>
        </td> 
        <form:errors element="td" path="toAccount" cssClass="error" />
    </tr>
    <tr>
        <td>
            <form:label path="amount">
                <spring:message text="From Coefficent"/>
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
                value="<spring:message text="Exchange"/>" />
        </td>
    </tr>
</table>  
</form:form>