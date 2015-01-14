
<%@ page import="scrum.shuffle.TeamMember" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teamMember.label', default: 'TeamMember')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-teamMember" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-teamMember" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="id" title="${message(code: 'teamMember.id.label', default: 'Id')}" />
					
						<g:sortableColumn property="initials" title="${message(code: 'teamMember.initials.label', default: 'Initials')}" />
					
						<g:sortableColumn property="lastSkipped" title="${message(code: 'teamMember.lastSkipped.label', default: 'Last Skipped')}" />
					
						<g:sortableColumn property="lastTurn" title="${message(code: 'teamMember.lastTurn.label', default: 'Last Turn')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'teamMember.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${teamMemberInstanceList}" status="i" var="teamMemberInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: teamMemberInstance, field: "id")}</td>
					
						<td><g:link action="show" id="${teamMemberInstance.id}">${fieldValue(bean: teamMemberInstance, field: "initials")}</g:link></td>
					
						<td>${fieldValue(bean: teamMemberInstance, field: "lastSkipped")}</td>
					
						<td>${fieldValue(bean: teamMemberInstance, field: "lastTurn")}</td>
					
						<td>${fieldValue(bean: teamMemberInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${teamMemberInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
