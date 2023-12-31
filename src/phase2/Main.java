package phase2;


import phase1.models.Enseignant;
import java.sql.*;
import java.util.ArrayList;

public class Main{

    public static void createTableEn(Connection cx) throws SQLException {
        String req1 = "CREATE TABLE IF NOT EXISTS Enseignant (\n" +
                "idens INT AUTO_INCREMENT PRIMARY KEY, \n" +
                "nom VARCHAR(50) CHARACTER SET utf8 NULL, \n" +
                "prenom VARCHAR(50) CHARACTER SET utf8 NULL, \n" +
                "email VARCHAR(50) CHARACTER SET utf8 NULL, \n" +
                "grade VARCHAR(50) CHARACTER SET utf8 NULL , \n" +
                ");";

        try (Statement smt = cx.createStatement()) {
            smt.execute(req1);
            System.out.println("Un nouveau tableau 'enseignant' a été créé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteEnseignant(int id, Connection cx) throws SQLException {
        String query = "DELETE FROM Enseignant WHERE idens = ?";
        try (PreparedStatement ps = cx.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("l'enseignant est supprimer ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<Enseignant> selectEnseignat(Connection cx) throws SQLException {
        String sql = "SELECT * FROM Enseignant";
        ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
        Statement statement = cx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {

            Enseignant enseignant= new Enseignant(
                    result.getInt("idens"),
                    result.getString("nom"),
                    result.getString("prenom"),
                    result.getString("email"),
                    result.getString("grade")

            ) ;
            enseignants.add(enseignant);
        }

        return enseignants;
    }
    public static void insertEnseignant(Enseignant enseignant, Connection cx) throws SQLException {
        String query = "INSERT INTO Enseignant (nom,prenom,email,grade) values (?,?,?,?)";

        try (PreparedStatement ps = cx.prepareStatement(query)) {
            ps.setString(1, enseignant.getNom());
            ps.setString(2, enseignant.getPrenom());
            ps.setString(3, enseignant.getEmail());
            ps.setString(4, enseignant.getGrade());

            ps.executeUpdate();
        }
    }

    public static void updateEnseignant(Enseignant enseignant, Connection cx) throws SQLException {
        String query = "UPDATE Enseignant SET nom=?, prenom=?, email=?, grade=?WHERE idens=?";
        try (PreparedStatement ps = cx.prepareStatement(query)) {
            ps.setString(1, enseignant.getNom());
            ps.setString(2, enseignant.getPrenom());
            ps.setString(3, enseignant.getEmail());
            ps.setString(4, enseignant.getGrade());

            ps.setInt(5, enseignant.getId());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/dept";
        String user = "root";
        String pwd = "";
        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");
//create
              /*createTableEn(cx); */
//select
            ArrayList<Enseignant> enseignants = selectEnseignat(cx);

           for (Enseignant enseignant : enseignants) {
                System.out.println("Enseignant ID: " + enseignant.getId());
                System.out.println("Nom: " + enseignant.getNom());
                System.out.println("Prenom: " + enseignant.getPrenom());
                System.out.println("Email: " + enseignant.getEmail());
                System.out.println("Grade: " + enseignant.getGrade());
                System.out.println("---------------------------");
            }
            selectEnseignat(cx);
//insert

        /*   Enseignant ens1 = new Enseignant();
            ens1.setNom("John");
            ens1.setPrenom("Doe");
            ens1.setEmail("john.doe@example.com");
            ens1.setGrade("Professor");

            insertEnseignant(ens1, cx);

            System.out.println("Enseignant inserted successfully");*/

//modifier
           /* Enseignant ens2 = new Enseignant();
            ens2.setId(2);
            ens2.setNom("ahmad");
            ens2.setPrenom("bar");
            ens2.setEmail("mehdi@gmail.com");
            ens2.setGrade("Professional");
            updateEnseignant(ens2, cx);
             System.out.println("Enseignant updated successfully");
             */
//delete
           /* deleteEnseignant(2,cx);
            System.out.println("Enseignant deleted successfully");*/


        } catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }


    }
}