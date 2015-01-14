<%@ page import="scrum.shuffle.TeamMember" %>



<div class="fieldcontain ${hasErrors(bean: teamMemberInstance, field: 'initials', 'error')} required">
	<label for="initials">
		<g:message code="teamMember.initials.label" default="Initials" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="initials" value="${teamMemberInstance?.initials}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: teamMemberInstance, field: 'lastSkipped', 'error')} required">
	<label for="lastSkipped">
		<g:message code="teamMember.lastSkipped.label" default="Last Skipped" />
		<span class="required-indicator">*</span>
	</label>
	<joda:dateTimePicker name="lastSkipped" value="${teamMemberInstance?.lastSkipped}" ></joda:dateTimePicker>
</div>

<div class="fieldcontain ${hasErrors(bean: teamMemberInstance, field: 'lastTurn', 'error')} required">
	<label for="lastTurn">
		<g:message code="teamMember.lastTurn.label" default="Last Turn" />
		<span class="required-indicator">*</span>
	</label>
	<joda:dateTimePicker name="lastTurn" value="${teamMemberInstance?.lastTurn}" ></joda:dateTimePicker>
</div>

<div class="fieldcontain ${hasErrors(bean: teamMemberInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="teamMember.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" value="${teamMemberInstance?.name}"/>
</div>

