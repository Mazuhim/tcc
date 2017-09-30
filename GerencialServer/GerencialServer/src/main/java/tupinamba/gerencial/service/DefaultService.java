package tupinamba.gerencial.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DefaultService {

	@PersistenceContext(unitName = "GerencialServerPU")
	public EntityManager entityManager;

	public EntityManagerFactory emf;

	public DefaultService() {
		this.emf = Persistence.createEntityManagerFactory("GerencialServerPU");
		this.entityManager = emf.createEntityManager();
	}
}
