package com.risk.war.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseDao<T extends Serializable> {

	protected EntityManager entityManager;
	
	private Class<T> entityType;
	
	@SuppressWarnings("unchecked")
	public BaseDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
	            .getGenericSuperclass();
	    this.entityType = (Class<T>) genericSuperclass
	            .getActualTypeArguments()[0];
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public T findElement(String id) {
		return entityManager.find(entityType, id);
	}
	
	@Transactional
	public void create(final T entity) {
		entityManager.persist(entity);
	}
	
	@Transactional
	public void update(final T entity) {
		entityManager.merge(entity);
	}
	
	@Transactional
	public void remove(String id) {
		entityManager.remove(findElement(id));
	}
	
	@Transactional
	public List<T> getAll() {
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(entityType);
		query.from(entityType);
		return entityManager.createQuery(query).getResultList();
		
	}

}
