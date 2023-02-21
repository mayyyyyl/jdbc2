package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;

import java.sql.*;

public class ArticleJDBCDAO implements ArticleDAO {

//    private static final String FIND_ALL_QUERY = "SELECT * FROM article";
    private static final String INSERT_QUERY = "INSERT INTO article (ref, designation, prix, fournisseur_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE article SET ref = ?, designation = ?, prix = ?, fournisseur_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM article WHERE id = ?";

//    @Override
//    public List<Article> extraire() throws SQLException {
//        List<Article> list = new ArrayList<>();
//        Connection connection = DBConnection.getSingle().getSqlConnection();
//
//        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_QUERY);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String ref = rs.getString("ref");
//                String designation = rs.getString("designation");
//                double prix = rs.getDouble("prix");
//                int fournisseurId = rs.getInt("fournisseur_id");
//                FournisseurDAO fournisseurDAO = new FournisseurJDBCDAO();
//                Fournisseur fournisseur = fournisseurDAO.findById(fournisseur);
//                Article article = new Article(id, ref, designation, prix, fournisseur);
//                list.add(article);
//            }
//        }
//
//        return list;
//    }

    @Override
    public void insert(Article article) throws SQLException {
        Connection connection = DBConnection.getSingle().getSqlConnection();

        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
            ps.setString(1, article.getRef());
            ps.setString(2, article.getDesignation());
            ps.setDouble(3, article.getPrix());
            ps.setInt(4, article.getFournisseur().getId());
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
