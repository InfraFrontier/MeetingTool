<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>INFRAFRONTIER Meeting registration error</title>
		<meta name="author" content="Infrafrontier" />
		<meta name="description" content="The Biological and Medical Science projects (ESFRI BMS) on the ESFRI roadmap meet regularly to discuss common issues. The ESFRI BMS group is in close contact with the ESFRI Health and Food Strategic Working Group (SWG). The ESFRI BMS group has published several common position papers on policy issues and works together in the BioMedBridges and EMTRAIN projects." />
		<meta name="copyright" content="Infrafrontier" />
		<link rel="shortcut icon" href="<%=config.getInitParameter("baseUrl")%>/sites/infrafrontier.eu/themes/custom/infrafrontier/img/favicon.ico" type="image/vnd.microsoft.icon" />
    	<h:outputStylesheet library="css" name="default.css"  />
    	<style type="text/css" media="all">@import url("#{baseUrl}/sites/infrafrontier.eu/modules/contrib/ldap/ldap_user/ldap_user.css?mspj5o");
@import url("#{baseUrl}/sites/infrafrontier.eu/modules/contrib/date/date_api/date.css?mspj5o");
@import url("#{baseUrl}/modules/search/search.css?mspj5o");
@import url("#{baseUrl}/sites/infrafrontier.eu/modules/contrib/views/css/views.css?mspj5o");</style>
<style type="text/css" media="all">@import url("#{baseUrl}/sites/infrafrontier.eu/modules/contrib/ctools/css/ctools.css?mspj5o");
@import url("#{baseUrl}/sites/infrafrontier.eu/modules/contrib/ldap/ldap_servers/ldap_servers.admin.css?mspj5o");</style>
<style type="text/css" media="all">@import url("#{baseUrl}/sites/infrafrontier.eu/themes/custom/infrafrontier/css/default.css?mspj5o");
@import url("#{baseUrl}/sites/infrafrontier.eu/themes/custom/infrafrontier/css/ebi.css?mspj5o");
</style>
		<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', '<%=config.getInitParameter("googleAnalytics")%>', 'infrafrontier.eu');
  ga('send', 'pageview');

		</script>
		<meta name="http-equiv" value="Content-Type"
				content="text/html; charset=ISO-8859-2" />
  </head>
  
  <body>
    <h2>Sorry, the database is not available at the moment</h2>
    <p>Please try again later or contact :<img src="<%=basePath%>/images/info.jpg"/></p>
  </body>
</html>
