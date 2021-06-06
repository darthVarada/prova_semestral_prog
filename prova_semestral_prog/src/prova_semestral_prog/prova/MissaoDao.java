package prova_semestral_prog.prova;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class MissaoDao {

	protected EntityManagerFactory factory;
	protected EntityManager entityManager;
	
	public MissaoDao() {
		factory = Persistence.createEntityManagerFactory("Prova_Semestral");
	}

	public Missao salvar(Missao entity) {
		entityManager = factory.createEntityManager();
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		entityManager.flush();
		t.commit();
		entityManager.close();
		return entity;
	}

	public Missao atualizar(Missao entity) {
		entityManager = factory.createEntityManager();
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entity);
		entityManager.flush();
		t.commit();
		entityManager.close();
		return entity;
	}

	public void remover(int id) {
		entityManager = factory.createEntityManager();
		Missao entity = entityManager.find(Missao.class, id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Missao mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
		entityManager.close();
	}

	public List<Missao> getList() {
		entityManager = factory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Missao> query = builder.createQuery(Missao.class);
		query.from(Missao.class);
		List<Missao> missao = entityManager.createQuery(query).getResultList();
		entityManager.close();
		return missao;
	}
	
}
