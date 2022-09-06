package college.ing2.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import college.ing2.daos.CollegeDao;
import college.ing2.models.College;

/**
 * Servlet implementation class CollegeController
 */
@WebServlet("/college/*")
public class CollegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	CollegeDao collegeDao = null;
    public CollegeController() {
        super();
        collegeDao = new CollegeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getRequestURI();
		action = action.substring(action.lastIndexOf("/")).toLowerCase();
		
		try {
			 switch (action) {
             case "/add-college":
                 showAddCollege(request, response);
                 break;
             /*case "/insert-college":
                 insertCollege(request, response);
                 break;*/
             case "/delete-college":
                 deleteCollege(request, response);
                 break;
             case "/edit-college":
                 showEditCollege(request, response);
                 break;
             /*case "/update-college":
                 updateCollege(request, response);
                 break;*/
             default:
             	
             	getAllColleges(request, response);
                 break;
         }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			insertCollege(request, response);
		}else {
			updateCollege(request, response);
		}
	}
    
    private void getAllColleges(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
		        
        List<College> listColleges = collegeDao.getAll();
		
		request.setAttribute("listColleges", listColleges);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/collegeList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showAddCollege(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/collegeForm.jsp");
		        dispatcher.forward(request, response);
		    }
    

	private void showEditCollege(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	int id = Integer.parseInt(request.getParameter("id"));
				
		    	College college = collegeDao.findById(id);
				
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/collegeForm.jsp");
		        request.setAttribute("college", college);
		        dispatcher.forward(request, response);

		    }
	
	 private void insertCollege(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			    	College college = new College();
			    	college.setNomCollege(request.getParameter("nomCollege"));
			    	college.setSiteWeb(request.getParameter("siteWeb"));
					if(collegeDao.save(college)) {
						request.setAttribute("NOTIFICATION", "College enregistré avec succès!");
					}
					getAllColleges(request, response);
			        //response.sendRedirect("list");
			    }
	 private void updateCollege(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        College college = new College();
			    	college.setNomCollege(request.getParameter("nomCollege"));
			    	college.setSiteWeb(request.getParameter("siteWeb"));
			    	college.setId(id);
					if(collegeDao.update(college)) {
						request.setAttribute("NOTIFICATION", "College modifié avec succès!");
					}
					getAllColleges(request, response);
			        //response.sendRedirect("list");
			    }
	 
	 private void deleteCollege(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			    	
					if(collegeDao.delete(id)) {
						request.setAttribute("NOTIFICATION", "College supprimé avec succès!");
					}
					getAllColleges(request, response);
			        //response.sendRedirect("list");

			    }
	 
	 

}
