package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.Consultation;
import main.Schedule;
import util.HibernateHelper;

/**
 * Essa classe cria uma conexão com o banco de dados para acessar a tabela consultation
 * que guarda as consultas.
 * @author Eliton
 * @see {@link Consultation}, {@link HibernateHelper}, {@link Schedule}
 *
 */
public class DaoConsultation {
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
	 * Retorna uma lista de {@link Consultation} que estão guardadas no banco de dados.
	 * @return Uma lista de consultas que estão persistidas no banco de dados.
	 */
	public List<Consultation> select() {
		List<Consultation> lista = new ArrayList<>();

		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			query = session.createQuery("from Consultation");
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
	 * Insere um {@link Consultation} no banco de dados. 
	 * @param consultation Consulta a ser guardada no banco de dados.
	 */
	public void insertUpdate(Consultation consultation) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.saveOrUpdate(consultation);
			transaction.commit();
			session.close();
			System.out.println("Salvo");
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

	/**
	 * Remove do banco de dados a consulta, {@link Consultation} passada por parâmetros.
	 * @param consultation consulta a ser removida do banco de dados.
	 */
	public void delete(Consultation consultation) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.delete(consultation);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

}
