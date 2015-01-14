
<%@ page import="scrum.shuffle.TeamMember" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div>
			<h1>Cycle</h1>
			${nextMember?.initials} - ${nextMember?.name}
			<g:form controller="shuffle">
				<g:actionSubmit value="Cycle" action="cycle"/>
				<g:actionSubmit value="Skip" action="skip"/>
			</g:form>
		</div>
		<div>
			<h1>Random</h1>
			${randomMember?.initials} - ${randomMember?.name}
			<g:form controller="shuffle">
				<g:actionSubmit value="Random" action="random"/>
				<input type="hidden" name="currentRandomId" value="${randomMember?.id}" />
			</g:form>
		</div>
		<div>
			<h1>Members:</h1>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="initials" title="${message(code: 'teamMember.initials.label', default: 'Initials')}" />
					
						<g:sortableColumn property="lastSkipped" title="${message(code: 'teamMember.lastSkipped.label', default: 'Last Skipped')}" />
					
						<g:sortableColumn property="lastTurn" title="${message(code: 'teamMember.lastTurn.label', default: 'Last Turn')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'teamMember.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${teamMemberInstanceList}" status="i" var="teamMemberInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${teamMemberInstance.id}">${fieldValue(bean: teamMemberInstance, field: "initials")}</g:link></td>
					
						<td>${fieldValue(bean: teamMemberInstance, field: "lastSkipped")}</td>
					
						<td>${fieldValue(bean: teamMemberInstance, field: "lastTurn")}</td>
					
						<td>${fieldValue(bean: teamMemberInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
