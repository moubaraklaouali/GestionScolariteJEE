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
import college.ing2.daos.DepartementDao;
import college.ing2.daos.EnseignantDao;
import college.ing2.models.College;
import college.ing2.models.Departement;
import college.ing2.models.Enseignant;

/**
 * Servlet implementation class DepartementController
 */
@WebServlet("/departement/*")
public class DepartementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	EnseignantDao enseignantDao = null;
	DepartementDao departementDao = null;
	CollegeDao collegeDao=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartementController() {
        super();
        enseignantDao = new EnseignantDao();
	    departementDao = new DepartementDao();
	    collegeDao= new CollegeDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getRequestURI();
		action = action.substring(action.lastIndexOf("/")).toLowerCase();

        try {
            switch (action) {
                case "/add-departement":
                    showAddDepartement(request, response);
                    break;
                /*case "/insert-departement":
                    insertDepartement(request, response);
                    break;*/
                case "/delete-departement":
                    deleteDepartement(request, response);
                    break;
                case "/edit-departement":
                    showEditDepartement(request, response);
                    break;
                case "/detail-departement":
                	showMoyenneDepartement(request, response);
                    break;
                /*case "/update-departement":
                    updateDepartement(request, response);
                    break;*/
                default:
                	getAllDepartements(request, response);
                    break;
            }
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			insertDepartement(request, response);
		}else {
			updateDepartement(request, response);
		}
	}
	
	private void getAllDepartements(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			    
			List<Departement> listDepartements = departementDao.getAll();

			request.setAttribute("listDepartements", listDepartements);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/departementList.jsp");
			dispatcher.forward(request, response);
			}
	
	private void showAddDepartement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/departementForm.jsp");
			    List<Enseignant> listEnseignant = enseignantDao.getAll();
			    List<College> listCollege = collegeDao.getAll();
			    request.setAttribute("listEnseignant", listEnseignant);
			    
			        request.setAttribute("listCollege", listCollege);

			    dispatcher.forward(request, response);
			}
	
	private void showEditDepartement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
    	    	Departement departement = departementDao.findById(id);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/departementForm.jsp");
				request.setAttribute("departement", departement);
			    List<Enseignant> listEnseignant = enseignantDao.getAll();
			    List<College> listCollege = collegeDao.getAll();
			    request.setAttribute("listEnseignant", listEnseignant);
			    
			    request.setAttribute("listCollege", listCollege);

			    dispatcher.forward(request, response);
			}
	private void showMoyenneDepartement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				float moyen=departementDao.moyenne(id);
				Departement departement = departementDao.findById(id);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/departementDetail.jsp");
				request.setAttribute("departement", departement);
				request.setAttribute("moyen", moyen);
				dispatcher.forward(request, response);
				
	}
	
	private void insertDepartement(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    	    	Departement departement = new Departement();
    	    	departement.setLibelleDepartement(request.getParameter("libelleDepartement"));
    			departement.setCodeDepartement(request.getParameter("CodeDepartement"));
    	    	Enseignant enseignant = new Enseignant();
    	    	enseignant.setId(Integer.valueOf(request.getParameter("enseignantId")));
    	    	departement.setEnseignant(enseignant);

               College college = new College();
    	    	college.setId(Integer.valueOf(request.getParameter("collegeId")));
    	    	departement.setCollege(college);
    			
    			if(departementDao.save(departement)) {
    				request.setAttribute("NOTIFICATION", "Departement enregistré avec succès!");
    			}
    			
    	        //response.sendRedirect("list");
    			getAllDepartements(request, response);
    	    }
	
	private void updateDepartement(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
				int id = Integer.parseInt(request.getParameter("id"));
    	    	Departement departement = new Departement();
    	    	departement.setLibelleDepartement(request.getParameter("libelleDepartement"));
    			departement.setCodeDepartement(request.getParameter("codeDepartement"));
    	    	Enseignant enseignant = new Enseignant();
    	    	enseignant.setId(Integer.valueOf(request.getParameter("enseignantId")));
    	    	departement.setEnseignant(enseignant);

               College college = new College();
    	    	college.setId(Integer.valueOf(request.getParameter("collegeId")));
    	    	departement.setCollege(college);
    			departement.setId(id);
    			if(departementDao.update(departement)) {
    				request.setAttribute("NOTIFICATION", "Departement modifié avec succès!");
    			}
    			
    	        //response.sendRedirect("list");
    			getAllDepartements(request, response);
    	    }
	
	private void deleteDepartement(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			    int id = Integer.parseInt(request.getParameter("id"));
			    
			    if(departementDao.delete(id)) {
			        request.setAttribute("NOTIFICATION", "Departement supprimé avec succès!");
			    }
			    //response.sendRedirect("list");
			    getAllDepartements(request, response);

			}

}
