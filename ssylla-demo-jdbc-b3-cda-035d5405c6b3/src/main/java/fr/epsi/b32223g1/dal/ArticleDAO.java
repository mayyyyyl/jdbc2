package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDAO {

    List<Article> extraire() throws Exception;

    void insert( Article article ) throws SQLException;

    int update(Article article) throws SQLException;

    boolean delete(Article article) throws SQLException;
}