<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>Authentification</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Le styles 
    <link href="<s:url value='/styles/login.css'/>" rel="stylesheet">-->
	<link href="<s:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"	type="text/css" media="all" />
	
    <style type="text/css">
	      body {
	        padding-top: 40px;
	        padding-bottom: 40px;
	        background-color: #f5f5f5;
	      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="<s:url value='/bootstrap/css/bootstrap-responsive.css'/>" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="../assets/ico/favicon.png">
  </head>

  <body>

    <div class="container">
    
      <form class="form-signin" action="j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Authentification</h2>
        <input type="text" class="input-block-level" placeholder="Nom d'utilisateur" name="j_username" autofocus required>
        <input type="password" class="input-block-level" placeholder="Mot de passe" name="j_password" required>

        <button class="btn btn-large btn-primary" type="submit">Se connecter</button>
      </form>

		<p style="text-align: center; color: red; font-size: larger;">
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</p>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->

	<script type="text/javascript" src="<s:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
    <!-- Placed at the end of the document so the pages load faster 
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap-transition.js"></script>
    <script src="../assets/js/bootstrap-alert.js"></script>
    <script src="../assets/js/bootstrap-modal.js"></script>
    <script src="../assets/js/bootstrap-dropdown.js"></script>
    <script src="../assets/js/bootstrap-scrollspy.js"></script>
    <script src="../assets/js/bootstrap-tab.js"></script>
    <script src="../assets/js/bootstrap-tooltip.js"></script>
    <script src="../assets/js/bootstrap-popover.js"></script>
    <script src="../assets/js/bootstrap-button.js"></script>
    <script src="../assets/js/bootstrap-collapse.js"></script>
    <script src="../assets/js/bootstrap-carousel.js"></script>
    <script src="../assets/js/bootstrap-typeahead.js"></script>
	-->
  </body>
</html>
