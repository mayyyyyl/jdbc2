package fr.epsi.b32223g1.dal.testArticleJdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

public class TestDeletePeinture {
    public static void main(String[] args) {
        ArticleDAO dao = new ArticleJDBCDAO();

        try {
            boolean supprime = dao.deletepeinture();
            if (supprime) {
                System.out.println("Suppression effectuée");
            } else {
                System.out.println("L'article n'a pas été trouvé.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
