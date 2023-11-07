package hello;

public class Exe {
    public static void main(String[] args) {
        Message msg = new Message();
        msg.setText("Nova msg");
        
        HibernateUtil hutil = new HibernateUtil();
        hutil.criarMessagem(msg);
        
    }
}
