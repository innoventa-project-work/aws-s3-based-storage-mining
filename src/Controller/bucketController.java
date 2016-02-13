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

import DAO.bucketDAO;
import DAO.regionDAO;
import VO.bucketVO;
import VO.regionVO;

/**
 * Servlet implementation class bucketController
 */
@WebServlet("/bucketController")
public class bucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bucketController() {
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
		if(flag.equals("SearchBucket"))
		{
			searchbucket(request,response);
		}
		if(flag.equals("Editbucket"))
		{
			editbucket(request,response);
		}
	}

	private void editbucket(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bucketId=Integer.parseInt(request.getParameter("bucketId"));
		regionVO regionVO=new regionVO();
		regionDAO regionDAO=new regionDAO();
		List regionList=regionDAO.searchRegion(regionVO);
		bucketVO bucketVO=new bucketVO();
		bucketDAO bucketDAO=new bucketDAO();
		bucketVO.setId(bucketId);
		List list=new ArrayList();
		list=bucketDAO.EditBucket(bucketVO);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("bucketList", list);
		session.setAttribute("regionList", regionList);
		response.sendRedirect("client/bucketEdit.jsp");
	}

	private void searchbucket(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		bucketVO bucketVO=new bucketVO();
		bucketDAO bucketDAO=new bucketDAO();
		List list=new ArrayList();
		list=bucketDAO.SearchBucket(bucketVO);
		HttpSession session = request.getSession();
		session.setAttribute("bucketList",list );
		System.out.println(list);
		response.sendRedirect("client/bucketTable.jsp");
	}

	private void searchregion(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		regionVO regionVO=new regionVO();
		bucketDAO bucketDAO=new bucketDAO();
		List list=bucketDAO.searchRegion(regionVO);
		HttpSession session = request.getSession();
		session.setAttribute("regionList", list);
		response.sendRedirect("client/bucketc.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("insertBucket"))
		{
			insert(request,response);
		}
		if(flag.equals("UpdateBucket"))
		{
			updatebucket(request,response);
		}
	}

	private void updatebucket(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bucketId=Integer.parseInt(request.getParameter("bucketId"));

		String bucketName=request.getParameter("bucketName");
		String regionName=request.getParameter("regionName");
		HttpSession session=request.getSession();
		bucketVO bucketVO=new bucketVO();
		bucketVO.setBucketName(bucketName);
		bucketVO.setId(bucketId);
		regionVO regionVO=new regionVO();
		regionVO.setRegionId(Integer.parseInt(regionName));
		bucketVO.setRegionVO(regionVO);
		bucketDAO bucketDAO=new bucketDAO();
		bucketDAO.UpdateBucket(bucketVO);
		searchbucket(request, response);

	}

	private void insert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bucketName=request.getParameter("bucketName");
		String regionName=request.getParameter("regionName");
		HttpSession session=request.getSession();
		bucketVO bucketVO=new bucketVO();
		bucketVO.setBucketName(bucketName);
		
		regionVO regionVO=new regionVO();
		regionVO.setRegionId(Integer.parseInt(regionName));
		bucketVO.setRegionVO(regionVO);
		bucketDAO bucketDAO=new bucketDAO();
		bucketDAO.InsertBucket(bucketVO);
		response.sendRedirect("client/bucketc.jsp");
	}

}
