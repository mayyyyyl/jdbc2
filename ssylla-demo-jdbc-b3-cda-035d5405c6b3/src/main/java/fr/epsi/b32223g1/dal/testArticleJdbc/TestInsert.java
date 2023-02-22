package fr.epsi.b32223g1.dal.testArticleJdbc;

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
            dao.insert(new Article(11,"P01", "Peinture blanche 1L", 12.5, fournisseur));
            dao.insert(new Article(12,"PM01", "Peinture rouge mate 1L", 15.5,fournisseur));
            dao.insert(new Article(13,"PL01", "Peinture noire laquée 1L", 17.8, fournisseur));
            dao.insert(new Article(14,"PM01", "Peinture bleue mate 1L", 15.5, fournisseur));

            System.out.println("Insertion(s) faite(s)");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }
}