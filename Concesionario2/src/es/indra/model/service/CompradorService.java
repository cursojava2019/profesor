package es.indra.model.service;

import es.indra.model.dao.CompradorDao;
import es.indra.model.entities.Comprador;
import es.indra.model.support.Dao;
import es.indra.model.support.Service;

public class CompradorService extends Service<String, Comprador> {

	private CompradorDao dao = null;

	public CompradorService() {
		this.dao = new CompradorDao();
	}

	@Override
	protected Dao<String, Comprador> getDao() {
		if (this.dao == null) {
			this.dao = new CompradorDao();
		}
		return this.dao;
	}

}
