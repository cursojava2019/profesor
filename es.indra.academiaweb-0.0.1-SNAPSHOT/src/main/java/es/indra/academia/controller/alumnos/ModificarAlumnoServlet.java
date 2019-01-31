package es.indra.academia.controller.alumnos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

/**
 * Servlet implementation class ModificarAlumnoServlet
 */
@WebServlet("/admin/alumnos/modificar.html")
public class ModificarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AlumnoService alumnoService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarAlumnoServlet() {
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
		String id = request.getParameter("id");
		Long idLong = null;

		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e) {
			idLong = null;
		}
		if (idLong == null) {
			response.sendRedirect("./listado.html?mensaje=errorId");
		} else {
			Alumno alumno = this.alumnoService.find(idLong);
			if (alumno != null) {
				AlumnoForm form = new AlumnoForm(alumno);
				request.setAttribute("formulario", form);
				RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/modificar.jsp");
				dispacher.forward(request, response);
			} else {
				response.sendRedirect("./listado.html?mensaje=errorId");
			}

		}

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

		alumno.validar(errores);
		if (errores.size() > 0) {
			request.setAttribute("formulario", alumno);
			request.setAttribute("errores", errores);

			RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/alumnos/modificar.jsp");
			dispacher.forward(request, response);
		} else {

			this.alumnoService.update(alumno);

			response.sendRedirect("./listado.html?mensaje=correcto");
		}

	}

}
