package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import main.Doctor;
import main.User;
import util.HibernateHelper;

public class DaoDoctor {
	private Session session;
	private Transaction transaction;
	private Query query;
	
	public List select(){
		List<Doctor> lista = new ArrayList<>();
		
		
		try{
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			query = session.createQuery("from Doctor");
			if(query.list() != null)
				lista = query.list();
			session.close();
		}catch(HibernateException e){
			session.close();
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void insertUpdate(Doctor doctor){
		try{
			this.session = HibernateHelper.getSessao();
			transaction = session.beginTransaction();
			session.saveOrUpdate(doctor);
			transaction.commit();
			session.close();
			System.out.println("Salvo");
		}catch(HibernateException e){
			session.close();
			e.printStackTrace();
		}
	}

	public void delete(User user){
        try{
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
