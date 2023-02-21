package fr.epsi.b32223g1.dal.testFournisseurJdbc;

import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

public class TestUpdate {

    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurJDBCDAO();

        try {
            int nbLignesModifiees = dao.update("Nouveau FDM SA 2", "Nouveau FDM SA 3");
            System.out.println("Nombre de lignes modifiées : " + nbLignesModifiees);

            System.out.println("Mise à jour réussie !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

}
