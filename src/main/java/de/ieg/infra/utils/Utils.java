package de.ieg.infra.utils;

import java.io.File;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.FacesEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author steinkamp
 * Utility class
 *
 */
public class Utils {
	/**
	 * Get servlet context.
	 *
	 * @return the servlet context
	 */
	public static ServletContext getServletContext() {
		return (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
	}
	
	
	/**
	 * @return the spring application context 
	 */
	public static ApplicationContext getApplicationContext() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ctx;
	}

	/**
	 * Get managed bean based on the bean name.
	 *
	 * @param beanName the bean name
	 * @return the managed bean associated with the bean name
	 */
	public static Object getManagedBean(String beanName) {
		Object o = getValueBinding(getJsfEl(beanName)).getValue(FacesContext.getCurrentInstance());
		return o;
	}

	/**
	 * Remove the managed bean based on the bean name.
	 *
	 * @param beanName the bean name of the managed bean to be removed
	 */
	public static void resetManagedBean(String beanName) {
		getValueBinding(getJsfEl(beanName)).setValue(FacesContext.getCurrentInstance(), null);
	}

	/**
	 * Store the managed bean inside the session scope.
	 *
	 * @param beanName the name of the managed bean to be stored
	 * @param managedBean the managed bean to be stored
	 */
	public static void setManagedBeanInSession(String beanName, Object managedBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
	}

	/**
	 * Get parameter value from request scope.
	 *
	 * @param name the name of the parameter
	 * @return the parameter value
	 * 
	 * Works only with the commandLink and the outputLink
	 * Example:
	 * <h:commandLink action="#{myBean.action}">
     *<f:param name="paramname1" value="paramvalue1" />
     *<f:param name="paramname2" value="paramvalue2" />
     *<h:outputText value="Click here" />
     *</h:commandLink>
	 */
	public static Object getRequestParameter(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
	
	/**
	 * Retrieve parameters from FacesEvents. Works with the CommandLink and the
	 * Command button
	 * @param ev an FacesEvent
	 * @param key the attribute name
	 * @return the parameter value
	 * 
	 * Example
	 *<h:commandLink actionListener="#{myBean.action}">
     *<f:attribute name="attrname1" value="attrvalue1" />
     *<f:attribute name="attrname2" value="attrvalue2" />
     * <h:outputText value="Click here" />
	 *	</h:commandLink>
	 */
	public static Object getAttributeFromEvent(FacesEvent ev,String key) {
			Object attrValue = ev.getComponent().getAttributes().get(key);
			return attrValue;
	}

	/**
	 * Add information message to a sepcific client and log debug message.
	 *
	 * @param clientId the client id
	 * @param msg the information message
	 */
	public static void addInfoMessage(String clientId, String msg) {
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	/**
	 * Add error message to a sepcific client.
	 *
	 * @param clientId the client id
	 * @param msg the error message
	 */
	public static void addErrorMessage(String clientId, String msg) {
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	
	/**
	 * Sets an request attribute
	 * @param attName
	 * @param attValue
	 */
	public static void setRequestAttribute(String attName, Object attValue) {
		getServletRequest().setAttribute(attName, attValue);
	}

	/**
	 * Returns a session attribute
	 * @param attName
	 * @return
	 */
	public static Object getSessionAttribute(String attName) {
	    return getServletRequest().getSession().getAttribute(attName);
	}

	/**
	 * Remose a session attribute
	 * @param attName
	 */
	public static void removeSessionAttribute(String attName) {
	    getServletRequest().getSession().removeAttribute(attName);
	}

	/**
	 * Returns a HttpServletresponse
	 * @return
	 */
	public static HttpServletResponse getServletResponse() {
	    return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Retruns the application context
	 * @return
	 */
	private static Application getApplication() {
		ApplicationFactory appFactory = (ApplicationFactory)FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
		return appFactory.getApplication();
	}

	/**
	 * @param el
	 * @return
	 */
	private static ValueBinding getValueBinding(String el) {
		return getApplication().createValueBinding(el);
	}

	/**
	 * Returns a HttpServletRequest
	 * @return
	 */
	private static HttpServletRequest getServletRequest() {
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * @param value
	 * @return
	 */
	private static String getJsfEl(String value) {
		return "#{" + value + "}";
	}

	

	/**
	 * Returns a message string from the message bundle
	 * @param bundleName
	 * @param id
	 * @param params
	 * @param locale
	 * @return
	 */
	public static String getDisplayString(String bundleName, String id,
			Object params[], Locale locale) {
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale,
				getCurrentClassLoader(params));
		try {
			text = bundle.getString(id);
		} catch (MissingResourceException e) {
			text = "!! key " + id + " not found !!";
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}
	
	/**
	 * @param defaultObject
	 * @return
	 */
	protected static ClassLoader getCurrentClassLoader(Object defaultObject)
	  {
	    ClassLoader loader =
	          Thread.currentThread().getContextClassLoader();
	    if (loader == null)
	    {
	      loader = defaultObject.getClass().getClassLoader();
	    }
	    return loader;
	  }
		
	/**
	 * Adds a new entry to the session map
	 * @param key
	 * @param ob
	 */
	public static void addToSessionMap(String key,Object ob) {
		getSessionMap().put(key, ob);
	}
	
	/**
	 * Returns the session map
	 * @return
	 */
	public static Map getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}
	
	/**
	 * Returns a value from the session map
	 * @param key
	 * @return
	 */
	public static Object getValueFromSessionMap(String key) {
		return getSessionMap().get(key);
	}
		
	/**
	 * Returns the remote ip address from a servlet requester
	 * @return
	 */
	public static String getIpAddress() {
		String ipAddress = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
		return ipAddress;
	}
		
	/**
	 * Returns the url of the application context
	 * @return
	 */
	public static String getContextURL () {
		FacesContext context = FacesContext.getCurrentInstance();
		String contextPath = context.getExternalContext().getRequestContextPath();
		String url = ((HttpServletRequest)context.getExternalContext().getRequest()).getRequestURL().toString();
		url = url.substring(0, url.indexOf(contextPath, url.indexOf("/"))) + contextPath;
		return url;
	}
	
	/**
	 * Returns the path of the application context
	 * @return
	 */
	public static String getContextPath() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getRequestContextPath();
	}
	
	/**
	 * Returns the complete path for the passed directory
	 * @param directory
	 * @return
	 */
	public static String getPath4Directory(String directory) {
		ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		return context.getRealPath(directory);
	}
	
	/**
	 * Returns a file list for the passed directory
	 * @param directory
	 * @return
	 */
	public static List getFileList (String directory) {
		List fileList = new ArrayList();
		String path = Utils.getPath4Directory(directory);
		File dir = new File(path);
		File [] files=  dir.listFiles();
		if (files== null) {
			return fileList;
		}else {
			for (int i=0;i < files.length;i++){
				File reportFile = files[i];
				if (reportFile.isFile()) {
					fileList.add(files[i]);
				}
			}
		}
		return fileList;
	}
		
	/**
	 * Returns the param value that fits to the passed param name
	 * @param name
	 * @return
	 */
	public static String getFacesParamValue(String name) {
		return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name); 
	}
	
	public static String formatDate(Date date) {
		String sDate=null;
		SimpleDateFormat formatter= new SimpleDateFormat("dd.MM.yyyy");
		try {
			sDate=formatter.format(date);
		}
		catch(Exception ex) {
			Logger.getLogger(Utils.class).error("formatDate() creates an error " + ex.getMessage()); 
		}
		return sDate;
	}

}
