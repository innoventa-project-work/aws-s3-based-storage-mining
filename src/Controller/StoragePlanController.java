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

import DAO.StoragePlanDAO;
import DAO.categoryDAO;
import VO.StoragePlanVo;
import VO.categoryVO;


/**
 * Servlet implementation class StoragePlanController
 */
@WebServlet("/StoragePlanController")
public class StoragePlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoragePlanVo v1;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoragePlanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("SearchStorage"))
		{
			search(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("InsertStorage"))
		{
			insert(request, response);
		}
	}
	

	protected void insert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String planName=request.getParameter("planName");
		String dataSize=request.getParameter("dataSize");
		String price=request.getParameter("price");
		String planDescription=request.getParameter("planDescription");
	
		HttpSession session = request.getSession();
		StoragePlanVo v=new StoragePlanVo();
		v.setPlanName(planName);
		v.setDataSize(dataSize);
		v.setPrice(price);
		v.setPlanDescription(planDescription);	
		StoragePlanDAO d1=new StoragePlanDAO();
		d1.InsertStorage(v);
		response.sendRedirect("admin/storageplan.jsp");
	
	
}
	protected void search (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoragePlanDAO d1=new StoragePlanDAO();
		List ls =new ArrayList();
		
		ls=d1.SearchStorage(v1);
		HttpSession session = request.getSession();
		session.setAttribute("storageList",ls );
		System.out.println(ls);
		response.sendRedirect("admin/storageTable.jsp");
		
	}


}
