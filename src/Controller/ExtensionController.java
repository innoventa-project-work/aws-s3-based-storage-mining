package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchControls;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.categoryDAO;
import DAO.extensionDAO;
import DAO.stateDAO;
import VO.ExtensionVO;
import VO.categoryVO;
import VO.countryVO;
import VO.stateVO;

/**
 * Servlet implementation class ExtensionController
 */
@WebServlet("/ExtensionController")
public class ExtensionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExtensionVO v2;
	private extensionDAO d;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtensionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		if(flag.equals("searchCategory"))
		{
			searchCategory(request,response);
		}
	
		if(flag.equals("SearchExtension"))
		{
			
			search(request, response);
			}
		if(flag.equals("EditExtension"))
		{
			
			edit(request, response);
		}

	}

	

	private void searchCategory(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		
		categoryVO categoryVO = new categoryVO();
		extensionDAO extensionDAO = new extensionDAO();
		List ls = extensionDAO.searchCategory(categoryVO);
		
		HttpSession session = request.getSession();
		session.setAttribute("categoryList", ls);
		response.sendRedirect("admin/AddExtension.jsp");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("InsertExtension"))
		{
			insert(request, response);
		}
		if(flag.equals("UpdateExtension"))
		{
			update(request, response);
		}
	}	
	private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int extensionId= Integer.parseInt(request.getParameter("extensionId"));
		String categoryName=request.getParameter("category");
		String extensionName=request.getParameter("extensionName");
		String extensionDescription=request.getParameter("extensionDescription");
		ExtensionVO ev = new ExtensionVO();
		categoryVO cv = new categoryVO();
		extensionDAO ed = new extensionDAO();
		cv.setId(Integer.parseInt(categoryName));
		ev.setCt(cv);
		ev.setExtensionId(extensionId);
		ev.setExtensionName(extensionName);
		ev.setExtensionDescription(extensionDescription);
		ed.UpdateExtension(ev);
		search(request, response);
		
	}

	protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String categoryName=request.getParameter("category");
				String extensionName=request.getParameter("extensionName");
				String extensionDescription=request.getParameter("extensionDescription");
			
				ExtensionVO v=new ExtensionVO();
				
				categoryVO ct=new categoryVO();
				ct.setId(Integer.parseInt(categoryName));
				v.setExtensionName(extensionName);
				v.setExtensionDescription(extensionDescription);
				v.setCt(ct);	
				
				extensionDAO d = new extensionDAO();
				d.InsertExtension(v);
				
				response.sendRedirect("admin/AddExtension.jsp");

				
			
			
	}
		protected void search (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			extensionDAO d1=new extensionDAO();
			
			List ls =new ArrayList();
			ls=d1.SearchExtension(v2);
			HttpSession session = request.getSession();
			session.setAttribute("extensionList",ls );
			System.out.println(ls);
			response.sendRedirect("admin/AddExtensionTable.jsp");
			
		}
		protected void edit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			extensionDAO d1=new extensionDAO();
			int extensionId =Integer.parseInt(request.getParameter("extensionId"));
			
			ExtensionVO ev = new ExtensionVO();
			ev.setExtensionId(extensionId);
			List ls =new ArrayList();
			ls=d1.EditExtension(ev);
			System.out.println(ls);
			HttpSession session = request.getSession();
			session.setAttribute("extensionList",ls );
			response.sendRedirect("admin/AddExtensionEdit.jsp");
			
			
		}


	}





