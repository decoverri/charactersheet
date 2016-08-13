package com.decoverri.charactersheet.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.decoverri.charactersheet.models.Race;

@Repository
public class RaceDao {

	@PersistenceContext
	private EntityManager manager;

	public void saveOrUpdateByName(Race race) {
		Race loaded = findByName(race.getName());
		if (loaded == null) {
			manager.persist(race);
		} else {
			manager.merge(race);
		}
	}

	public Race findByName(String name) {
		List<Race> result = manager.createQuery("select r from Race r where name = :name")
				.setParameter("name", name).getResultList();
		if(result.isEmpty()){
			return null;
		}
		return result.get(0);
	}

	public List<Race> list() {
		return manager.createQuery("select r from Race r").getResultList();
	}

}