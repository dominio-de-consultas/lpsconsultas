package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class HibernateHelper {
	private static SessionFactory fabricaSessao;
    private static Configuration hibernateConfig;
    // Estrutura static para garantir que a SessionFactory seja iniciada apenas uma vez
    
    static {
        try {
            hibernateConfig = new Configuration().configure("resources\\hibernate.cfg.xml");
            fabricaSessao = hibernateConfig.buildSessionFactory();
            atualizarBD();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // Retorna a sessão
    public static Session getSessao(){
        return fabricaSessao.openSession();
    }
 
    // Atualiza o Schema do Banco de Dados
    private static void atualizarBD(){
        SchemaUpdate se = new SchemaUpdate(hibernateConfig);
        se.execute(true, true);
    }
    
    
	
	
}
