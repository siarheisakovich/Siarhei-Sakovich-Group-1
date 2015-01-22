<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h3>Select Currency Operation</h3>
<c:if test="${not empty currencyOperations}">
    <table class="tg">
    <tr>
        <th width="80">Currency ID</th>
        <th width="120">From Currency</th>
        <th width="120">To Currency</th>
        <th width="120">From Coefficent</th>
        <th width="120">To Coefficent</th>
        <th width="60">Select</th>
    </tr>
    <c:forEach var="item" items="${currencyOperations}">
        <tr>
            <td>${item.id}</td>
            <td>${item.fromCurrency.title}</td>
            <td>${item.toCurrency.title}</td>
            <td>${item.fromCoefficent}</td>
            <td>${item.toCoefficent}</td>
            <td><a href="<c:url value='/exchange/${item.id}' />" >Select</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<h3>Your Exchange Operations</h3>
<c:if test="${not empty exchangeOperations}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">From Account ID</th>
        <th width="120">To Account ID</th>
        <th width="120">Amount</th>
        <th width="120">From Coefficent</th>
        <th width="120">To Coefficent</th>
    </tr>
    <c:forEach var="item" items="${exchangeOperations}">
        <tr>
            <td>${item.id}</td>
            <td>${item.fromAccount.id}</td>
            <td>${item.toAccount.id}</td>
            <td>${item.amount}</td>
            <td>${item.fromCoefficent}</td>
            <td>${item.toCoefficent}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>