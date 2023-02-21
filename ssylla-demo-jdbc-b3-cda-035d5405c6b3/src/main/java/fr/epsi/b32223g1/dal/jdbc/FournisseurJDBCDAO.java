package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurJDBCDAO implements FournisseurDAO {

	private static final String FIND_ALL_QUERY = "SELECT * FROM fournisseur";
	private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES (?)";
	private static final String UPDATE_QUERY = "UPDATE fournisseur SET NOM= ? WHERE NOM= ?";
	private static final String DELETE_QUERY = "DELETE FROM fournisseur WHERE ID=?";

	@Override
	public List<Fournisseur> extraire() throws SQLException {

		List<Fournisseur> list = new ArrayList<>();
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_QUERY);
			 ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("ID");
				String nom = rs.getString("NOM");
				Fournisseur fournisseur = new Fournisseur(id, nom);
				list.add(fournisseur);
			}
		}
		return list;
	}

	@Override
	public void insert( Fournisseur fournisseur) throws  SQLException {
		Connection connection = DBConnection.getSingle().getSqlConnection();

		try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)){
			ps.setString(1, fournisseur.getName());
			ps.executeUpdate();
		}
	}

	@Override
	public int update( String ancienNom, String nouveauNom ) throws SQLException {
		Connection connection = DBConnection.getSingle().getSqlConnection();

		try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
			ps.setString(1, nouveauNom);
			ps.setString(2, ancienNom);
			return ps.executeUpdate();
		}
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {
		Connection connection = DBConnection.getSingle().getSqlConnection();

		try (PreparedStatement ps = connection.prepareStatement(DELETE_QUERY)) {
			ps.setInt(1, fournisseur.getId());
			int rowsDeleted = ps.executeUpdate();
			return rowsDeleted > 0;
		}
	}
}
