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

import DAO.categoryDAO;
import DAO.countryDAO;
import VO.categoryVO;
import VO.countryVO;

/**
 * Servlet implementation class categoryController
 */
@WebServlet("/categoryController")
public class categoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private categoryVO v2;
	private categoryVO v;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("SearchCategory"))
		{
			search(request, response);
		}
		if(flag.equals("EditCategory"))
		{
			edit(request, response);
		}
		if(flag.equals("DeleteCategory"))
		{
			delete(request, response);
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int categoryId= Integer.parseInt(request.getParameter("categoryId"));
		categoryVO cv=new categoryVO();
		categoryDAO cd=new categoryDAO();
		cv.setId(categoryId);
		cd.DeleteCategory(cv);
		search(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("InsertCategory"))
		{
			insert(request, response);
		}
		if(flag.equals("UpdateCategory"))
		{
			update(request, response);
		}
		}
	
	protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName=request.getParameter("categoryName");
		String categoryDescription=request.getParameter("categoryDescription");
	
		HttpSession session = request.getSession();
		categoryVO v1=new categoryVO();
		v1.setCategoryName(categoryName);
		v1.setCategoryDescription(categoryDescription);
		categoryDAO d1=new categoryDAO();
		d1.InsertCategory(v1);
		
		response.sendRedirect("admin/category.jsp");
	
}
	protected void search (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categoryDAO d1=new categoryDAO();
		List ls =new ArrayList();
		
		ls=d1.SearchCategory(v2);
		HttpSession session = request.getSession();
		session.setAttribute("categoryList",ls );
		System.out.println(ls);
		response.sendRedirect("admin/categoryTable.jsp");
		
	}
	protected void edit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categoryDAO d1=new categoryDAO();
		int id =Integer.parseInt(request.getParameter("categoryId"));
		List ls =new ArrayList();
		
		System.out.println(ls);
		
		categoryVO cv = new categoryVO();
		cv.setId(id);
		ls=d1.EditCategory(cv);
		HttpSession session = request.getSession();
		session.setAttribute("categoryList",ls );
		response.sendRedirect("admin/categoryEdit.jsp");
		
	}

	protected void update (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		categoryDAO d1=new categoryDAO();
		int id =Integer.parseInt(request.getParameter("id"));
		String categoryDescription=request.getParameter("categoryDescription");
		String categoryName = request.getParameter("categoryName");
		categoryVO cv =new categoryVO();
		cv.setId(id);
		cv.setCategoryName(categoryName);
		cv.setCategoryDescription(categoryDescription);

	
		d1.UpdateCategory(cv);
		search(request, response);
	}


}
