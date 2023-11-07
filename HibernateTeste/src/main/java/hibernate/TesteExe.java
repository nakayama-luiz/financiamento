package hibernate;

public class TesteExe {
    public static void main(String[] args) {

        Empenho empenho = new Empenho();
        empenho.setEntidade("astorga");
        empenho.setExercicio(2012);
        empenho.setNad(78);
        //empenho.setId(2);
        //DAO.getInstace().inserirEmpenho(empenho);
        Empenho emp = new Empenho();

        //emp = DAO.getInstace().searchByIdFactoryPoggers(3);

        DAO.getInstace().gambiarra(empenho);
       // DAO.getInstace().inserirEmpenho(empenho);
        //DAO.getInstace().jackzinho(emp);
        //System.out.println(emp.getEntidade());

    }
}
