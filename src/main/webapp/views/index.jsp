<%@include file="header.jsp"%>

<div class="row">
	<h1>TestBank Lodgement Platform</h1>
</div>

    <div class="container">

      <form class="add-version form-horizontal form-inline inline_block" action="login" method="post">
      	<h3>${requestScope["message"]}</h3>
        <div class="row">
          <div class="col-md-4">
            <h2 class="form-signin-heading">Please sign in</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <input type="text" name="inputName" class="form-control" placeholder="Name" required autofocus>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
          </div>
        </div>
		<div class="row">
          <div class="col-md-4">
            <button class="btn btn-sm btn-primary" type="submit">Sign in</button>
          </div>
        </div>
      </form>

    </div> <!-- /container -->

<%@include file="footer.jsp"%>