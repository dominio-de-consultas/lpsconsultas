package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.Patient;
import util.HibernateHelper;

/**
 * Essa classe cria uma conexão com o banco de dados para acessar a tabela patient
 * que guarda os pacientes. 
 * @author Eliton
 *
 */
public class DaoPatient {
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
	 * Atributo que contem a Query de consulta, inserção ou remoção no bancon de dados.
	 * @see {@link Query}
	 */
	private Query query;

	/**
	 * Retorna uma lista de {@link Patient} que estão guardadas no banco de dados.
	 * @return Uma lista de pacientes que estão persistidas no banco de dados.
	 */
	public List<Patient> select() {
		List<Patient> lista = new ArrayList<>();

		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			query = session.createQuery("from Patient");
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
	 * Insere um {@link Patient} no banco de dados. 
	 * @param patient paciente a ser guardado no banco de dados.
	 */
	public void insertUpdate(Patient patient) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.saveOrUpdate(patient);
			transaction.commit();
			session.close();
			System.out.println("Salvo");
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

	/**
	 * Remove do banco de dados o paciente, {@link Patient} passado por parâmetros.
	 * @param patient paciente a ser removido do banco de dados.
	 */
	public void delete(Patient patient) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.delete(patient);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

}
