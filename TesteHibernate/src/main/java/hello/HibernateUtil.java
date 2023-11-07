package hello;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration cfg = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            SessionFactory factory = cfg.buildSessionFactory(builder.build());
            return factory;
        } catch (Throwable ex){
            System.out.println("Erro: "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
    
    public void criarMessagem(Message message){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.save(message);
            transaction.commit();
        } catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally{
            session.close();
        }   
    }
    
    public Message lerMsg(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Message msg = (Message) session.get(Message.class, id);
        session.close();
        return msg;
    }
    
    public List<Message> listarMsgs(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Message> msgs = session.createQuery("from Message").list();
        session.close();
        return msgs;
    }
}
