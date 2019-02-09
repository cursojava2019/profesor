package es.indra.academia.controller.alumnos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.indra.academia.model.entities.Alumno;
import es.indra.academia.model.service.AlumnoService;

@Controller
@RequestMapping("/services/alumnos")
public class AlumnoRestController {
	@Autowired
	private AlumnoService alumnoService;

	@RequestMapping(value = "/listado}", method = RequestMethod.GET)
	public @ResponseBody List<Alumno> listar(ModelMap model) {
		return this.alumnoService.findAll();
	}

}
