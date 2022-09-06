package college.ing2.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import college.ing2.daos.SalleDao;
import college.ing2.models.Salle;

/**
 * Servlet implementation class EtudiantController
 */
@WebServlet("/salle/*")
public class SalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	SalleDao salleDao = null;
    public SalleController() {
        super();
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
             case "/add-salle":
                 showAddSalle(request, response);
                 break;
             /*case "/insert-salle":
                 insertSalle(request, response);
                 break;*/
             case "/delete-salle":
                 deleteSalle(request, response);
                 break;
             case "/edit-salle":
                 showEditSalle(request, response);
                 break;
             /*case "/update-salle":
                 updateSalle(request, response);
                 break;*/
             default:
             	
             	getAllSalles(request, response);
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
			insertSalle(request, response);
		}else {
			updateSalle(request, response);
		}
	}
	
	private void getAllSalles(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
		        
        List<Salle> listSalles = salleDao.getAll();
		
		request.setAttribute("listSalles", listSalles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/salleList.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showAddSalle(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/salleForm.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showEditSalle(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	int id = Integer.parseInt(request.getParameter("id"));
				
		    	Salle salle = salleDao.findById(id);
				
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/salleForm.jsp");
		        request.setAttribute("salle", salle);
		        dispatcher.forward(request, response);

		    }
	
	 private void insertSalle(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			    	Salle salle = new Salle();
			    	salle.setLibelleSalle(request.getParameter("libelleSalle"));
			    	salle.setNbPlace(Integer.valueOf(request.getParameter("nbPlace")));
					if(salleDao.save(salle)) {
						request.setAttribute("NOTIFICATION", "Salle enregistré avec succès!");
					}
					getAllSalles(request, response);
			        //response.sendRedirect("list");
			    }
	 
	 private void updateSalle(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        Salle salle = new Salle();
			    	salle.setLibelleSalle(request.getParameter("libelleSalle"));
			    	salle.setNbPlace(Integer.valueOf(request.getParameter("nbPlace")));
			    	salle.setId(id);
					if(salleDao.update(salle)) {
						request.setAttribute("NOTIFICATION", "Salle modifié avec succès!");
					}
					getAllSalles(request, response);
			        //response.sendRedirect("list");
			    }
	 
	 private void deleteSalle(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			    	
					if(salleDao.delete(id)) {
						request.setAttribute("NOTIFICATION", "Salle supprimé avec succès!");
					}
					getAllSalles(request, response);
			        //response.sendRedirect("list");

			    }

}
