package control;

import hibernate.DAO;
import hibernate.Empenho;
import model.usuario;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class userDAO {
    private static userDAO instance;

    protected EntityManager entityManager;

    public static userDAO getInstace(){
        if (instance == null){
            instance = new userDAO();
        }
        return instance;
    }

    private userDAO(){
        entityManager= getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("usuario");
        if (entityManager==null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public void inserirUsuario(usuario usuario){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();

        } catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deletarUsuario(usuario user){
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public usuario procurarEmpenhoPeloId(int id){
        return entityManager.find(usuario.class, id);
    }

    public void atualizarUsuario(usuario usuario){
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }


}
