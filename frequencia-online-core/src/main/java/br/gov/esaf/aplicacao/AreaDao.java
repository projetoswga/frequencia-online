package br.gov.esaf.aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.esaf.modelo.Area;

@Component
public class AreaDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Area area) {
		entityManager.persist(area);
	}

	@SuppressWarnings("unchecked")
	public List<Area> list() {
		return entityManager.createQuery("select a from Area a")
				.getResultList();
	}

}
