package fr.epsi.b32223g1.dal.testFournisseurJdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

public class TestInsert {

    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurJDBCDAO();

        try {
            dao.insert(new Fournisseur("Fournisseur Local"));
            dao.insert(new Fournisseur("L’Espace Création"));

            System.out.println("Insertion faite");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }

}

