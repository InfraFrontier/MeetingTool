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
						
<h:outputText id="eventName" value="#{managementWorkshopBean.event.name}"></h:outputText>
						
<h:outputLabel value="Location:" for="Location" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="Location" value="#{managementWorkshopBean.event.place}"></h:outputText>
						
<h:outputLabel value="From:" for="start" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="start" value="#{managementWorkshopBean.event.start}"></h:outputText>
						
<h:outputLabel value="To:" for="end" style="font-weight:bold;"></h:outputLabel>
						
<h:outputText id="end" value="#{managementWorkshopBean.event.end}"></h:outputText>
						
					
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
						
<h:inputText id="firstName" value="#{managementWorkshopBean.booking.firstName}"
required="true" size="40">
</h:inputText>

<h:panelGroup>
</h:panelGroup>
						
<h:message for="firstName" styleClass="errors" />


						
						
<h:outputLabel value="Last name:" for="lastName">
</h:outputLabel>
						
<h:inputText id="lastName" value="#{managementWorkshopBean.booking.lastName}" size="40"
required="true">
</h:inputText>

<h:panelGroup>
</h:panelGroup>
						
<h:message for="lastName" styleClass="errors" />



<h:outputLabel value="Email:" for="email">
</h:outputLabel>		
<h:inputText id="email" value="#{managementWorkshopBean.booking.email}" required="true" size="30" validator="#{managementWorkshopBean.validateEmail}">
</h:inputText>

				
<h:panelGroup>
</h:panelGroup>
						
<h:message for="email" styleClass="errors">
</h:message>

						
<h:outputLabel value="Arrival time:" for="arrivalTime">
</h:outputLabel>
						
<h:inputText id="arrivalTime" value="#{managementWorkshopBean.booking.arrivalTime}"
required="true" size="40">
</h:inputText>

<h:panelGroup>
</h:panelGroup>

<h:message for="arrivalTime" styleClass="errors">
</h:message>
									
<h:outputLabel value="Departure time:" for="departureTime">
</h:outputLabel>
						
<h:inputText id="departureTime" value="#{managementWorkshopBean.booking.depatureTime}" size="40"
required="true">
</h:inputText>

						
<h:panelGroup>
</h:panelGroup>

<h:message for="departureTime" styleClass="errors">
</h:message>


</h:panelGrid>
													
<h:panelGrid columns="4" rowClasses="prop"
columnClasses="name,value,comment">
						
<f:facet name="header">
							
<h:outputText value="Accommodation"></h:outputText>
						
</f:facet>
						
						
<h:outputLabel value="Number of nights?" for="numberOfNights"></h:outputLabel>
<h:selectManyCheckbox id="nights" value="#{managementWorkshopBean.booking.numberOfNights}">
	<f:selectItem itemLabel="25.03.2014" itemValue="25.03.2014"/>
	<f:selectItem itemLabel="26.03.2014" itemValue="26.03.2014"/>
</h:selectManyCheckbox>					
<h:panelGroup></h:panelGroup>						
					
<h:panelGroup></h:panelGroup>
						
<h:message for="numberOfNights" styleClass="errors"></h:message>
										
</h:panelGrid>
<h:outputText style="font-weight: bold;" value="Please note that all travel and accommodation costs  must be covered by the participants. INFRAFRONTIER will assist you with booking accommodation if required.">
</h:outputText>
						
							
						
										
<h:outputText value="(email address: info@infrafrontier.eu)">
</h:outputText>
<div class="buttons">
						
<SPAN class="button">
<h:commandButton id="saveBooking" styleClass="save" actionListener="#{managementWorkshopBean.bookEvent}"
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