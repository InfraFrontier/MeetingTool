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

		
<body >
			
<div class="logo"> <img src="<%=path%>/images/InfraLogo.gif"  alt="Infrafrontier"/></div>
			
<h:form id="bookingForm" styleClass="dialog">
				
<h:panelGrid columns="1" id="bookGrid">

					
<h:panelGrid columns="2" rowClasses="prop" columnClasses="name,value">																																																																																																																																																																																																																																																				
						
						
<h:outputLabel value="Event:" for="eventName" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="eventName" value="#{barcelonaWorkshopBean.event.name}"></h:outputText>
						
<h:outputLabel value="Location:" for="Location" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="Location" value="#{barcelonaWorkshopBean.event.place}"></h:outputText>
						
<h:outputLabel value="From:" for="start" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="start" value="#{barcelonaWorkshopBean.event.start}"></h:outputText>
						
<h:outputLabel value="To:" for="end" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="end" value="#{barcelonaWorkshopBean.event.end}"></h:outputText>
						
					
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
						
<h:inputText id="firstName" value="#{barcelonaWorkshopBean.booking.firstName}"
required="true" size="40">
</h:inputText>

<h:panelGroup>
</h:panelGroup>
						
<h:message for="firstName" styleClass="errors" />


												
						
<h:outputLabel value="Last name:" for="lastName">
</h:outputLabel>
						
<h:inputText id="lastName" value="#{barcelonaWorkshopBean.booking.lastName}" size="40"
required="true">
</h:inputText>
						
<h:panelGroup>
</h:panelGroup>
						
<h:message for="lastName" styleClass="errors">
</h:message>



<h:outputLabel value="Sex:" for="sex"></h:outputLabel>
						
<h:selectOneRadio id="sex" value="#{barcelonaWorkshopBean.booking.sex}" required="true">
							
<f:selectItem itemLabel="f" itemValue="f"/>
							
<f:selectItem itemLabel="m" itemValue="m"/>
						
</h:selectOneRadio>
						
<h:outputText style="font-weight: bold;" value="(as in your passport, required for flight booking)">
</h:outputText>	
						
<h:message for="sex" styleClass="errors">
</h:message>

						

<h:outputLabel value="Email:" for="email">
</h:outputLabel>
	
<h:inputText id="email" value="#{barcelonaWorkshopBean.booking.email}" required="true" size="30" validator="#{barcelonaWorkshopBean.validateEmail}">
</h:inputText>
						
<h:outputText style="font-weight: bold;" value="(required for flight booking)">
</h:outputText>
						
<h:message for="email" styleClass="errors">
</h:message>	
<h:outputLabel value="Institution:" for="institution"></h:outputLabel>

<h:inputText id="institution" value="#{barcelonaWorkshopBean.booking.institution}" required="true" size="30">
</h:inputText>
						
<h:panelGroup>
</h:panelGroup>
						
<h:message for="institution" styleClass="errors">
</h:message>			
<h:outputLabel value="Country:" for="country">
</h:outputLabel>
						
<h:inputText id="country" value="#{barcelonaWorkshopBean.booking.country}" required="true" size="30">
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
						
						
<h:outputLabel value="Accommodation needed?" for="accommodationNeeded"></h:outputLabel>
						
<h:selectOneRadio id="accommodationNeeded"
value="#{barcelonaWorkshopBean.booking.accommodationYesNo}" required="true">
						
<f:selectItem itemLabel="no" itemValue="no" />

<f:selectItem itemLabel="yes" itemValue="yes" />

</h:selectOneRadio>
						
<h:panelGroup></h:panelGroup>
						
<h:message for="accomodationNeeded" styleClass="errors"></h:message>
						
						
<h:outputLabel value="Number of nights:" for="numberofNights"></h:outputLabel>
						
<h:selectManyCheckbox id="numberofNights" value="#{barcelonaWorkshopBean.booking.numberOfNights}">
							
<f:selectItem itemLabel="12.11.2014" itemValue="12.11.2014"/>
							
<f:selectItem itemLabel="13.11.2014" itemValue="13.11.2014"/>
													
</h:selectManyCheckbox> 
						
					
<h:panelGroup></h:panelGroup>
						
