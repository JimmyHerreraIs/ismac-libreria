package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	// HQL
	// findAll
	// SELECT au FROM Libro au
	// findOne
	// SELECT au FROM Libro au WHERE au.idLibro =: keyIdLibro
	// add
	// INSERT INTO (....) VALUES (.....)  ??? No es permitido en HQL
	// INSERT INTO (....) SELECT (.....)      Si es permitido en HQL
	// up
	
	// del
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT au FROM Libro au",Libro.class).getResultList();
	}

	@Override
	@Transactional
	public Libro findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT au FROM Libro au WHERE au.idLibro =: keyIdLibro");
		query.setParameter("keyIdLibro", id);
		return (Libro) query.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Libro Libro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(Libro);
	}

	@Override
	@Transactional
	public void up(Libro Libro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE Libro au SET au.nombre =: keyNombre"
										+ "                  , au.apellido =: keyApellido"
										+ "                  , au.pais =: keyPais"
										+ "                  , au.direccion =: keyDireccion"
										+ "                  , au.telefono =: keyTelefono"
										+ "				     , au.correo =: keyCorreo "
										+ "           WHERE  au.idLibro =: keyIdLibro");
		query.setParameter("keyNombre", Libro.getNombre());
		query.setParameter("keyApellido", Libro.getApellido());
		query.setParameter("keyPais", Libro.getPais());
		query.setParameter("keyDireccion", Libro.getDireccion());
		query.setParameter("keyTelefono", Libro.getTelefono());
		query.setParameter("keyCorreo", Libro.getCorreo());
		query.setParameter("keyIdLibro", Libro.getIdLibro());
		
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Libro au WHERE au.idLibro =: keyIdLibro");
		query.setParameter("keyIdLibro", id);		
		query.executeUpdate();
		
	}

}
