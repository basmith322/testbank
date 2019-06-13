<%@include file="header.jsp"%>

<%@page import="com.uleska.testbank.dao.TransactionsDAO,
				com.uleska.testbank.model.Transaction,
				java.util.List"%>

<div class="row">

	<h1>Testbank Transactions</h1>

	<br />

	<table class="table">
		<tr>
			<th class="main-title">Transactions</th>
		</tr>

 <%
 	List<Transaction> txnList = new TransactionsDAO().getTransactions();
	
	if (txnList.size() > 0) { 
 %>			
		<tr>
			<td>
				<table class="table table-hover">
					<tr>
						<th>Name</th>
						<th>Amount</th>
						<th>Account</th>
						<th>Type</th>
					</tr>
<%
  			 for (Transaction txn : txnList) {
%>				
					<tr>
						<td class="name_av_<% out.println(txn.getId());%>">
						    <% out.println(txn.getName()); %>
						</td>
						<td class="type_av_<% out.println(txn.getId());%>">
						    <% out.println(txn.getAmount()); %>
						</td>
						<td class="presetValue_av_<% out.println(txn.getId());%>">
						    <% out.println(txn.getAccount()); %>
						</td> 
						<td class="presetValue_av_<% out.println(txn.getId());%>">
							<% out.println(txn.getType()); %>
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