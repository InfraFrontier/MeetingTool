<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>Infrafrontier Meeting Tool</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
		
	</head>
	<body class="body">
		<div class="logo"> <img src="<%=path%>/images/InfraLogo.gif" alt="Infrafrontier"/></div>
		
		
		
		<f:view>
			<h:form id="eventForm">
				<h:panelGrid columns="1" cellpadding="2" >
					<f:facet name="header">
					<h:outputText value="Infrafrontier Events" style="font-size: 24px"></h:outputText>
					</f:facet>
					<h:panelGroup></h:panelGroup>

					<h:outputText
						value="Please choose the event you want to subscribe to"
						style="font-size: 20px"></h:outputText>

					<h:dataTable var="event" value="#{eventBean.events}" border="1"
						binding="#{eventBean.eventTable}" headerClass="tableheader">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Event"></h:outputText>
							</f:facet>
							<h:commandLink action="#{eventBean.showBookingForm}"
								value="#{event.name}">
							</h:commandLink>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Start"></h:outputText>
							</f:facet>
							<h:outputText value="#{event.start}">
								<f:convertDateTime timeZone="CET" pattern="dd.MM.yyyy" />
							</h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="End"></h:outputText>
							</f:facet>
							<h:outputText value="#{event.end}">
								<f:convertDateTime timeZone="CET" pattern="dd.MM.yyyy" />
							</h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Place"></h:outputText>
							</f:facet>
							<h:outputText value="#{event.place}"></h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Comment"></h:outputText>
							</f:facet>
							<h:outputText value="#{event.comment}"></h:outputText>
						</h:column>
					</h:dataTable>
				</h:panelGrid>
			</h:form>
		</f:view>
	</body>
</html>