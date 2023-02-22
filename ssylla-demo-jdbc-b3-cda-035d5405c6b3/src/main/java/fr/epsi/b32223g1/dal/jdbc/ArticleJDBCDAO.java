package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleJDBCDAO implements ArticleDAO {

    private static final String FIND_ALL_QUERY = "SELECT * FROM article";
    private static final String INSERT_QUERY = "INSERT INTO article (id, ref, designation, prix, id_fou) VALUES (?,?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE article SET ref = ?, designation = ?, prix = ?, id_fou = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM article WHERE id = ?";


    @Override
    public List<Article> extraire() throws SQLException {
        List<Article> list = new ArrayList<>();
        Connection connection = DBConnection.getSingle().getSqlConnection();

        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_QUERY);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String ref = rs.getString("ref");
                String designation = rs.getString("designation");
                double prix = rs.getDouble("prix");
                int id_fou = rs.getInt("fournisseur_id");
                FournisseurDAO fournisseurDAO = new FournisseurJDBCDAO();
                Fournisseur fournisseur = fournisseurDAO.findById(id_fou);
                Article article = new Article(id, ref, designation, prix, fournisseur);
                list.add(article);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void insert(Article article) throws SQLException {
        Connection connection = DBConnection.getSingle().getSqlConnection();

        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, article.getId());
            ps.setString(2, article.getRef());
            ps.setString(3, article.getDesignation());
            ps.setDouble(4, article.getPrix());
            ps.setInt(5, article.getFournisseur().getId());
            ps.executeUpdate();
        }
    }

    @Override
    public int update(Article article) throws SQLException {
        Connection connection = DBConnection.getSingle().getSqlConnection();

        try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, article.getRef());
            ps.setString(2, article.getDesignation());
            ps.setDouble(3, article.getPrix());
            ps.setInt(4, article.getFournisseur().getId());
            ps.setInt(5, article.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public boolean delete(Article article) throws SQLException {
        Connection connection = DBConnection.getSingle().getSqlConnection();

        try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, article.getId());
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}
