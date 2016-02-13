package Controller;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import DAO.CityDAO;
import DAO.countryDAO;
import DAO.extensionDAO;
import DAO.stateDAO;
import VO.CityVO;
import VO.ExtensionVO;
import VO.categoryVO;
import VO.countryVO;
import VO.stateVO;

/**
 * Servlet implementation class stateController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private stateVO v2;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag.equals("searchCountry"))
		{
			searchCountry(request,response);
		}
		if(flag.equals("searchState"))
		{
			searchState(request,response);
		}
		if(flag.equals("SearchCity"))
		{
			
			search(request, response);
			}
		if(flag.equals("EditCity"))
		{
			
			edit(request, response);
			}
		if(flag.equals("loadState"))
		{
			loadState(request,response);
		}
	}
	
	private void loadState(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int countryId=Integer.parseInt(request.getParameter("countryId"));
		countryVO countryVO=new countryVO();
		countryVO.setId(countryId);
		CityDAO cityDAO=new CityDAO();
		List list=new ArrayList();
		list=CityDAO.loadState(countryVO);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("loadStateList", list);
		response.sendRedirect("admin/json/loadState.jsp");
	}

	private void searchCountry(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		countryVO cv=new countryVO();
		CityDAO cd=new CityDAO();
		List ls=CityDAO.searchCountry(cv);
		HttpSession session=request.getSession();
		session.setAttribute("countryList", ls);
		response.sendRedirect("admin/city.jsp");
	}

	private void searchState(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int countryId=Integer.parseInt(request.getParameter("countryId"));		
		countryVO cv=new countryVO();
		cv.setId(countryId);
		CityDAO cd=new CityDAO();
		List ls=cd.searchState(cv);
		HttpSession session=request.getSession();
		session.setAttribute("stateList", ls);
		response.sendRedirect("admin/json/loadState.jsp");
	}

	protected void search (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDAO d1=new CityDAO();
		List ls =new ArrayList();
		ls=d1.SearchCity(v2);
		HttpSession session = request.getSession();
		session.setAttribute("cityList",ls );
		System.out.println(ls);
		response.sendRedirect("admin/cityTable.jsp");
		
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(request.getParameter("cityId"));
		
		
		CityVO cv=new CityVO();
		CityDAO cd=new CityDAO();
		cv.setCid(cid);
		
		List ls=new ArrayList();
		ls=cd.EditCity(cv);
		System.out.println(ls);
		HttpSession session=request.getSession();
		session.setAttribute("cityList", ls);
		
		countryVO countryVO=new countryVO();
		CityDAO cityDAO=new CityDAO();
		List list=cityDAO.searchCountry(countryVO);
		session.setAttribute("countryList", list);
		
		response.sendRedirect("admin/cityEdit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("InsertCity"))
		{
			insert(request, response);
		}
		if(flag.equals("UpdateCity"))
		{
			update(request, response);
		}
		
		
	}

	protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String stateName=request.getParameter("state");
		String cityName=request.getParameter("cityName");
		String cityDescription=request.getParameter("cityDescription");
	
		
	
		CityVO v=new CityVO();
		
		stateVO cv=new stateVO();
		cv.setStateId(Integer.parseInt(stateName));
		v.setCityName(cityName);
		v.setCityDescription(cityDescription);
		v.setSv(cv);	
		
		CityDAO d = new CityDAO();
		d.InsertCity(v);
		
		response.sendRedirect("admin/city.jsp");

		
	
	
}
protected void update (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid= Integer.parseInt(request.getParameter("cid"));
		
		String stateName=request.getParameter("state");
		String cityName=request.getParameter("cityName");
		String cityDescription=request.getParameter("cityDescription");
	
		
		CityVO v=new CityVO();
		
		stateVO sv=new stateVO();
		
		sv.setStateId(Integer.parseInt(stateName));
		v.setCid(cid);
		v.setCityName(cityName);
		v.setCityDescription(cityDescription);
		v.setSv(sv);	
		
		CityDAO d = new CityDAO();
		d.UpdateCity(v);
		
		search(request, response);

		
	
	
}



}
