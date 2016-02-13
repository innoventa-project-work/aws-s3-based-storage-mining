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

import DAO.countryDAO;
import DAO.stateDAO;
import VO.countryVO;
import VO.stateVO;

/**
 * Servlet implementation class stateController
 */
@WebServlet("/stateController")
public class stateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private stateVO v2;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stateController() {
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
		if(flag.equals("SearchState"))
		{
			
			search(request, response);
			}
		if(flag.equals("EditState"))
		{
			
			edit(request, response);
			}
		if(flag.equals("DeleteState"))
		{
			
			delete(request, response);
			}
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int stateId= Integer.parseInt(request.getParameter("stateId"));
		stateVO sv=new stateVO();
		stateDAO sd=new stateDAO();
		countryVO cv = new countryVO();
		sv.setStateId(stateId);
		
		
		stateDAO.DeleteState(sv);
		search(request, response);
	}

	private void searchCountry(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		countryVO countryVO = new countryVO();
		stateDAO stateDAO = new stateDAO();
		List ls = stateDAO.searchCountry(countryVO);
		HttpSession session = request.getSession();
		session.setAttribute("countryList", ls);
		response.sendRedirect("admin/state.jsp");

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("InsertState"))
		{
			insert(request, response);
		}
		if(flag.equals("UpdateState"))
		{
			update(request, response);
		}
		
		
	}

	protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String countryName=request.getParameter("country");
		String stateName=request.getParameter("stateName");
		String stateDescription=request.getParameter("stateDescription");
		
		
		stateVO v=new stateVO();
		
		countryVO cv=new countryVO();
		cv.setId(Integer.parseInt(countryName));
		v.setStateName(stateName);
		v.setStateDescription(stateDescription);
		v.setCv(cv);	
		
		stateDAO d = new stateDAO();
		d.InsertState(v);
		
		response.sendRedirect("admin/state.jsp");
		
}
protected void update (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int stateId= Integer.parseInt(request.getParameter("stateId"));
		String countryName=request.getParameter("country");
		String stateName=request.getParameter("stateName");
		String stateDescription=request.getParameter("stateDescription");
	
		
		stateVO v=new stateVO();
		
		countryVO cv=new countryVO();
		cv.setId(Integer.parseInt(countryName));
		v.setStateId(stateId);
		v.setStateName(stateName);
		v.setStateDescription(stateDescription);
		v.setCv(cv);	
		
		stateDAO d = new stateDAO();
		d.UpdateState(v);
		
		search(request, response);

		
	
	
}

protected void search (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	stateDAO d1=new stateDAO();
	countryVO cv = new countryVO();
	
	List ls =new ArrayList();
	ls=d1.SearchState(v2);
	HttpSession session = request.getSession();
	session.setAttribute("stateList",ls );
	System.out.println(ls);
	response.sendRedirect("admin/stateTable.jsp");
	
}

protected void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	// TODO Auto-generated method stub
	int stateId=Integer.parseInt(request.getParameter("stateId"));
	countryVO cv=new countryVO();
	countryDAO cd=new countryDAO();
	List countryList=cd.SearchCountry(cv);
	
	stateVO sv=new stateVO();
	stateDAO sd=new stateDAO();
	sv.setStateId(stateId);
	
	List ls=new ArrayList();
	ls=sd.EditState(sv);
	System.out.println(ls);
	HttpSession session=request.getSession();
	session.setAttribute("stateList", ls);
	session.setAttribute("countryList", countryList);
	response.sendRedirect("admin/stateEdit.jsp");
}

}
