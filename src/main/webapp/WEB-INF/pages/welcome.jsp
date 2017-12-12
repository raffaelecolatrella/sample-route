<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	
	<h3>Sample Routing |  (<a href="<c:url value="/logout" />">Logout</a>) </h3>
	<p>List of countries Names with local curriencies Name:</p>
	<table class="tg">
		<tr>
			<th width="120">Country Name</th>
			<th width="90">Local currencies name</th>
		</tr>
		<c:if test="${!empty listCountriesCurr}">
			<c:forEach items="${listCountriesCurr}" var="customer">
				<tr>
					<td>${customer.name}</td>
					<td><c:forEach items="${customer.curr}" var="cur">${cur} </c:forEach></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>