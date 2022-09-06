package college.ing2.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import college.ing2.daos.AffectationNoteDao;
import college.ing2.daos.EtudiantDao;
import college.ing2.daos.MatiereDao;
import college.ing2.models.AffectationNote;
import college.ing2.models.Etudiant;
import college.ing2.models.Matiere;

/**
 * Servlet implementation class AffectationController
 */
@WebServlet("/note/*")
public class AffectationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	EtudiantDao etudiantDao=null;
	AffectationNoteDao affectationNoteDao=null;
	MatiereDao matiereDao=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffectationController() {
        super();
        etudiantDao = new EtudiantDao();
		affectationNoteDao = new AffectationNoteDao();
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
	            case "/detail-note":
	            	getAllNotes(request, response);
	                break;
                case "/add-note":
                    showAddNote(request, response);
                    break;
                /*case "/insert-note":
                    insertNote(request, response);
                    break;*/
                case "/delete-note":
                    deleteNote(request, response);
                    break;
                case "/edit-note":
                    showEditNote(request, response);
                    break;
                /*case "/update-note":
                    updateNote(request, response);
                    break;*/
                default:
                	getAllNotes(request, response);
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
			insertNote(request, response);
		}else {
			updateNote(request, response);
		}
	}
	
	private void getAllNotes(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException {
		int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
        List<AffectationNote> listNote = affectationNoteDao.getAllDetail(etudiantId);
        Etudiant etudiant = etudiantDao.findById(etudiantId);
		Float moyen=affectationNoteDao.moyenne(etudiantId);
		List<Matiere> listMatiere=affectationNoteDao.nonValide(etudiantId);
		request.setAttribute("listMatiere", listMatiere);
		request.setAttribute("moyen", moyen);
		request.setAttribute("etudiant", etudiant);
		request.setAttribute("listNote", listNote);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/noteList.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showAddNote(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/noteForm.jsp");
		        int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
		        List<Matiere> listMatieres = matiereDao.getAll();
				request.setAttribute("etudiantId", etudiantId);
				request.setAttribute("listMatieres", listMatieres);
		        dispatcher.forward(request, response);
		    }
	
	 private void showEditNote(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			    	int id = Integer.parseInt(request.getParameter("id"));
			    	int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
			    	request.setAttribute("etudiantId", etudiantId);
			    	
			    	AffectationNote affectationNote = affectationNoteDao.findById(id);
			    	
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/noteForm.jsp");
			        request.setAttribute("affectationNote", affectationNote);
			        
			        List<Matiere> listMatieres = matiereDao.getAll();
					request.setAttribute("listMatieres", listMatieres);
					
			        dispatcher.forward(request, response);

			    }
	 
	 private void insertNote(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			    	AffectationNote affectationNote = new AffectationNote();
			    	affectationNote.setNote(Integer.valueOf(request.getParameter("note")));
			    	int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
			    	
			    	
			    	Etudiant etudiant = new Etudiant();
			    	etudiant.setId(Integer.valueOf(request.getParameter("etudiantId")));
			    	affectationNote.setEtudiant(etudiant);
			    	
			    	Matiere matiere = new Matiere();
			    	matiere.setId(Integer.valueOf(request.getParameter("matiereId")));
			    	affectationNote.setMatiere(matiere);
					
					if(affectationNoteDao.save(affectationNote)) {
						request.setAttribute("NOTIFICATION", "Note etudiant enregistré avec succès!");
					}
					request.setAttribute("etudiantId",etudiantId);
					getAllNotes(request, response);
			        //response.sendRedirect("detail-ligne?commandeId="+commandeId);
					
			    }
	 
	 private void updateNote(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        AffectationNote affectationNote = new AffectationNote();
			    	affectationNote.setNote(Integer.valueOf(request.getParameter("note")));
			    	int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
			    	
			    	
			    	Etudiant etudiant = new Etudiant();
			    	etudiant.setId(Integer.valueOf(request.getParameter("etudiantId")));
			    	affectationNote.setEtudiant(etudiant);
			    	
			    	Matiere matiere = new Matiere();
			    	matiere.setId(Integer.valueOf(request.getParameter("matiereId")));
			    	affectationNote.setMatiere(matiere);

			    	affectationNote.setId(id);
					if(affectationNoteDao.update(affectationNote)) {
						request.setAttribute("NOTIFICATION", "Note etudiant modifié avec succès!");
					}
					request.setAttribute("etudiantId",etudiantId);
					getAllNotes(request, response);
					//response.sendRedirect("detail-ligne?commandeId="+commandeId);
					
			    }
	 
	 private void deleteNote(HttpServletRequest request, HttpServletResponse response)
			    throws IOException, ServletException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
			    	
					if(affectationNoteDao.delete(id)) {
						request.setAttribute("NOTIFICATION", "Note etudiant supprimé avec succès!");
					}
					request.setAttribute("etudiantId",etudiantId);
					getAllNotes(request, response);
					//response.sendRedirect("detail-ligne?commandeId="+commandeId);
					

			    }

}
