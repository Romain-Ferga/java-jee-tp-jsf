package eu.esic.formation.gesta.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.esic.formation.gesta.utils.GestaConstantes;

/**
 * Servlet Filter implementation class GestaSecurityFilter
 */
public class GestaSecurityFilter implements Filter {

	private ServletContext context = null;
	/**
	 * Default constructor. 
	 */
	public GestaSecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		if((session == null || session.getAttribute(GestaConstantes.LOGGING_BEAN_KEY) == null)
				&& !(uri.endsWith("connexion.jsf") || uri.endsWith("connexion.xhtml") || uri.endsWith(".css") || uri.endsWith(".js"))){
			this.context.log("Unauthorized access request");
			res.sendRedirect(req.getContextPath()+"/vues/connexion.jsf");
		}else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		fConfig.getServletContext().log("LoggerFilter initialized");
	}

}
