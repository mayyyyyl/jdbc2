package fr.epsi.b32223g1.dal.testFournisseurJdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurJDBCDAO();

        try {
            List<Fournisseur> fournisseurs = dao.extraire();
            System.out.println("Liste des fournisseurs :");

            for (Fournisseur f : fournisseurs) {
                System.out.println(f);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'extraction : " + e.getMessage());
        }
    }

}
