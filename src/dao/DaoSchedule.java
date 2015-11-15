package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.Schedule;
import util.HibernateHelper;

/**
 * Essa classe cria uma conexão com o banco de dados para acessar a tabela schedule
 * que guarda os cronogramas dos doutores.
 * @author Eliton
 * @see {@link Doctor}, {@link HibernateHelper}, {@link Schedule}
 *
 */
public class DaoSchedule {
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
	 * Retorna uma lista de {@link Schedule} que estão guardadas no banco de dados.
	 * @return Uma lista de cronograma que estão persistidas no banco de dados.
	 */
	public List<Schedule> select() {
		List<Schedule> lista = new ArrayList<>();

		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			query = session.createQuery("from Schedule");
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
	 * Insere um {@link Schedule} no banco de dados. 
	 * @param schedule cronograma a ser guardado no banco de dados.
	 */
	public void insertUpdate(Schedule schedule) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.saveOrUpdate(schedule);
			transaction.commit();
			session.close();
			System.out.println("Salvo");
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

	/**
	 * Remove do banco de dados o cronograma, {@link Schedule} passado por parâmetros.
	 * @param schedule cronograma a ser removido do banco de dados.
	 */
	public void delete(Schedule schedule) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.delete(schedule);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

}
