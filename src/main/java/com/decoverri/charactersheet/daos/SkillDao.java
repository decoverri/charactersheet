package com.decoverri.charactersheet.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.decoverri.charactersheet.models.Skill;

@Repository
public class SkillDao {


	@PersistenceContext
	private EntityManager manager;

	public void saveNew(Skill skill) {
		Skill loaded = findByName(skill.getName());
		if (loaded == null) {
			manager.persist(skill);
		}
	}
	
	public Skill findByName(String name) {
		List<Skill> result = manager.createQuery("select s from Skill s where name = :name")
				.setParameter("name", name).getResultList();
		if(result.isEmpty()){
			return null;
		}
		return result.get(0);
	}

	public List<Skill> list() {
		return manager.createQuery("select s from Skill s order by s.name").getResultList();
	}

	
}
