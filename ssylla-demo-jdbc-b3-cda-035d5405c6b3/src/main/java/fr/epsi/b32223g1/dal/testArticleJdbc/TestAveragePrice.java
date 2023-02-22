package fr.epsi.b32223g1.dal.testArticleJdbc;

import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;


public class TestAveragePrice {

    public static void main(String[] args) {
        ArticleDAO dao = new ArticleJDBCDAO();

        try {
            Double averageprice = dao.avgprice();

            System.out.println("Moyenne des prix des articles : " + averageprice + " €");

        } catch (Exception e) {
            System.err.println("Erreur lors de l'extraction : " + e.getMessage());
        }
    }
}
