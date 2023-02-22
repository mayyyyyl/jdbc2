package fr.epsi.b32223g1.test.jdbc;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

public class TestInsert {

    public static void main(String[] args) {

        ArticleDAO dao= new ArticleJDBCDAO();
        try {
            FournisseurDAO fournisseurDAO = new FournisseurJDBCDAO();
            Fournisseur fournisseur = fournisseurDAO.findById(4);
            dao.insert(new Article(80,"REF01", "Article 1", 10.0, fournisseur));

            System.out.println("Insertion faite");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }
}