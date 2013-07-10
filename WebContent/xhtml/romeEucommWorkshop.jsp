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
			<link rel="stylesheet" type="text/css" media="all"
				href="<%=path%>/css/calendar-win2k-1.css" title="win2k-1">
			
			
			<!-- import the calendar script -->
			<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
			<script type="text/javascript" src="<%=path%>/js/calendar-en.js"></script>
			<script type="text/javascript" src="<%=path%>/js/calendarHelper.js"></script>
			<meta name="http-equiv" value="Content-Type"
				content="text/html; charset=ISO-8859-2" />
			
		</head>

		<body >
			<div class="logo"> <img src="<%=path%>/images/InfraLogo.gif"  alt="Infrafrontier"/></div>
			<h:form id="bookingForm" styleClass="dialog">
				<h:panelGrid columns="1" id="bookGrid">

					<h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">
						
						<h:outputLabel value="Event:" for="eventName" style="font-weight:bold;"></h:outputLabel>
						<h:outputText id="eventName" value="#{romeEucommWorkshopBean.event.name}"></h:outputText>
						<h:outputLabel value="Place:" for="place" style="font-weight:bold;"></h:outputLabel>
						<h:outputText id="place" value="#{romeEucommWorkshopBean.event.place}"></h:outputText>
						<h:outputLabel value="From:" for="start" style="font-weight:bold;"></h:outputLabel>
						<h:outputText id="start" value="#{romeEucommWorkshopBean.event.start}"></h:outputText>
						<h:outputLabel value="To:" for="end" style="font-weight:bold;"></h:outputLabel>
						<h:outputText id="end" value="#{romeEucommWorkshopBean.event.end}"></h:outputText>
						
					</h:panelGrid>
					<h:outputLabel value="Please note that attendance to these workshops is by invitation only" style="font-weight:bold;"></h:outputLabel>

					<h:message for="bookingForm" styleClass="message"></h:message>
					<h:message for="bookGrid" styleClass="errorsGlobal"></h:message>
					
					

					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						<f:facet name="header">
							<h:outputText value="Personal information:"></h:outputText>
						</f:facet>

						<h:outputLabel value="Last name:" for="lastName"></h:outputLabel>
						<h:inputText id="lastName" value="#{romeEucommWorkshopBean.booking.lastName}" size="40"
							required="true"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="lastName" styleClass="errors"></h:message>
						

						<h:outputLabel value="First name:" for="firstName"></h:outputLabel>
						<h:inputText id="firstName" value="#{romeEucommWorkshopBean.booking.firstName}"
							required="true" size="40"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="firstName" styleClass="errors" />


						<h:outputLabel value="Email:" for="email"></h:outputLabel>
						<h:inputText id="email" value="#{romeEucommWorkshopBean.booking.email}" required="true" size="30" validator="#{romeEucommWorkshopBean.validateEmail}"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="email" styleClass="errors"></h:message>
						
						

						<h:outputLabel value="Institution:" for="institution"></h:outputLabel>
						<h:inputText id="institution" value="#{romeEucommWorkshopBean.booking.institution}" required="true" size="30"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="institution" styleClass="errors"></h:message>

						<h:outputLabel value="Country:" for="country"></h:outputLabel>
						<h:inputText id="country" value="#{romeEucommWorkshopBean.booking.country}" required="true" size="30"></h:inputText>
						<h:panelGroup></h:panelGroup>
						<h:message for="country" styleClass="errors"></h:message>

					</h:panelGrid>
					
					
					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						<f:facet name="header">
							<h:outputText value="Accomodation Bettoja Hotels"></h:outputText>
						</f:facet>
						<h:outputText value="Please contact the hotel directly in case you need accommodation for 04/12/13" ></h:outputText>
										
					</h:panelGrid>
					
								
					<h:outputText value="Please note that attendance to these workshops is by invitation only" style="font-weight:bold;"></h:outputText>
					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						<f:facet name="header">
							<h:outputText value="Workshop"></h:outputText>
						</f:facet>
						
						<h:outputLabel value="EUCOMMTools Workshop:"for="eucommWorkshop"></h:outputLabel>
						<h:selectOneRadio id="eucommWorkshop" value="#{romeEucommWorkshopBean.booking.eucommWorkshop}" required="true">
							<f:selectItem itemLabel="yes" itemValue="yes (eucomm tools workshop)"/>
							<f:selectItem itemLabel="no" itemValue="no (eucomm tools workshop)"/>
						</h:selectOneRadio>
						<h:panelGroup></h:panelGroup>
						<h:message for="eucommWorkshop" styleClass="errors"></h:message>
						
					</h:panelGrid>
					<h:panelGrid columns="4" rowClasses="prop"
						columnClasses="name,value,comment">
						
						<h:outputLabel  value="Remarks:" for="remarks" escape="true">
							
						</h:outputLabel>
						<h:inputTextarea id="remarks" value="#{romeEucommWorkshopBean.booking.remarks}"></h:inputTextarea>
						<h:message for="remarks" styleClass="errors"></h:message>
					</h:panelGrid>
					<h:outputText value="(email address: cornelia.kaloff@helmholtz-muenchen.de)"></h:outputText>


					<div class="buttons">
						<SPAN class="button"><h:commandButton id="saveBooking" styleClass="save" actionListener="#{romeEucommWorkshopBean.bookEvent}"
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