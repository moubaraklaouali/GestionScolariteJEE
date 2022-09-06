package college.ing2.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import college.ing2.daos.DepartementDao;
import college.ing2.daos.EnseignantDao;
import college.ing2.daos.MatiereDao;
import college.ing2.models.Departement;
import college.ing2.models.Enseignant;
import college.ing2.models.Matiere;

/**
 * Servlet implementation class EnseignantController
 */
@WebServlet("/enseignant/*")
public class EnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	EnseignantDao enseignantDao = null;
	DepartementDao departementDao = null;
	    MatiereDao matiereDao=null;
	       
    /**
     * @see HttpServlet#HttpServlet()
	 */
	  public EnseignantController() {
	    enseignantDao = new EnseignantDao();
	    departementDao = new DepartementDao();
	     matiereDao = new MatiereDao();
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getRequestURI();
		action = action.substring(action.lastIndexOf("/")).toLowerCase();

        try {
            switch (action) {
                case "/add-enseignant":
                    showAddEnseignant(request, response);
                    break;
                /*case "/insert-enseignant":
                    insertEnseignant(request, response);
                    break;*/
                case "/delete-enseignant":
                    deleteEnseignant(request, response);
                    break;
                case "/edit-enseignant":
                    showEditEnseignant(request, response);
                    break;
                /*case "/update-enseignant":
                    updateEnseignant(request, response);
                    break;*/
                default:
                	getAllEnseignants(request, response);
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
		        insertEnseignant(request, response);
		    }else {
		        updateEnseignant(request, response);
		    }
	}
	
	private void getAllEnseignants(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			    
			List<Enseignant> listEnseignants = enseignantDao.getAll();

			request.setAttribute("listEnseignants", listEnseignants);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/enseignantList.jsp");
			dispatcher.forward(request, response);
			}
	
	private void showAddEnseignant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/enseignantForm.jsp");
			    List<Departement> listDepartement = departementDao.getAll();
			    List<Matiere> listMatiere = matiereDao.getAll();
			    request.setAttribute("listDepartement", listDepartement);
			    
			        request.setAttribute("listMatiere", listMatiere);

			    dispatcher.forward(request, response);
			}
	
	private void showEditEnseignant(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    	int id = Integer.parseInt(request.getParameter("id"));
    			
    	    	Enseignant enseignant = enseignantDao.findById(id);
    			
    	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/enseignantForm.jsp");
    	        request.setAttribute("enseignant", enseignant);
    	        
                List<Departement> listDepartement = departementDao.getAll();
                    request.setAttribute("listDepartement", listDepartement);
                List<Matiere> listMatiere = matiereDao.getAll();
                request.setAttribute("listMatiere", listMatiere);
    			
    	        dispatcher.forward(request, response);

    	    }
	
	
	private void insertEnseignant(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    	    	Enseignant enseignant = new Enseignant();
    	    	enseignant.setNom(request.getParameter("nom"));
    			enseignant.setPrenom(request.getParameter("prenom"));
    			enseignant.setDateNaissance(LocalDate.parse(request.getParameter("dateNaissance")));
    			enseignant.setTelephone(request.getParameter("telephone"));
    			enseignant.setEmail(request.getParameter("email"));
    			enseignant.setIndice(request.getParameter("indice"));
    			enseignant.setDatePriseFonction(LocalDate.parse(request.getParameter("datePriseFonction")));
    	    	Departement departement = new Departement();
    	    	departement.setId(Integer.valueOf(request.getParameter("departementId")));
    	    	enseignant.setDepartement(departement);

               Matiere matiere = new Matiere();
    	    	matiere.setId(Integer.valueOf(request.getParameter("matiereId")));
    	    	enseignant.setMatiere(matiere);
    			
    			if(enseignantDao.save(enseignant)) {
    				request.setAttribute("NOTIFICATION", "enseignant enregistré avec succès!");
    			}
    			
    	        //response.sendRedirect("list");
    			getAllEnseignants(request, response);
    	    }
	
	private void updateEnseignant(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    			Enseignant enseignant = new Enseignant();
    	    	enseignant.setNom(request.getParameter("nom"));
    			enseignant.setPrenom(request.getParameter("prenom"));
    			enseignant.setDateNaissance(LocalDate.parse(request.getParameter("dateNaissance")));
    			enseignant.setTelephone(request.getParameter("telephone"));
    			enseignant.setEmail(request.getParameter("email"));
    			enseignant.setIndice(request.getParameter("indice"));
    			enseignant.setDatePriseFonction(LocalDate.parse(request.getParameter("datePriseFonction")));
    	    	Departement departement = new Departement();
    	    	departement.setId(Integer.valueOf(request.getParameter("departementId")));
    	    	enseignant.setDepartement(departement);

               Matiere matiere = new Matiere();
    	    	matiere.setId(Integer.valueOf(request.getParameter("matiereId")));
    	    	enseignant.setMatiere(matiere);
    	    	enseignant.setId(id);
    			if(enseignantDao.update(enseignant)) {
    				request.setAttribute("NOTIFICATION", "Enseignant modifié avec succès!");
    			}
    			getAllEnseignants(request, response);
    	        //response.sendRedirect("list");
    	    }
	
	private void deleteEnseignant(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			    int id = Integer.parseInt(request.getParameter("id"));
			    
			    if(enseignantDao.delete(id)) {
			        request.setAttribute("NOTIFICATION", "Enseignant supprimé avec succès!");
			    }
			    //response.sendRedirect("list");
			    getAllEnseignants(request, response);

			}
	
	
	

}
