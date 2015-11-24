package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Doctor;
import util.HibernateHelper;

/**
 * Essa classe cria uma conexão com o banco de dados para acessar a tabela doctor
 * que guarda os médicos.
 * @author Eliton
 * @see {@link Doctor}, {@link HibernateHelper} 
 */
public class DaoDoctor {
	/**
	 *  Atributo que guarda a sessão que acessa o banco de dados. 
	 *  @see {@link Session}
	 */
	private Session session;
	/**
	 * Atributo que realiza e contem as informações da transação com o banco de dados.
	 * @see {@link Transaction}
	 */
	private Transaction transaction;
	/**
	 * Atributo que contem a Query de consulta, inserção ou remoção no banco de dados.
	 * @see {@link Query}
	 */
	private Query query;

	/**
	 * Retorna uma lista de {@link Doctor} que estão guardadas no banco de dados.
	 * @return Uma lista de médicos que estão persistidas no banco de dados.
	 */
	public List<Doctor> select() {
		List<Doctor> lista = new ArrayList<>();

		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			query = session.createQuery("from Doctor");
			if (query.list() != null)
				lista = query.list();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}

		return lista;
	}

	/**
	 * Insere um {@link Doctor} no banco de dados. 
	 * @param doctor médico a ser guardado no banco de dados.
	 */
	public void insertUpdate(Doctor doctor) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.saveOrUpdate(doctor);
			transaction.commit();
			session.close();
			System.out.println("Salvo");
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

	/**
	 * Remove do banco de dados o médico, {@link Doctor} passado por parâmetros.
	 * @param doctor médico a ser removido do banco de dados.
	 */
	public void delete(Doctor doctor) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.delete(doctor);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

}
