package it.promimpresa.web.persistenza;
import java.util.List;

import it.promimpresa.web.persistenza.DAOException;
import it.promimpresa.web.modello.Persona;
public interface PersonaDAO {
	public void save(Persona persona) throws DAOException;
	public void update(Persona persona) throws DAOException;
	public void delete(int persona) throws DAOException;
	public Persona findById(int id) throws DAOException;
	public List<Persona> findAll() throws DAOException;
 	public Persona findByCF(String CF) throws DAOException;
	public List<Persona> findByNome(String nome) throws DAOException;
	public List<Persona> findByCognome(String cognome) throws DAOException;
	public long count() throws DAOException;
	public List<Persona> findByAnno(String annoNascita) throws DAOException;
}