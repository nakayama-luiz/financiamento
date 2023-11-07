package hibernate;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
    private static DAO instance;
    protected EntityManager entityManager;
    
    public static DAO getInstace(){
        if (instance == null){
            instance = new DAO();
        }        
        return instance;
    }
    
    private DAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = 
                Persistence.createEntityManagerFactory("empenho");
        if (entityManager==null){
            entityManager = factory.createEntityManager();
        }
        System.out.println("hahaha:"+entityManager);
        return entityManager;
    }
    
    public void inserirEmpenho(Empenho empenho){
        try{
           entityManager.getTransaction().begin();
           entityManager.persist(empenho);
           entityManager.getTransaction().commit();
           
        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void jackzinho(Empenho empenho){
        entityManager.getTransaction().begin();
        //System.out.println(""+empenho.getEntidade());
        entityManager.remove(empenho);
        entityManager.getTransaction().commit();

        //entityManager.merge(empenho);
    }
    public Empenho searchByIdFactoryPoggers(int id){
        return entityManager.find(Empenho.class, id);
    }
    public void gambiarra(Empenho empenho){
        entityManager.getTransaction().begin();
        //System.out.println(""+empenho.getEntidade());
        entityManager.merge(empenho);
        entityManager.getTransaction().commit();
    }
    
                                                                                
    
}
