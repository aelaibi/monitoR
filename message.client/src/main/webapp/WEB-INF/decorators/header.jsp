<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div class="navbar navbar-fixed-top navbar-inverse">
	<div class="navbar-inner">
		<div>
			<a class="brand" href="">SYSMONITOR</a>
			<ul class="nav" role="navigation">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" id="menu0">
						Réferentiel 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
<%-- 				      <li><s:a action="role" >Roles</s:a></li> --%>
<!-- 				      <li><a href="#">Utilisateurs</a></li> -->
				      <li><s:a action="application" >Applications - Domaine</s:a></li>
				    </ul>
				</li>
				<li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="menu1">
						Suivi d'activité 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
<%-- 				      <li><s:a action="message" >Filtrer par date</s:a></li> --%>
				      <li><s:a action="message2" >Messages filter</s:a></li>
				    </ul>
				</li>
				<li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="menu2">
						Reporting 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
				      <li><s:a action="rapport" >Tableau de bord 1</s:a></li>
				    </ul>
				</li>
			</ul>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i> Utilisateur DEMO <span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">Compte DEMO</a></li>
					<li class="divider"></li>
					<li><a href="#">Se déconnecter</a></li>
				</ul>
			</div>
		</div>	
	</div>
</div>
