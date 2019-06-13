<%@include file="header.jsp"%>

<%@page import="com.uleska.testbank.dao.ConfigDAO,
				com.uleska.testbank.model.Config,
				java.util.List"%>

<div class="row">

	<h1>Testbank Configuration</h1>

	<br />

	<table class="table">
		<tr>
			<th class="main-title">Configuration</th>
		</tr>

 <%
 	List<Config> configList = new ConfigDAO().getConfig(); 
	
	if (configList.size() > 0) { 
 %>			
		<tr>
			<td>
				<table class="table table-hover">
					<tr>
						<th>Parameter Name</th>
						<th>Parameter Value</th>
						<th>Parameter Description</th>
						<th>Operations</th>
					</tr>
<%
  			 for (Config configItem : configList) {
%>				
					<tr>
						<td class="name_av_<% out.println(configItem.getId());%>">
								<%  out.println(configItem.getName());   		%>
						</td>
						<td class="type_av_<% out.println(configItem.getId());%>">
								<% 	out.println(configItem.getValue());   		%>
						</td>
						<td class="presetValue_av_<% out.println(configItem.getId());%>">
							<% 	out.println(configItem.getDescription()); 	%>
						</td> 
						<td>

					<form class="form-horizontal form-inline inline_block"
						id="role_form_<%out.print(String.valueOf(configItem.getId()));%>"
						action="editconfig" method="post">
							
						<button type="submit" 
							class="btn btn-xs btn-success edit_av" 
							data-id="<% out.println(configItem.getId()); %>">Modify</button>
							
						<input type="hidden" class="form-control" name="hiddenID"
							value="<%out.print(configItem.getId());%>">

					</form>
										
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