</h:panelGrid>
					
			
					
					
<h:panelGrid columns="4" rowClasses="prop"
columnClasses="name,value,comment">
						
<f:facet name="header">
							
<h:outputText value="Travel">
</h:outputText>
						
</f:facet>
						
<h:outputLabel value="Flight to be booked by your own institution:" ></h:outputLabel>
						
<h:selectOneRadio id="flightBookedByMyOwn"
 value="#{barcelonaWorkshopBean.booking.flightBookedByOwnInstitution}" required="true">
							
<f:selectItem itemLabel="yes" itemValue="yes (flight will be booked by our own institution)" />
							
<f:selectItem itemLabel="no" itemValue="no (flight will be not booked by our own institution)" />
						
</h:selectOneRadio>
<h:panelGroup></h:panelGroup>
						
<h:message for="flightBookedByMyOwn" styleClass="errors">
</h:message>
						
						
<h:outputLabel value="Flight to be booked by INFRAFRONTIER Project Office:" ></h:outputLabel>
						
<h:selectOneRadio id="flightBookedByInfrafrontier"
 value="#{barcelonaWorkshopBean.booking.flightBookedByInfrafrontier}" required="true">
							
<f:selectItem itemLabel="yes" itemValue="yes (flight will be booked by INFRAFRONTIER Project Office)" />
							
<f:selectItem itemLabel="no" itemValue="no (flight will be not booked by INFRAFRONTIER Project Office)" />
						
</h:selectOneRadio>
						
<h:panelGroup></h:panelGroup>
						
<h:message for="flightBookedByInfrafrontier" styleClass="errors"></h:message>
					
</h:panelGrid>

<h:outputText style="font-weight: bold;" value="Please check carefully the offer sent by INFRAFRONTIER Project Office  before you sent the confirmation for issuing the ticket. 
INFRAFRONTIER will NOT cover the costs resulting from changes in the name of the ticket holder NOR changes resulting from conflicting appointments, after the ticket has been issued.
For further information please contact INFRAFRONTIER Project Office">
</h:outputText>
						
					
<h:panelGrid columns="4" rowClasses="prop"
columnClasses="name,value,comment">
						
<f:facet name="header">
							
<h:outputText value="Flight to meeting">
</h:outputText>
						
</f:facet>
						
<h:outputLabel value="From:" for="outFlightFrom">
</h:outputLabel>
						
<h:inputText id="outFlightFrom"
	value="#{barcelonaWorkshopBean.booking.outboundFlightFrom}" size="40">
</h:inputText>
						
<h:outputText value="City, Country" style="font-style: italic">
</h:outputText>
		
<h:message for="outFlightFrom" styleClass="errors">
</h:message>

						
<h:outputLabel value="To:" for="outFlightTo">
</h:outputLabel>
						
<h:inputText id="outFlightTo"
	value="#{barcelonaWorkshopBean.booking.outboundFlightTo}" size="40"></h:inputText>
						
<h:outputText value="City, Country" style="font-style: italic">
</h:outputText>
						
<h:message for="outFlightTo" styleClass="errors"></h:message>

						
<h:outputLabel value="Date:" for="outFlightDate"></h:outputLabel>
						
<h:panelGroup>
							
<h:inputText id="outFlightDate"
	value="#{barcelonaWorkshopBean.booking.outboundFlightDate}" immediate="true"
 onclick="return showCalendarForThis(this, 'd.m.y');" size="40">
								
<f:convertDateTime locale="de" pattern="dd.MM.yyyy" />
							
</h:inputText>
							
<h:graphicImage url="/images/calendar.gif"
styleClass="calendar-icon"
 onclick="return showCalendar('bookingForm:outFlightDate', 'd.m.y');" />
						
</h:panelGroup>
						
<h:outputText value="please use dd.mm.yyyy format" style="font-style: italic">
</h:outputText>
						
<h:message for="outFlightDate" styleClass="errors">
</h:message>

						
<h:outputLabel value="Arrival time:">
</h:outputLabel>
						
<h:panelGrid columns="4" id="outFlightTime">
							
<h:selectOneMenu value="#{barcelonaWorkshopBean.booking.outboundFlightHour}" >
								
