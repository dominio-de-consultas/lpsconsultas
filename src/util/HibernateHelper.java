package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class HibernateHelper {
	private static SessionFactory sessionFactory;
    private static Configuration configuration;
    private static ServiceRegistry registry;
    // Estrutura static para garantir que a SessionFactory seja iniciada apenas uma vez
    
    static {
        try {
            configuration = new Configuration().configure("hibernate.cfg.xml");
             registry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
             sessionFactory = configuration.buildSessionFactory(registry);
            atualizarBD();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // Retorna a sess�o
    public static Session getSessao(){
        return sessionFactory.openSession();
    }
 
    // Atualiza o Schema do Banco de Dados
    private static void atualizarBD(){
        SchemaUpdate se = new SchemaUpdate(configuration);
        se.execute(true, true);
    }
    
    public void close(){
    	sessionFactory.close();
    }
    
    
	
	
}
