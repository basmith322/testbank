<%@include file="header.jsp"%>

<%@page import="com.uleska.testbank.dao.EditAccountDAO"%>
<%@page import="com.uleska.testbank.model.Account"%>

<div class="row">

<%
		Integer versionId = Integer.parseInt( (String) request.getAttribute("version_id"));
		
		EditAccountDAO editAccDAO = new EditAccountDAO();
		
		Account acc = editAccDAO.getAccount(versionId);
%>
	<h1>Modify Account
	</h1>
		
	<div class="tab-content">

			<h2 class="main-title">Account Details</h2>

			<form class="form-horizontal styled-form" action="saveaccount" method="post">

				<div class="form-group">

					<label class="col-sm-2 control-label">Name:</label>

					<div class="col-sm-10">

						<input type="text" class="form-control" name="name"
							id="attr_min_length_input" placeholder="<%out.print(acc.getName()); %>">
					</div>
				</div>

				
				<div class="form-group">

					<label class="col-sm-2 control-label">Address:</label>

					<div class="col-sm-10">

						<input type="text" class="form-control" name="address"
							id="attr_min_length_input" placeholder="<%out.print(acc.getAddress()); %>">
					
					</div>
				</div>


				<div class="form-group">

					<label class="col-sm-2 control-label">Type:</label>

					<div class="col-sm-10">
<%

					if (session.getAttribute("role").equals("leadbanker"))
					{

%>
						<select class="form-control" id="type_av_select" name="type">
							<option value="nochange">Change if needed.</option>
							<option value="Checking">Checking</option>
							<option value="Savings">Savings</option>
							<option value="ISA">ISA</option>
							<option value="Corporate">Corporate</option>
						</select>

<%
					} else {
%>
						<label class="input-group-addon"><%out.print(acc.getType()); %></label>	
<%
					}
%>					
					</div>
				</div>

	
				<div class="form-group">

					<label class="col-sm-2 control-label">Balance:</label>

					<div class="col-sm-10">

						<label class="input-group-addon">�<%out.print(acc.getBalance()); %></label>
					
					</div>
				</div>


				<div class="form-group">

					<label class="col-sm-2 control-label">Overdraft:</label>
					<div class="col-sm-10">
												
<%

					if (session.getAttribute("role").equals("leadbanker"))
					{

%>
						<input type="text" class="form-control" name="overdraft"
							id="attr_min_length_input" placeholder="<%out.print(acc.getOverdraft()); %>">

<%
					} else {
%>
						<label class="input-group-addon"><%out.print(acc.getOverdraft()); %></label>
<%
					}
%>							

					</div>
				</div>


					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" class="form-control" name="hiddenID"
							value="<%out.print(acc.getId());%>"
							id="hidden_attr_name_id" placeholder="hidden id">
						<button type="submit" class="btn btn-primary"
							id="attr_name_submit">Update</button>
					</div>

			</form>
	</div>
</div>

<%@include file="footer.jsp"%>