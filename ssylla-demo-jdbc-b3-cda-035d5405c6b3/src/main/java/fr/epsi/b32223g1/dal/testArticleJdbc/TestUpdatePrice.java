package fr.epsi.b32223g1.dal.testArticleJdbc;

import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;

public class TestUpdatePrice {
    public static void main(String[] args) {
        ArticleDAO dao = new ArticleJDBCDAO();

        try {
            int nbLignesModifiees = dao.updateprice();
            System.out.println("Nombre de lignes modifiées : " + nbLignesModifiees);

            System.out.println("Mise à jour réussie");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }
}
