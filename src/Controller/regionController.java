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

import DAO.regionDAO;
import VO.regionVO;

/**
 * Servlet implementation class regionController
 */
@WebServlet("/regionController")
public class regionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("SearchRegion"))
				{
					searchregion(request,response);
				}
		if(flag.equals("editRegion"))
		{
			editregion(request,response);
		}								
	}

	private void editregion(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regionid = Integer.parseInt(request.getParameter("regionId"));
		regionVO regionVO=new regionVO();
		regionDAO regionDAO=new regionDAO();
		regionVO.setRegionId(regionid);
		List list=new ArrayList();
		list=regionDAO.editregion(regionVO);
		HttpSession session=request.getSession();
		session.setAttribute("Editregionlist",list);
		response.sendRedirect("admin/regionEdit.jsp");
	}

	private void searchregion(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		regionVO regionVO=new regionVO();
		regionDAO regionDAO=new regionDAO();
		List list=new ArrayList();
		list=regionDAO.searchRegion(regionVO);
		HttpSession session = request.getSession();
		session.setAttribute("regionList",list );
		System.out.println(list);
		response.sendRedirect("admin/regionTable.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertRegion"))
				{
					insert(request,response);
				}
				if(flag.equals("UpdateRegion"))
				{
					updateregion(request,response);
				}	
	}

	private void updateregion(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regionId=Integer.parseInt(request.getParameter("regionid"));
		String regionName=request.getParameter("regionName");
		String regionDescription=request.getParameter("regionDescription");
		regionVO regionVO=new regionVO();
		regionVO.setRegionId(regionId);
		regionVO.setRegionName(regionName);
		regionVO.setRegionDescription(regionDescription);
		regionDAO regionDAO=new regionDAO();
		regionDAO.UpdateRegion(regionVO);
		searchregion(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regionName=request.getParameter("regionName");
		String regionDescription=request.getParameter("regionDescription");
		HttpSession session=request.getSession();
		regionVO regionVO=new regionVO();
		regionVO.setRegionName(regionName);
		regionVO.setRegionDescription(regionDescription);
		regionDAO regionDAO=new regionDAO();
		regionDAO.insert(regionVO);
		response.sendRedirect("admin/AddRegion.jsp");
	}

}
