package es.indra.academia.controller.alumnos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

/**
 * Servlet implementation class ListarAlumnosServer
 */
@WebServlet("/admin/alumnos/listado.html")
public class ListarAlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(ListarAlumnosServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarAlumnosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log.info("Se recibe una petición para listar alumnos");
		AlumnoService alumnoService = AlumnoService.getInstance();

		List<Alumno> alumnos = alumnoService.findAll();
		request.setAttribute("listado", alumnos);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/listado.jsp");
		this.log.debug("Se obtienen todos los alumnos de BBDD y se mandan al jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		AlumnoService alumnoService = AlumnoService.getInstance();
		String patron = request.getParameter("patron");
		List<Alumno> alumnos = null;
		if (patron != null && !patron.equals("")) {
			alumnos = alumnoService.findAlumnosPatron(patron);
		} else {
			alumnos = alumnoService.findAll();
		}

		request.setAttribute("listado", alumnos);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/listado.jsp");
		dispacher.forward(request, response);
	}

}
