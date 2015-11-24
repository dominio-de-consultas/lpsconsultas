package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateHelper;

/**
 * Essa classe cria uma conexão com o banco de dados para acessar a tabela user
 * que guarda os usuários do sistema. 
 * @author Eliton
 *
 */
public class DaoUser {
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
	 * Retorna uma lista de {@link User} que estão guardadas no banco de dados.
	 * @return Uma lista de usuário que estão persistidas no banco de dados.
	 */
	public List<User> select() {
		List<User> lista = null;

		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			query = session.createQuery("from User");
			if (query.list() != null)
				lista = query.list();
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}

		return lista;
	}


	/**
	 * Insere um {@link User} no banco de dados. 
	 * @param user usuário a ser guardado no banco de dados.
	 */
	public void insertUpdate(User user) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
			session.close();
			System.out.println("Salvo");
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

	/**
	 * Remove do banco de dados o usuário, {@link User} passado por parâmetros.
	 * @param user usuário a ser removido do banco de dados.
	 */
	public void delete(User user) {
		try {
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}

}
