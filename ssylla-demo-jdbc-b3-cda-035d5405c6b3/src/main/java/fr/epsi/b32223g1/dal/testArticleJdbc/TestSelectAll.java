package fr.epsi.b32223g1.dal.testArticleJdbc;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

import java.util.List;

public class TestSelectAll {
    public static void main(String[] args) {
        ArticleDAO dao = new ArticleJDBCDAO();

        try {
            List<Article> articles = dao.extraire();
            System.out.println("Liste des articles :");

            for (Article a : articles) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'extraction : " + e.getMessage());
        }
    }
}
