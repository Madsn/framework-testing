
<%@ page import="scrum.shuffle.TeamMember" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teamMember.label', default: 'TeamMember')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-teamMember" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-teamMember" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list teamMember">
			
				<g:if test="${teamMemberInstance?.initials}">
				<li class="fieldcontain">
					<span id="initials-label" class="property-label"><g:message code="teamMember.initials.label" default="Initials" /></span>
					
						<span class="property-value" aria-labelledby="initials-label"><g:fieldValue bean="${teamMemberInstance}" field="initials"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teamMemberInstance?.lastSkipped}">
				<li class="fieldcontain">
					<span id="lastSkipped-label" class="property-label"><g:message code="teamMember.lastSkipped.label" default="Last Skipped" /></span>
					
						<span class="property-value" aria-labelledby="lastSkipped-label"><g:fieldValue bean="${teamMemberInstance}" field="lastSkipped"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teamMemberInstance?.lastTurn}">
				<li class="fieldcontain">
					<span id="lastTurn-label" class="property-label"><g:message code="teamMember.lastTurn.label" default="Last Turn" /></span>
					
						<span class="property-value" aria-labelledby="lastTurn-label"><g:fieldValue bean="${teamMemberInstance}" field="lastTurn"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teamMemberInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="teamMember.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${teamMemberInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:teamMemberInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${teamMemberInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
