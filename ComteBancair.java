public class ComteBancair {
    public double solde;

    public ComteBancair(double solde) {
        this.solde = solde;
    }

    public void virement(double argent){
        this.solde+=argent;
    }

    public void retire (double argent) throws Exception{
        if (argent>this.solde )
            throw  new Exception("solde insiffisant");
        else
            this.solde-=argent;


    }


    public void affichage (){
        System.out.println( "Votre solde et " +this.solde);

        }






    }



