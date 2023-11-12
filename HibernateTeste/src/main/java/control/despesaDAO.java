package control;

import model.Despesa;
import model.usuario;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class despesaDAO {


    private static despesaDAO instance;

    protected EntityManager entityManager;


    public static despesaDAO getInstace(){
        if (instance == null){
            instance = new despesaDAO();
        }
        return instance;
    }

    private despesaDAO(){
        entityManager= getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("despesa");
        if (entityManager==null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public void inserirUsuario(Despesa despesa){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(despesa);
            entityManager.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deletarUsuario(Despesa des){
        entityManager.getTransaction().begin();
        entityManager.remove(des);
        entityManager.getTransaction().commit();
    }


    public Despesa encontraDespesaId(int id){
        return entityManager.find(Despesa.class, id);
    }

    public void updateDespesa(Despesa despresa){
        entityManager.getTransaction().begin();
        entityManager.merge(despresa);
        entityManager.getTransaction().commit();
    }


}
