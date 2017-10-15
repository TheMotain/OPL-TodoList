<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">TodoList</a>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<form:form method="POST" action="/createTodoList" modelAttribute="listForm">
	            <form:label path="name">Create todoListe : Name</form:label>
	            <form:input path="name"/>
	            <input type="submit" value="Submit"/>
			</form:form>
			<c:forEach var="currentList" items="${todolists}">
				<c:out value="${currentList.name}"/>
				<table class="table-bordered">
					<tbody>
					<c:forEach var="currentRow" items="${currentList.getFormatedListToDisplay()}">
						<tr>
							<c:forEach var="currentTask" items="${currentRow}">
								<td>
									<c:if test="${currentTask ne null}">
										<ul>
											<li><c:out value="Task : ${currentTask.name}"/></li>
											<li><c:out value="Description : ${currentTask.description}"/></li>
											<li><c:out value="Creation Date : ${currentTask.creationDate}"/></li>
											<li><c:out value="Done : ${currentTask.done }"/></li>
											<li>
												<a href="/done/${currentTask.id}"><button type="button" class="btn btn-success">Done</button></a>
												<a href="/delete/${currentTask.id}"><button type="button" class="btn btn-danger">delete</button></a>
											</li>
										</ul>
									</c:if>
								</td>
							</c:forEach>
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>
						<form method="post" action="/createTask/${currentList.name}">
							<c:out value="Create Task : Name"/>
	            			<input type="text" name="name"/>
	            			<c:out value="Description"/>
	            			<input type="text" name="description"/>
	            			<input type="submit" value="Submit"/>
						</form>
					</tfoot>
				</table>
			</c:forEach>
		</div>

	</div>

	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>