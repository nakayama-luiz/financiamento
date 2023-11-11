package control;

import model.Receita;
import model.usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class receitaDAO {

    private static receitaDAO instance;

    protected EntityManager entityManager;

    public static receitaDAO getInstace(){
        if (instance == null){
            instance = new receitaDAO();
        }
        return instance;
    }

    private receitaDAO(){
        entityManager= getEntityManager();
    }
    private EntityManager getEntityManager(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("receita");
        if (entityManager==null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public void inserirReceita(Receita receita){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(receita);
            entityManager.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deletarReceita(Receita recepi){
        entityManager.getTransaction().begin();
        entityManager.remove(recepi);
        entityManager.getTransaction().commit();
    }

    public Receita procurarReceitaId(int id){
        return entityManager.find(Receita.class, id);
    }

    public void updateReceita(Receita ceita){
        entityManager.getTransaction().begin();
        entityManager.merge(ceita);
        entityManager.getTransaction().commit();
    }



}
