<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<f:view>
	<html>
		<head>
			<title>Infrafrontier Meeting Tool</title>
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
			<meta name="author" content="Ralph Steinkamp">
	
			<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css">
			<meta name="http-equiv" value="Content-Type"
				content="text/html; charset=ISO-8859-2" />
			
		</head>

		<body >
			<div class="logo"> <img src="<%=path%>/images/InfraLogo.gif"  alt="Infrafrontier"/></div>
			<h:form id="bookingForm" styleClass="dialog">
				<h:panelGrid columns="1" id="bookGrid">

					<h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">
						<f:facet name="header">
							<h:outputText value="Event"></h:outputText>
						</f:facet>
						<h:outputLabel value="Event:" for="eventName"></h:outputLabel>
						<h:outputText id="eventName" value="#{i3KickOffBookingBean.event.name}"></h:outputText>
						<h:outputLabel value="Place:" for="place"></h:outputLabel>
						<h:outputText id="place" value="#{i3KickOffBookingBean.event.place}"></h:outputText>
						<h:outputLabel value="From:" for="start"></h:outputLabel>
						<h:outputText id="start" value="#{i3KickOffBookingBean.event.start}"></h:outputText>
						<h:outputLabel value="To:" for="end"></h:outputLabel>
						<h:outputText id="end" value="#{i3KickOffBookingBean.event.end}"></h:outputText>
					</h:panelGrid>


					<h:message for="bookingForm" styleClass="message"></h:message>
					<h:message for="bookGrid" styleClass="errorsGlobal"></h:message>

					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						<f:facet name="header">
							<h:outputText value="Personal information:"></h:outputText>
						</f:facet>

						<h:outputLabel value="Last name:" for="lastName"></h:outputLabel>
						<h:inputText id="lastName" value="#{i3KickOffBookingBean.booking.lastName}" size="40"
							required="true"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="lastName" styleClass="errors"></h:message>

						<h:outputLabel value="First name:" for="firstName"></h:outputLabel>
						<h:inputText id="firstName" value="#{i3KickOffBookingBean.booking.firstName}"
							required="true" size="40"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="firstName" styleClass="errors" />


						<h:outputLabel value="Email:" for="email"></h:outputLabel>
						<h:inputText id="email" value="#{i3KickOffBookingBean.booking.email}" required="true" size="30" validator="#{i3KickOffBookingBean.validateEmail}"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="email" styleClass="errors"></h:message>

						<h:outputLabel value="Institution:" for="institution"></h:outputLabel>
						<h:inputText id="institution" value="#{i3KickOffBookingBean.booking.institution}" required="true" size="30"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="institution" styleClass="errors"></h:message>

						<h:outputLabel value="Country:" for="country"></h:outputLabel>
						<h:inputText id="country" value="#{i3KickOffBookingBean.booking.country}" required="true" size="30"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="country" styleClass="errors"></h:message>

					</h:panelGrid>


					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						<f:facet name="header">
							<h:outputText value="Dinner 22 April 2013 at 20:00"></h:outputText>
						</f:facet>
						<h:outputLabel  for="vegetarian" escape="true">
							Vegetarian food for dinner </br> or other dietary requirements:
						</h:outputLabel>
						<h:inputTextarea id="vegetarian" value="#{i3KickOffBookingBean.booking.vegetarian}"></h:inputTextarea>
						<h:message for="remarks" styleClass="errors"></h:message>
					</h:panelGrid>
					
					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						
						<h:outputLabel  value="Remarks:" for="remarks" escape="true">
							
						</h:outputLabel>
						<h:inputTextarea id="remarks" value="#{i3KickOffBookingBean.booking.remarks}"></h:inputTextarea>
						<h:message for="remarks" styleClass="errors"></h:message>
					</h:panelGrid>


					<div class="buttons">
						<SPAN class="button"><h:commandButton id="saveBooking" styleClass="save" actionListener="#{i3KickOffBookingBean.bookEvent}"
								value="book event">
							</h:commandButton>
						</SPAN>
					</div>
					<h:message for="saveBooking" styleClass="errors"></h:message>
				</h:panelGrid>
</h:form>
		</body>
	</html>
</f:view>