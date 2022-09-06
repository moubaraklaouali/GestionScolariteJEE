package college.ing2.controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import college.ing2.daos.MatiereDao;
import college.ing2.daos.SalleDao;
import college.ing2.models.Matiere;
import college.ing2.models.Salle;

/**
 * Servlet implementation class MatiereController
 */
@WebServlet("/matiere/*")
public class MatiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	MatiereDao matiereDao = null;
	SalleDao salleDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatiereController() {
    	matiereDao = new MatiereDao();
    	salleDao = new SalleDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getRequestURI();
		action = action.substring(action.lastIndexOf("/")).toLowerCase();

        try {
            switch (action) {
                case "/add-matiere":
                    showAddMatiere(request, response);
                    break;
                /*case "/insert-matiere":
                    insertMatiere(request, response);
                    break;*/
                case "/delete-matiere":
                    deleteMatiere(request, response);
                    break;
                case "/edit-matiere":
                    showEditMatiere(request, response);
                    break;
                case "/detail-matiere":
                	showMoyenneMatiere(request, response);
                    break;
                /*case "/update-matiere":
                    updateMatiere(request, response);
                    break;*/
                default:
                	getAllMatieres(request, response);
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
			insertMatiere(request, response);
		}else {
			updateMatiere(request, response);
		}
	}
    
    private void getAllMatieres(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
		        
        List<Matiere> listMatieres = matiereDao.getAll();
		
		request.setAttribute("listMatieres", listMatieres);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/matiereList.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showAddMatiere(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/matiereForm.jsp");
    	        
    	        List<Salle> listSalle = salleDao.getAll();
    			request.setAttribute("listSalle", listSalle);
    	        dispatcher.forward(request, response);
    	    }
    
    private void showEditMatiere(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    	int id = Integer.parseInt(request.getParameter("id"));
    			
    	    	Matiere matiere = matiereDao.findById(id);
    			
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/matiereForm.jsp");
    	        request.setAttribute("matiere", matiere);
    	        
    	        List<Salle> listSalle = salleDao.getAll();
    			request.setAttribute("listSalle", listSalle);
    			
    	        dispatcher.forward(request, response);

    	    }
    
    private void showMoyenneMatiere(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				float moyen=matiereDao.moyenne(id);
				Matiere matiere = matiereDao.findById(id);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/matiereDetail.jsp");
				request.setAttribute("matiere", matiere);
				request.setAttribute("moyen", moyen);
				dispatcher.forward(request, response);
				
	}
    
    private void insertMatiere(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    	    	Matiere matiere = new Matiere();
    	    	matiere.setLibelleMatiere(request.getParameter("libelleMatiere"));
    			matiere.setCodeMatiere(request.getParameter("codeMatiere"));
    	    	Salle salle = new Salle();
    	    	salle.setId(Integer.valueOf(request.getParameter("salleId")));
    	    	matiere.setSalle(salle);
    			
    			if(matiereDao.save(matiere)) {
    				request.setAttribute("NOTIFICATION", "Matiere enregistré avec succès!");
    			}
    			
    	        //response.sendRedirect("list");
    			getAllMatieres(request, response);
    	    }
    
    private void updateMatiere(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    			Matiere matiere = new Matiere();
    	    	matiere.setLibelleMatiere(request.getParameter("libelleMatiere"));
    			matiere.setCodeMatiere(request.getParameter("codeMatiere"));
    	    	
    	    	Salle salle = new Salle();
    	    	salle.setId(Integer.valueOf(request.getParameter("salleId")));
    	    	matiere.setSalle(salle);

    	    	matiere.setId(id);
    			if(matiereDao.update(matiere)) {
    				request.setAttribute("NOTIFICATION", "Matiere modifié avec succès!");
    			}
    			getAllMatieres(request, response);
    	        //response.sendRedirect("list");
    	    }
    
    private void deleteMatiere(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    	    	
    			if(matiereDao.delete(id)) {
    				request.setAttribute("NOTIFICATION", "Matiere supprimé avec succès!");
    			}
    	        //response.sendRedirect("list");
    			getAllMatieres(request, response);

    	    }
}
