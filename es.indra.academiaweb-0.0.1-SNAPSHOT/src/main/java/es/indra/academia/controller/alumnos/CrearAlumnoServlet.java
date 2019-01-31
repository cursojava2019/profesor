package es.indra.academia.controller.alumnos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.indra.academia.model.service.AlumnoService;

/**
 * Servlet implementation class CrearAlumnoServlet
 */
@WebServlet("/admin/alumnos/nuevo.html")
public class CrearAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AlumnoService alumnoService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearAlumnoServlet() {
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

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/nuevo.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errores = new ArrayList<String>();

		AlumnoForm alumno = AlumnoForm.obtenerAlumnoForm(request);

		alumno.setFechaAlta(new Date());
		alumno.validar(errores);
		if (errores.size() > 0) {
			request.setAttribute("formulario", alumno);
			request.setAttribute("errores", errores);

			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/nuevo.jsp");
			dispacher.forward(request, response);
		} else {

			this.alumnoService.create(alumno);

			response.sendRedirect("./listado.html?mensaje=correcto");
		}
	}

}
