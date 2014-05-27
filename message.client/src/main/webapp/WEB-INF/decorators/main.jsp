<!DOCTYPE html PUBLIC  "-//W3C//DTD XHTML 1.1 Transitional//EN"	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>
			<decorator:title default="SysMonitor" />
		</title>
		<decorator:head />
		<sj:head />
		<%@ include file="head.jsp"%>
	</head>
	
	<body>
		<div class="container-fluid">
			<%@ include file="header.jsp"%>
			<div class="row-fluid">
				<sj:head locale="fr" jqueryui="true" jquerytheme="redmond" />
				<decorator:body />
			</div>
			<div style="position: fixed; bottom: 0px">
				<%@ include file="footer.jsp"%>
			</div>
		</div>
	</body>
	
</html>
