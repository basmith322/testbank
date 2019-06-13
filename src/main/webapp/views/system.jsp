<%@include file="header.jsp"%>

<%@page import="com.uleska.testbank.dao.SystemDAO,
				com.uleska.testbank.model.System,
				java.util.List"%>

<div class="row">

	<h1>Testbank System Overview</h1>

	<br />

	<table class="table">
		<tr>
			<th class="main-title">System Overview</th>
		</tr>

 <%
 	List<System> systemList = new SystemDAO().getSystem();
	
	if (systemList.size() > 0) { 
 %>			
		<tr>
			<td>
				<table class="table table-hover">
					<tr>
						<th>Machine Name</th>
						<th>Setting</th>
						<th>Value</th>
					</tr>
<%
  			 for (System system : systemList) {
%>				
					<tr>
						<td class="name_av_<% out.println(system.getId());%>">
								<%  out.println(system.getMachineName());   		%>
						</td>
						<td class="type_av_<% out.println(system.getId());%>">
								<% 	out.println(system.getSetting());   		%>
						</td>
						<td class="presetValue_av_<% out.println(system.getId());%>">
							<% 	out.println(system.getValue()); 	%>
						</td> 
					</tr>
<% 			
	 		}  
%>
				</table>
			</td>
		</tr>
<%
	}
%>
	</table>
</div>

<%@include file="footer.jsp"%>