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
<title>INFRAFRONTIER Meeting Tool</title>
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
<body>

	<div class="logo">
		<img src="<%=path%>/images/InfraLogo.gif" alt="Infrafrontier" />
	</div>
	<h:form id="bookingForm" styleClass="dialog">

		<h:panelGrid columns="1" id="bookGrid">
			<h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">
				<h:outputLabel value="Event:" for="eventName"
					style="font-weight:bold;"></h:outputLabel>
				<h:outputText id="eventName"
					value="#{munichWorkshopBean.event.name}"></h:outputText>
				<h:outputLabel value="Location:" for="Location"
					style="font-weight:bold;"></h:outputLabel>
				<h:outputText id="Location"
					value="#{munichWorkshopBean.event.place}"></h:outputText>
				<h:outputLabel value="From:" for="start" style="font-weight:bold;"></h:outputLabel>
				<h:outputText id="start" value="#{munichWorkshopBean.event.start}"></h:outputText>
				<h:outputLabel value="To:" for="end" style="font-weight:bold;"></h:outputLabel>
				<h:outputText id="end" value="#{munichWorkshopBean.event.end}"></h:outputText>
			</h:panelGrid>

			<h:message for="bookingForm" styleClass="message"></h:message>
			<h:message for="bookGrid" styleClass="errorsGlobal"></h:message>

			<h:panelGrid columns="4" rowClasses="prop"
				columnClasses="name,value,comment">

				<f:facet name="header">
					<h:outputText value="Personal information:"></h:outputText>
				</f:facet>


				<h:outputLabel value="First name:" for="firstName">
				</h:outputLabel>

				<h:inputText id="firstName"
					value="#{munichWorkshopBean.booking.firstName}" required="true"
					size="40">
				</h:inputText>

				<h:panelGroup>
				</h:panelGroup>

				<h:outputLabel value="Last name:" for="lastName">
				</h:outputLabel>


				<h:inputText id="lastName"
					value="#{munichWorkshopBean.booking.lastName}" size="40"
					required="true">
				</h:inputText>


				<h:panelGroup>
				</h:panelGroup>


				<h:message for="lastName" styleClass="errors">
				</h:message>


				<h:outputLabel value="Email:" for="email">
				</h:outputLabel>


				<h:inputText id="email" value="#{munichWorkshopBean.booking.email}"
					required="true" size="30"
					validator="#{munichWorkshopBean.validateEmail}">
				</h:inputText>

				<h:panelGroup>
				</h:panelGroup>


				<h:message for="email" styleClass="errors">
				</h:message>


				<h:outputLabel value="Institution:" for="institution"></h:outputLabel>
				<h:inputText id="institution"
					value="#{munichWorkshopBean.booking.institution}" required="true"
					size="30">
				</h:inputText>


				<h:panelGroup>
				</h:panelGroup>

				<h:message for="institution" styleClass="errors">
				</h:message>

				<h:outputLabel value="Country:" for="country">
				</h:outputLabel>

				<h:inputText id="country"
					value="#{munichWorkshopBean.booking.country}" required="true"
					size="30">
				</h:inputText>

				<h:panelGroup>
				</h:panelGroup>


				<h:message for="country" styleClass="errors">
				</h:message>

			</h:panelGrid>


			<h:panelGrid columns="4" rowClasses="prop"
				columnClasses="name,value,comment">

				<f:facet name="header">
					<h:outputText value="Accommodation"></h:outputText>
				</f:facet>

				<h:outputLabel value="Accommodation needed?"
					for="accommodationNeeded"></h:outputLabel>
				<h:selectOneRadio id="accommodationNeeded"
					value="#{munichWorkshopBean.booking.accommodationYesNo}"
					required="true">
					<f:selectItem itemLabel="no" itemValue="no" />
					<f:selectItem itemLabel="yes" itemValue="yes" />
				</h:selectOneRadio>
				<h:panelGroup></h:panelGroup>
				<h:message for="accommodationNeeded" styleClass="errors"></h:message>

				<h:outputLabel value="Number of Nights:" for="numberofNights"></h:outputLabel>

				<h:selectManyCheckbox id="numberofNights"
					value="#{munichWorkshopBean.booking.numberOfNights}">
					<f:selectItem itemLabel="07.05.2015" itemValue="07.05.2015" />
				</h:selectManyCheckbox>
				<h:panelGroup></h:panelGroup>
			</h:panelGrid>


                                        
                                        <h:panelGrid columns="4" rowClasses="prop"
				columnClasses="name,value,comment">

				<f:facet name="header">
					<h:outputText value="Dinner 07 May 2015, 20:00"></h:outputText>
				</f:facet>

				<h:outputLabel value="Dinner"></h:outputLabel>
				<h:selectOneRadio id="dinnerNeeded"
					value="#{munichWorkshopBean.booking.dinnerNeeded}">
					<f:selectItem itemLabel="yes" itemValue="yes" />
					<f:selectItem itemLabel="no" itemValue="no" />
				</h:selectOneRadio>
				<h:outputLink value="http://www.weihenstephaner.de/" >
					<f:verbatim>Dinner 07 May 2015, 20:00</f:verbatim>
				</h:outputLink>
				
				<h:message for="dinnerNeeded" styleClass="errors"></h:message>
			</h:panelGrid>


			<h:panelGrid columns="4" rowClasses="prop"
				columnClasses="name,value,comment">

				<h:outputLabel value="General Remarks:" for="generalremarks"
					escape="true">
				</h:outputLabel>

				<h:inputTextarea id="generalremarks"
					value="#{munichWorkshopBean.booking.remarks}">
				</h:inputTextarea>

				<h:message for="generalremarks" styleClass="errors">
				</h:message>
			</h:panelGrid>


			<h:outputText
				value="(email address: michael.hagn@helmholtz-muenchen.de)">
			</h:outputText>

			<div class="buttons">
				<SPAN class="button"> <h:commandButton id="saveBooking"
						styleClass="save" actionListener="#{munichWorkshopBean.bookEvent}"
						value="book event">
					</h:commandButton>
				</SPAN>
			</div>

			<h:message for="saveBooking" styleClass="errors">
			</h:message>

		</h:panelGrid>
	</h:form>
</body>
	</html>
</f:view>