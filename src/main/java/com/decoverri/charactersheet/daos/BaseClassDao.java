package com.decoverri.charactersheet.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.decoverri.charactersheet.models.BaseClass;

@Repository
public class BaseClassDao {

	@PersistenceContext
	private EntityManager manager;

	public void saveOrUpdateByName(BaseClass baseClass) {
		BaseClass loaded = findByName(baseClass.getName());
		if (loaded == null) {
			manager.persist(baseClass);
		} else {
			manager.merge(baseClass);
		}
	}

	public BaseClass findByName(String name) {
		List<BaseClass> result = manager.createQuery("select bc from BaseClass bc where name = :name")
				.setParameter("name", name).getResultList();
		if(result.isEmpty()){
			return null;
		}
		return result.get(0);
	}

	public List<BaseClass> list() {
		return manager.createQuery("select bc from BaseClass bc").getResultList();
	}

}