<f:selectItems value="#{outTimeSelectItems.hours}" />
							
</h:selectOneMenu>
							
<h:outputText value=" : " style="weight:bold;"></h:outputText>
							
<h:selectOneMenu value="#{barcelonaWorkshopBean.booking.outboundFlightMinute}">
								
<f:selectItems value="#{outTimeSelectItems.minutes}" />
							
</h:selectOneMenu>

						
</h:panelGrid>

						
<h:outputText value="e.g. 16:30 arrival time" style="font-style: italic">
</h:outputText>
						
<h:message for="outFlightTime" styleClass="errors">
</h:message>
					
</h:panelGrid>
	
<h:panelGrid columns="4" rowClasses="prop"
 columnClasses="name,value,comment">
						
<f:facet name="header">
	
<h:outputText value="Flight from meeting">
</h:outputText>
						
</f:facet>
						
<h:outputLabel value="From:" for="returnFlightFrom">
</h:outputLabel>
						
<h:inputText id="returnFlightFrom"
	value="#{barcelonaWorkshopBean.booking.returnFlightFrom}" size="40"></h:inputText>
	
<h:outputText value="City, Country" style="font-style: italic">
</h:outputText>
						
<h:message for="returnFlightFrom" styleClass="errors">
</h:message>

						
<h:outputLabel value="To" for="returnFlightTo">
</h:outputLabel>
						
<h:inputText id="returnFlightTo"
	value="#{barcelonaWorkshopBean.booking.returnFlightTo}" size="40"></h:inputText>

<h:outputText value="City, Country" style="font-style: italic">
</h:outputText>
						
<h:message for="returnFlightTo" styleClass="errors">
</h:message>

						
<h:outputLabel value="Date:" for="returnFlightDate">
</h:outputLabel>
						
<h:panelGroup>
							
<h:inputText id="returnFlightDate"
	value="#{barcelonaWorkshopBean.booking.returnFlightDate}" immediate="true"
	onclick="return showCalendarForThis(this, 'd.m.y');" size="40">
								
<f:convertDateTime locale="de" pattern="dd.MM.yyyy" />
							
</h:inputText>
							
<h:graphicImage url="/images/calendar.gif"
styleClass="calendar-icon"
 onclick="return showCalendar('bookingForm:returnFlightDate', 'd.m.y');" />

</h:panelGroup>
						
<h:outputText value="please use dd.mm.yyyy format" style="font-style: italic">
</h:outputText>
						
<h:message for="returnFlightDate" styleClass="errors">
</h:message>

						
<h:outputLabel value="Departure time:" for="returnFlightTime">
</h:outputLabel>
						
<h:panelGrid columns="4" id="returnFlightTime">
							
<h:selectOneMenu value="#{barcelonaWorkshopBean.booking.returnFlightHour}">
								
<f:selectItems value="#{returnTimeSelectItems.hours}" />
							
</h:selectOneMenu>

<h:outputText value=" : " style="weight:bold;"></h:outputText>

<h:selectOneMenu value="#{barcelonaWorkshopBean.booking.returnFlightMinute}">
								
<f:selectItems value="#{returnTimeSelectItems.minutes}" />
							
</h:selectOneMenu>

						
</h:panelGrid>

						
<h:outputText value="e.g. 16:30 departure time" style="font-style: italic"></h:outputText>
						
<h:message for="returnFlightTime" styleClass="errors">
</h:message>
					
</h:panelGrid>


					
					
					
<h:panelGrid columns="4" rowClasses="prop"
 columnClasses="name,value,comment">
						
						
<h:outputLabel  value="Remarks:" for="remarks" escape="true">
							
						
</h:outputLabel>

<h:inputTextarea id="remarks" value="#{barcelonaWorkshopBean.booking.remarks}">
</h:inputTextarea>
						
<h:message for="remarks" styleClass="errors">
</h:message>
					
</h:panelGrid>
					
<h:outputText value="(email address: ana.decastro@helmholtz-muenchen.de)">
</h:outputText>


					
<div class="buttons">
						
<SPAN class="button">
<h:commandButton id="saveBooking" styleClass="save" actionListener="#{barcelonaWorkshopBean.bookEvent}"
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