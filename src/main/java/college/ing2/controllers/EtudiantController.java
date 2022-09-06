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

import college.ing2.daos.EtudiantDao;
import college.ing2.models.Etudiant;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet("/etudiant/*")
public class EtudiantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	EtudiantDao etudiantDao = null;
    public EtudiantController() {
        super();
        etudiantDao = new EtudiantDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getRequestURI();
		action = action.substring(action.lastIndexOf("/")).toLowerCase();
		
		try {
			 switch (action) {
             case "/add-etudiant":
                 showAddEtudiant(request, response);
                 break;
             /*case "/insert-etudiant":
                 insertEtudiant(request, response);
                 break;*/
             case "/delete-etudiant":
                 deleteEtudiant(request, response);
                 break;
             case "/edit-etudiant":
                 showEditEtudiant(request, response);
                 break;
             /*case "/update-etudiant":
                 updateEtudiant(request, response);
                 break;*/
             default:
             	
             	getAllEtudiants(request, response);
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
			insertEtudiant(request, response);
		}else {
			updateEtudiant(request, response);
		}
	}
	
	private void getAllEtudiants(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
		        
        List<Etudiant> listEtudiants = etudiantDao.getAll();
		
		request.setAttribute("listEtudiants", listEtudiants);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/etudiantList.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showAddEtudiant(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/etudiantForm.jsp");
		        dispatcher.forward(request, response);
		    }
	
	 private void showEditEtudiant(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			    	int id = Integer.parseInt(request.getParameter("id"));
					
			    	Etudiant etudiant = etudiantDao.findById(id);
					
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/etudiantForm.jsp");
			        request.setAttribute("etudiant", etudiant);
			        dispatcher.forward(request, response);

			    }
	 private void insertEtudiant(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			    	Etudiant etudiant = new Etudiant();
			    	etudiant.setNom(request.getParameter("nom"));
			    	etudiant.setPrenom(request.getParameter("prenom"));
			    	etudiant.setDateNaissance(LocalDate.parse(request.getParameter("dateNaissance")));
					etudiant.setTelephone(request.getParameter("telephone"));
					etudiant.setEmail(request.getParameter("email"));
					etudiant.setDateEntree(LocalDate.parse(request.getParameter("dateEntree")));
					if(etudiantDao.save(etudiant)) {
						request.setAttribute("NOTIFICATION", "Etudiant enregistré avec succès!");
					}
					getAllEtudiants(request, response);
			        //response.sendRedirect("list");
			    }
	 private void updateEtudiant(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        Etudiant etudiant = new Etudiant();
			        etudiant.setNom(request.getParameter("nom"));
			    	etudiant.setPrenom(request.getParameter("prenom"));
			    	etudiant.setDateNaissance(LocalDate.parse(request.getParameter("dateNaissance")));
					etudiant.setTelephone(request.getParameter("telephone"));
					etudiant.setEmail(request.getParameter("email"));
					etudiant.setDateEntree(LocalDate.parse(request.getParameter("dateEntree")));
			    	etudiant.setId(id);
					if(etudiantDao.update(etudiant)) {
						request.setAttribute("NOTIFICATION", "Etudiant modifié avec succès!");
					}
					getAllEtudiants(request, response);
			        //response.sendRedirect("list");
			    }
	 private void deleteEtudiant(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			    	
					if(etudiantDao.delete(id)) {
						request.setAttribute("NOTIFICATION", "Etudiant supprimé avec succès!");
					}
					getAllEtudiants(request, response);
			        //response.sendRedirect("list");

			    }

}
