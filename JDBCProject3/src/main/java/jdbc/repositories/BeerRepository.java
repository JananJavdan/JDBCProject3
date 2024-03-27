package jdbc.repositories;

import jdbc.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerRepository {
    public void create(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb",
                    "Janan",
                    "2024"
            );
            System.out.println("Connection is made with brewer table");
            Statement statement = connection.createStatement();
            String query="insert into beers values (1558, tweedeBrewery,99,14,3.5,100,15,1,NULL)";
            statement.execute(query);
            System.out.println("new rom added to brewers table");

        }catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
    public List<Category> read(){
        List<Category> result = new ArrayList<>();
        try {
            Connection connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb",
                    "Janan",
                    "2024"
            );
            System.out.println("Connection with made with beers table");
            Statement statement = connection.createStatement();
            String query ="select * from beers";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Id|Name|Address|Zipcode|City|Turnover");
            while (resultSet.next()){
                System.out.println(resultSet.getRow() + " | "+
                        resultSet.getInt("id") + " | "+
                        resultSet.getString("name") + " | " +
                        resultSet.getInt("brewerId") + " | "+
                        resultSet.getInt("categoryId") + " | " +
                        resultSet.getFloat("price") + " | " +
                        resultSet.getFloat("alcohol") + " | " +
                        resultSet.getInt("version") + "| "+
                        resultSet.getBlob("image"));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return result;
    }
    public void update(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb",
                    "Janan",
                    "2024"
            );
            System.out.println("Connection with made with brewer table");
            Statement statement = connection.createStatement();
            String query = "update beers set Name ='derdebrewery'where id = 1558";
            statement.execute(query);
            System.out.println("beers table update");
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void delete(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb",
                    "Janan",
                    "2024"
            );
            System.out.println("Connection with made with brewer table");
            Statement statement = connection.createStatement();
            String query = "delete from brewers where id= 1558";
            statement.execute(query);
            System.out.println("content from beers table deleted");
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
}
