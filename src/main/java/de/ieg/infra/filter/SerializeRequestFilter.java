package de.ieg.infra.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class SerializeRequestFilter implements Filter {

    private static final String SYNC_OBJECT_KEY = "SYNC_OBJECT_KEY";
    private static String localAddress;
    private static String remoteAddress;

    /** {@inheritDoc} * */
    public void init(FilterConfig config) throws ServletException {
    }

    /** {@inheritDoc} */
    public void destroy() {
    }

    /** {@inheritDoc} */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        final HttpSession session = ((HttpServletRequest) request).getSession();
        // getLocalAddr() returns the IP of the server the application is running on.
        this.localAddress=request.getLocalAddr()+ "";
        this.remoteAddress=request.getRemoteAddr();
        synchronized (getSynchronizationObject(session)) {
            chain.doFilter(request, response);
        }
    }

    /**
     * Besorge ein Objekt, auf dem wir uns synchronisieren k�nnen.
     * 
     * @param session
     *            Http-Session
     */
    private static synchronized Object getSynchronizationObject(
            HttpSession session) {
        Object syncObj = session.getAttribute(SYNC_OBJECT_KEY);
        if (syncObj == null) {
            syncObj = new Object();
            session.setAttribute(SYNC_OBJECT_KEY, syncObj);
            
            //Logger.getLogger("debugLogger").debug("Local Address: " + localAddress);
            Logger.getLogger("debugLogger").debug("Remote Address: " + remoteAddress);
        }
        return syncObj;
    }

}
