package hibernate;

import javax.persistence.*;


@Entity
@Table(name= "empenho")
public class Empenho {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_empenho")
    private int Id;


    @Column(name = "nad")
    private int nad;

    @Column(name = "entidade")
    private String entidade;

    @Column(name = "exercicio")
    private int exercicio;


    public int getNad() {
        return nad;
    }

    public String getEntidade() {
        return entidade;
    }

    public int getExercicio() {
        return exercicio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNad(int nad) {
        this.nad = nad;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public void setExercicio(int exercicio) {
        this.exercicio = exercicio;
    }
}
