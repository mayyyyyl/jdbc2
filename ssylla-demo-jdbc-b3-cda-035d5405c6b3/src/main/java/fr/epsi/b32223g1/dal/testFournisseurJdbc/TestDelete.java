package fr.epsi.b32223g1.dal.testFournisseurJdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

public class TestDelete {

    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurJDBCDAO();

        try {
            Fournisseur f = new Fournisseur(4, "Test");
            boolean supprime = dao.delete(f);
            if (supprime) {
                System.out.println("Suppression effectuée");
            } else {
                System.out.println("Le fournisseur n'a pas été trouvé.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

}
