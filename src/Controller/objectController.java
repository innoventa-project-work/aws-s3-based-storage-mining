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

import DAO.CityDAO;
import DAO.extensionDAO;
import DAO.objectDAO;
import VO.bucketVO;
import VO.categoryVO;
import VO.countryVO;

/**
 * Servlet implementation class objectController
 */
@WebServlet("/objectController")
public class objectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public objectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("SearchBucket"))
		{
			searchbucket(request,response);
		}
		if(flag.equals("loadExtension"))
		{
			loadextension(request,response);
			
		}
	}


	private void loadextension(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		categoryVO categoryVO=new categoryVO();
		categoryVO.setId(categoryId);
		objectDAO objectDAO=new objectDAO();
		List list=new ArrayList();
		list=objectDAO.loadExtension(categoryVO);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("extensionList", list);
		response.sendRedirect("client/json/loadExtension.jsp");
	}

	private void searchbucket(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		bucketVO bucketVO=new bucketVO();
		objectDAO objectDAO=new objectDAO();
		List list=objectDAO.searchbucket(bucketVO);
		HttpSession session=request.getSession();
		session.setAttribute("bucketList",list);
		categoryVO categoryVO=new categoryVO();
		
		List ls=objectDAO.searchcategory(categoryVO);
		
		session.setAttribute("categoryList",ls);
		response.sendRedirect("client/objectc.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
