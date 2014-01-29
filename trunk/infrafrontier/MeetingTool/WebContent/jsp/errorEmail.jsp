<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<f:view>
	
	<html>
		<head>
			<title>Confirmation</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<meta name="author" content="Ralph Steinkamp">

			<link rel="stylesheet" type="text/css" href="../css/styles.css">

			<meta name="http-equiv" value="Content-Type"
				content="text/html; charset=ISO-8859-2" />
		</head>
		<body>

			<h:form id="confirmation">
				<h:panelGrid columns="1" border="2" cellpadding="3" cellspacing="3"
					styleClass="center_navigation" headerClass="tableheader" style="width: 641px; height: 228px">
					<f:facet name="header">
						<h:outputText value="Confirmation"></h:outputText>
					</f:facet>

					<h:outputText id="confirmationMessage"
						value="Your request was submitted successfully and will be processed as soon as possible."></h:outputText>
    <h:outputText value="A confirmation message can't be sent by email due to an error! Please contact INFRAFRONTIER project office (ana.decastro@helmholtz-muenchen.de)" styleClass="errors"></h:outputText>
   
				</h:panelGrid>
			</h:form>
		</body>
	</html>
</f:view>