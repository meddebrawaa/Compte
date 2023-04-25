
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreeCompt implements ActionListener {
    private static JPasswordField textPW;
    private static JTextField textPrenom;
    private static JTextField textNom;
    private static JTextField textCin;
    private static JTextField textDateNai;
    public JFrame inscreption() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Creation compte bancaire ");
        frame.setSize(450, 500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(panel);

        panel.setLayout(null);

        JLabel cin = new JLabel("CIN");
        cin.setBounds(10, 50, 80, 30);
        panel.add(cin);

        textCin = new JTextField();
        textCin.setBounds(100,50,165,30);
        panel.add(textCin);

        JLabel nom = new JLabel("NOM");
        nom.setBounds(10,100,80,30);
        panel.add(nom);

        textNom = new JTextField();
        textNom.setBounds(100,100,165,30);
        panel.add(textNom);

         JLabel prenom = new JLabel("Prenom");
        prenom.setBounds(10,150,80,30);
        panel.add(prenom);

        textPrenom = new JTextField();
        textPrenom.setBounds(100,150,165,30);
        panel.add(textPrenom);

        JLabel dateNai = new JLabel("date Naissance");
        dateNai.setBounds(10,200,80,30);
        panel.add(dateNai);

        textDateNai = new JTextField();
        textDateNai.setBounds(100,200,165,30);
        panel.add(textDateNai);

        JLabel pw = new JLabel("Mot de passe");
        pw.setBounds(10,250,100,30);
        panel.add(pw);
        textPW = new JPasswordField();
        textPW.setBounds(100,250,165,30);
        panel.add(textPW);




        JButton s = new JButton("Enregistre");
        s.setBounds(50,300,110,40);
        s.addActionListener(new CreeCompt());
        panel.add(s);



       return frame;

    }

    public static JPasswordField getTextPW() {
        return textPW;
    }

    public static JTextField getTextPrenom() {
        return textPrenom;
    }

    public static JTextField getTextNom() {
        return textNom;
    }

    public static JTextField getTextCin() {
        return textCin;
    }

    public static JTextField getTextDateNai() {
        return textDateNai;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        PreparedStatement st=null;
        DBCompteBancaire cbd= new DBCompteBancaire();
        cbd.Connectionbd();

        try {

            String eng= " INSERT INTO comptecree (CIN,NOM,PRENOM,DATE-NAI,PASSE_WORD,DATE_CRATION) VALUES  (?,?,?,?,?,?)";
            java.util.Date date = new java.util.Date();
            st=cbd.con.prepareStatement(eng);
            st.setString(1,textCin.getText());
            st.setString(2,textNom.getText() );
            st.setString(3,textPrenom.getText());
            st.setString(4, textDateNai.getText().toString());
            st.setString(5, textPW.getText());
            st.setString(6, date.toString());

            st.executeUpdate();
            System.out.println("compt inscrit les "+ date);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }


        //enregistrement sur le base de donne

    }
}
