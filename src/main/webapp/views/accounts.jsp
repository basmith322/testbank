<%@include file="header.jsp"%>

<%@page import="com.uleska.testbank.dao.AccountsDAO,
				com.uleska.testbank.model.Account,
				java.util.List"%>

<div class="row">

	<h1>Testbank Accounts</h1>

	<br />

	<table class="table">
		<tr>
			<th class="main-title">Accounts</th>
		</tr>

 <%
 	List<Account> accList = new AccountsDAO().getAccounts();

	if (accList.size() > 0) {
 %>
		<tr>
			<td>
				<table class="table table-hover">
					<tr>
						<th>Name</th>
						<th>Address</th>
						<th>Type</th>
						<th>Balance</th>
						<th>Overdraft</th>
						<th>Operations</th>
					</tr>
<%
  			 for (Account acc : accList) {
%>
					<tr>
						<td class="name_av_<% out.println(acc.getId());%>">
								<%  out.println(acc.getName());   		%>
						</td>
						<td class="name_av_<% out.println(acc.getId());%>">
								<%  out.println(acc.getAddress());   		%>
						</td>
						<td class="type_av_<% out.println(acc.getId());%>">
								<% 	out.println(acc.getType());   		%>
						</td>
						<td class="presetValue_av_<% out.println(acc.getId());%>">
							<% 	out.println(acc.getBalance()); 	%>
						</td>
						<td class="presetValue_av_<% out.println(acc.getId());%>">
							<% 	out.println(acc.getOverdraft()); 	%>
						</td>
						<td>

						<form class="form-horizontal form-inline inline_block"
							id="role_form_<%out.print(String.valueOf(acc.getId()));%>"
							action="editaccount" method="post">

							<button type="submit"
								class="btn btn-xs btn-success edit_av"
								data-id="<% out.println(acc.getId()); %>">Modify</button>

							<input type="hidden" class="form-control" name="hiddenID"
								value="<%out.print(acc.getId());%>">

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