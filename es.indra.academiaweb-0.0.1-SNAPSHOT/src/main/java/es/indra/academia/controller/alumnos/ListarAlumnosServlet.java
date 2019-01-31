package es.indra.academia.controller.alumnos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

/**
 * Servlet implementation class ListarAlumnosServer
 */
@WebServlet("/admin/alumnos/listado.html")
public class ListarAlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger(ListarAlumnosServlet.class);
	AlumnoService alumnoService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarAlumnosServlet() {
		super();

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
		this.alumnoService = wac.getBean(AlumnoService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.log.info("Se recibe una petición para listar alumnos");

		List<Alumno> alumnos = this.alumnoService.findAll();
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

		String patron = request.getParameter("patron");
		List<Alumno> alumnos = null;
		if (patron != null && !patron.equals("")) {
			alumnos = this.alumnoService.findAlumnosPatron(patron);
		} else {
			alumnos = this.alumnoService.findAll();
		}

		request.setAttribute("listado", alumnos);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/listado.jsp");
		dispacher.forward(request, response);
	}

}
