package Filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import VO.loginVO;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/*")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
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
		// place your code here

		// pass the request along the filter chain
		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("flag");
		String uri = ((HttpServletRequest)request).getRequestURI();

//		System.err.println("uri before condition : "+uri);
		
		if(uri.contains("InsertUser") || uri.contains("/css") || (uri.contains("/js") && !uri.contains(".jsp")) || (uri.contains("/json")) || uri.contains("/images")|| uri.contains("/fonts") ||uri.contains("/registration") || uri.contains("regController"))
		{
			//System.out.println("inside reg");
//			System.out.println("uri Passed : "+uri);
			//requestDispatcher = request.getRequestDispatcher("/user/register.jsp");  
			//requestDispatcher.forward(request,response);  
			chain.doFilter(request,response);
		}
		else if (flag!= null && flag.equals("logout")) {
			//session.removeAttribute("userID");
			//System.out.println("logout in else if");
		
			session.invalidate();
			requestDispatcher = request.getRequestDispatcher("/client/login.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		
		
		
		else if(flag != null && flag.equals("login") )
		{
			//System.out.println("Login");
			
			String loginEmail = request.getParameter("email");
			String loginPassword = request.getParameter("password");
			loginVO loginvo = new loginVO();
			loginvo.setEmail(loginEmail);
			loginvo.setPassword(loginPassword);
			loginDAO logindao = new loginDAO();
			List ls = logindao.authentication(loginvo);
			
			if(ls != null && ls.size()>=1){
				
				//Iterator itr = list.iterator();
				
				//while(itr.hasNext()){
				loginVO user=(loginVO) ls.get(0);
				
				long y = user.getLoginid();
				session.setAttribute("userID",y);
				
				System.out.println(user.getUserType());
			//	System.out.println(session.getAttribute("userId"));
				String type = user.getUserType();
				session.setAttribute("usertype",type);
				System.out.println(y);
				if(type.equalsIgnoreCase("admin"))
				{
					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");  
					requestDispatcher.forward(request,response);
				}
				else if(type.equalsIgnoreCase("user"))
				{
					requestDispatcher = request.getRequestDispatcher("/client/userhome.jsp");  
					requestDispatcher.forward(request,response);
				}
				else
				{
					requestDispatcher = request.getRequestDispatcher("/client/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("/client/login.jsp");
				requestDispatcher.forward(request,response);
			}	
		}
		
		else if(session.getAttribute("userID") != null)
		{
			String h = (String)session.getAttribute("usertype");
			//System.out.println("type = = = " + h);
			
			if(h!=null && h.equals("admin") && uri.contains("/admin")){
				
				//System.out.println("chain");
				chain.doFilter(request,response);
			}
			
			else if(h!=null && h.equals("user") && uri.contains("/client"))
			{
				//System.out.println("chain");
				chain.doFilter(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/client/error.jsp");  
				rd.forward(request,response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/client/login.jsp");  
			rd.forward(request,response);  
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
