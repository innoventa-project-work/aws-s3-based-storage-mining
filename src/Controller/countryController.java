package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.countryDAO;
import DAO.stateDAO;
import VO.countryVO;
import VO.stateVO;

/**
 * Servlet implementation class countryController
 */
@WebServlet("/countryController")
public class countryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private countryVO v1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public countryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if(flag.equals("SearchCountry"))
		{
			serch(request, response);
		}
		if(flag.equals("Editcountry"))
		{
			edit(request, response);
		}

		if(flag.equals("Deletecountry"))
		{
			delete(request, response);
		}
	}
    private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
    	int countryid= Integer.parseInt(request.getParameter("countryid"));
		countryVO cv=new countryVO();
		countryDAO cd=new countryDAO();
		cv.setId(countryid);
		cd.DeleteCountry(cv);
		serch(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int countryid= Integer.parseInt(request.getParameter("countryid"));
		countryVO cv=new countryVO();
		countryDAO cd=new countryDAO();
		cv.setId(countryid);
		List ls=new ArrayList();
		ls=cd.editcountry(cv);
		HttpSession session = request.getSession();
		session.setAttribute("editcountryList",ls );
		System.out.println(ls);
		response.sendRedirect("admin/countryEdit.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertCountry"))
		{
			insert(request, response);
		}
		if(flag.equals("UpdateCountry"))
		{
			update(request, response);
		}
		
	}

	
	
	

	protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryName=request.getParameter("countryName");
		String countryDescription=request.getParameter("countryDescription");
		HttpSession session = request.getSession();
		countryVO v=new countryVO();
		v.setCountryName(countryName);
		v.setCountryDescription(countryDescription);	
		countryDAO d=new countryDAO();
		d.InsertCountry(v);

		response.sendRedirect("admin/country.jsp");
}
	protected void serch (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		countryDAO d1=new countryDAO();
		List ls=new ArrayList();
		ls=d1.SearchCountry(v1);
		HttpSession session = request.getSession();
		session.setAttribute("countryList",ls );
		System.out.println(ls);
		response.sendRedirect("admin/countryTable.jsp");
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int countryId= Integer.parseInt(request.getParameter("id"));
		String countryName=request.getParameter("countryName");
       String countryDescription=request.getParameter("countryDescription");
	
		
		
		countryVO cv=new countryVO();
		cv.setId(countryId);
		cv.setCountryName(countryName);
		cv.setCountryDescription(countryDescription);
			
		
		countryDAO d = new countryDAO();
		d.UpdateCountry(cv);
		
		serch(request, response);
		
	

	}
	}
	
