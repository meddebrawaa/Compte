public class Main extends ComteBancair{
    public Main(double solde) {
        super(solde);
    }

    public static void main(String[] args)  {
        ComteBancair compte = new ComteBancair(500);
        compte.virement(200);
        compte.affichage();
        try {
            compte.retire(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        compte.affichage();
        CreeCompt cb = new CreeCompt();
        cb.inscreption();
    }

}