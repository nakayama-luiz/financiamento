package hello;


import java.io.IOException;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Teste {
    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration().
                    addResource("Message.hbmg.xml");
            
            Properties p = System.getProperties();
            p.load(
                    ClassLoader.getSystemResourceAsStream("hibernate-properties")
            );
            cfg.setProperties(p); 
            
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            
            
        } catch (IOException ex) {
            System.out.println("Erro: "+ex);
        }
        
    }
    
    
    
    
    
}
