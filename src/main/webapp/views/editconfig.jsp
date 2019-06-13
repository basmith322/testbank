<%@include file="header.jsp"%>

<%@page import="com.uleska.testbank.dao.ConfigDAO"%>
<%@page import="com.uleska.testbank.model.Config"%>

<div class="row">

<%
		Integer versionId = Integer.parseInt( (String) request.getAttribute("version_id"));
		
		ConfigDAO editConfigDAO = new ConfigDAO();
		
		Config configToEdit = editConfigDAO.getConfig(versionId);
%>
	<h1>Modify Testbank Configuration
	</h1>
		
	<div class="tab-content">

			<h2 class="main-title">Configuration Details</h2>

			<form class="form-horizontal styled-form" action="saveconfig" method="post">

				<div class="form-group">

					<label class="col-sm-2 control-label">Name:</label>

					<div class="col-sm-10">

						<label class="input-group-addon"><%out.print(configToEdit.getName()); %></label>
					</div>
				</div>

				
				<div class="form-group">

					<label class="col-sm-2 control-label">Description:</label>

					<div class="col-sm-10">

						<label class="input-group-addon"><%out.print(configToEdit.getDescription()); %></label>
					
					</div>
				</div>
				

				<div class="form-group">

					<label class="col-sm-2 control-label">Value:</label>
					<div class="col-sm-10">

						<input type="text" class="form-control" name="value"
							id="attr_min_length_input" placeholder="<%out.print(configToEdit.getValue()); %>"> 
					</div>
				</div>


					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" class="form-control" name="hiddenID"
							value="<%out.print(configToEdit.getId());%>"
							id="hidden_attr_name_id" placeholder="hidden id">
						<button type="submit" class="btn btn-primary"
							id="attr_name_submit" >Update</button>
					</div>

			</form>
	</div>
</div>

<%@include file="footer.jsp"%>