package fr.epsi.b32223g1.dal.testFournisseurJdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

import java.sql.SQLException;

public class TestFindById {

    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurJDBCDAO();

        try {
            Fournisseur f = dao.findById(2);
            System.out.println(f.toString());
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
