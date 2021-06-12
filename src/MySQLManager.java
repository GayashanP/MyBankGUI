import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySQLManager {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "nothing";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "logging_base";
    private static final String[] DISTRICTS = {"Ampara", "Anuradhapura", "Badulla", "Batticaloa", "Colombo", "Galle", "Gampaha", "Hambantota", "Jaffna", "Kalutara", "Kandy", "Kegalle", "Kilinochchi", "Kurunegala", "Mannar", "Matale", "Matara", "Monaragala", "Mullaitivu", "Nuwaraeliya", "Polonnaruwa", "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"};
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String MANAGER_PASSWORD = "123";

    // lowerCased Strings
    private static HashMap<String, Integer> districtCount = new HashMap<>();

    private static int totalCustomers = 0;

    public static void closeConnections() {
        try {
            // close connection
            connection.close();
            // close statement
            statement.close();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void settingUpConnections() {

        try {
            // create connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        // create statement
        try {
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static void checkOrCreateDatabase() {
        try {
            // gets all databases
            resultSet = statement.executeQuery("show databases;");
            while (resultSet.next()) {
                // check whether DATABASE name exists
                if (resultSet.getString(1).equals(DATABASE_NAME)) {
                    // return when found
                    return;
                }
            }
            // if nit found create database
            statement.executeUpdate("create database " + DATABASE_NAME + ";");

            // create manager table
            String createManagersTable = "CREATE TABLE `" + DATABASE_NAME + "`.`managers` (\n" +
                    "  `id` INT NOT NULL,\n" +
                    "  `username` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `branch` VARCHAR(45) NOT NULL,\n" +
                    "  `customer_count` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));\n";
            statement.executeUpdate(createManagersTable);
            // fill with defaults managers' usernames and password
            fillManagerTable();

            // create customer table
            String createCustomersTable = "CREATE TABLE `" + DATABASE_NAME + "`.`customers` (\n" +
                    "  `id` INT NOT NULL,\n" +
                    "  `username` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `branch` VARCHAR(45) NOT NULL,\n" +
                    "  `balance` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`));\n";
            statement.executeUpdate(createCustomersTable);

            // create district databases
            for (String district : DISTRICTS) {
                String createDistrictDatabase = "create database " + district.toLowerCase() + ";";
                statement.executeUpdate(createDistrictDatabase);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void getDistrictCounts() {
        totalCustomers = 0;
        try {
            resultSet = statement.executeQuery("select * from " + DATABASE_NAME + ".managers;");
            while (resultSet.next()) {
                String district = resultSet.getString(4).toLowerCase();
                int count = resultSet.getInt(5);
                totalCustomers += count;
                districtCount.put(district, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static void fillManagerTable() {
        int count = 0;
        try {
            for (String district : DISTRICTS) {
                                                     //                                    id                 username                        password                            branch          customer_count
                String insert = "insert into " + DATABASE_NAME + ".managers values (" + (++count) + ",'" + district.toLowerCase() + "','" + MANAGER_PASSWORD + "','" + district.toLowerCase() + "',0);";
                statement.executeUpdate(insert);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] loginCheck(String username, String password, boolean withCredential, boolean sureCustomer) {
        try {
            String checkUsers = "select * from " + DATABASE_NAME + ".customers;";
            resultSet = statement.executeQuery(checkUsers);

            while (resultSet.next()) {
                String usernameDB = resultSet.getString(2);
                String passwordDB = resultSet.getString(3);
                String branch = resultSet.getString(4);
                double tempBalance = resultSet.getDouble(5);
                if (username.equals(usernameDB)) {
                    if (withCredential) {
                        if (password.equals(passwordDB)) {
                            return new String[]{"USER", branch, String.valueOf(tempBalance)};
                        } else {
                            return new String[]{"INCORRECT"};
                        }
                    }
                    return new String[]{"FOUND"};
                }
            }

            if (sureCustomer) {
                return null;
            }

            String checkManagers = "select * from " + DATABASE_NAME + ".managers";
            resultSet = statement.executeQuery(checkManagers);
            while (resultSet.next()) {
                String usernameDB = resultSet.getString(2);
                String passwordDB = resultSet.getString(3);
                String branch = resultSet.getString(4);
                int customerCount = resultSet.getInt(5);
                if (username.equals(usernameDB)) {
                    if (password.equals(passwordDB)) {
                        return new String[]{"MANAGER", branch, String.valueOf(customerCount)};
                    } else {
                        return new String[]{"INCORRECT"};
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(String username, String password, String branch) {
        String[] results = loginCheck(username, password, false, true);
        branch = branch.toLowerCase();
        if (results != null) {
            if (results[0].equals("FOUND")) {
                System.out.println("USERNAME IS ALREADY EXISTS!");
            }
            return;
        }

        try {
            // add new user's username and password to logging table
            String insertToCustomerLog = "insert into " + DATABASE_NAME + ".customers values (" + (++totalCustomers) + ",'" + username + "','" + password + "','" + branch + "',0.0);";
            statement.executeUpdate(insertToCustomerLog);

            // update the current customer_count of own branch manager's row
            statement.executeUpdate("update " + DATABASE_NAME + ".managers set customer_count = " + (districtCount.get(branch) + 1) + " where branch = '" + branch + "';");

            // update the district count hashmap
            districtCount.put(branch, districtCount.get(branch) + 1);

            // add the new user's transaction table to own branch database
            String addTableToBranch = "CREATE TABLE `" + branch.toLowerCase() + "`.`" + username + "` (\n" +
                    "  `amount` DOUBLE NOT NULL,\n" +
                    "  `description` VARCHAR(45) NOT NULL);\n";
            statement.executeUpdate(addTableToBranch);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static double getBranchWorth(String branch) {
        List<String> customersInBranch = new ArrayList<>();
        String searchCustomersInLogBook = "select * from " + DATABASE_NAME + ".customers;";
        double totalWorth = 0;
        try {
            resultSet = statement.executeQuery(searchCustomersInLogBook);
            while (resultSet.next()) {
                if (resultSet.getString(4).toLowerCase().equals(branch.toLowerCase())) {
                    customersInBranch.add(resultSet.getString(2));
                }
            }
            for (String username : customersInBranch) {
                String selectCustomerInBranch = "select * from " + branch + "." + username + ";";
                resultSet = statement.executeQuery(selectCustomerInBranch);
                while (resultSet.next()) {
                    totalWorth += resultSet.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalWorth;
    }

    public static double updateCustomerBalance(String username, String branchName){
        double tempBalance = 0;
        String getBalance = "select * from " + branchName + "." + username + ";";
        try {
            resultSet = statement.executeQuery(getBalance);
            while (resultSet.next()) {
                tempBalance += resultSet.getDouble(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tempBalance;
    }

    public static void changePassword(String username, String password, boolean isCustomer) {
        String type = (isCustomer) ? "customers" : "managers";
        String searcher = "select * from " + DATABASE_NAME + "." + type + " where username = '" + username + "';";
        try {
            resultSet = statement.executeQuery(searcher);
            int id = resultSet.getInt(1);
            String changer = "update " + DATABASE_NAME + "." + type + " set password = '" + password + "' where id = " + id + ";";
            statement.executeUpdate(changer);
            JOptionPane.showMessageDialog(null, "Successfully changed your password!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeCustomer(String branch, String username) {
        String[] result = loginCheck(username, "", false, true);
        if (result == null) {
            JOptionPane.showMessageDialog(null, "Cannot find the customer!");
            return;
        }
        String deleterFromLog = "delete from " + DATABASE_NAME + ".customers where username = '" + username + "';";
        String deleterTable = "drop table " + branch + "." + username + ";";
        String branchCountDecrease = "update " + DATABASE_NAME + ".managers" + "set customer_count = " + (districtCount.get(branch.toLowerCase()) - 1) + " where branch = '" + branch + "';";

        districtCount.put(branch, districtCount.get(branch) - 1);
        try {
            statement.executeUpdate(deleterFromLog);
            statement.executeUpdate(deleterTable);
            statement.executeUpdate(branchCountDecrease);
            totalCustomers -= 1;
            JOptionPane.showMessageDialog(null, "Successfully removed "+ username + " from " + branch + " branch!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deposit(String username, String branch, double amount, String description) {
        String depositStatement = "insert into " + branch + "." + username + " values (" + amount + ",'" + description + "');";
        try {
            statement.executeUpdate(depositStatement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void withdraw(String username, String branch, double amount, String description) {
        String withdrawStatement = "insert into " + branch + "." + username + " values (" + (-amount) + ",'" + description + "');";
        try {
            statement.executeUpdate(withdrawStatement);
            JOptionPane.showMessageDialog(null, "Successfully withdraw amount!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void transfer(String from, String branch, String to, double amount) {
        String[] result = loginCheck(to, "", false, true);
        if (result == null) {
            JOptionPane.showMessageDialog(null, "Cannpt find the receiver!");
            return;
        }
        String receiverBranchFinder = "select * from " + DATABASE_NAME + ".customers where username = " + to + ";";
        try {
            resultSet = statement.executeQuery(receiverBranchFinder);
            String receiverBranch = resultSet.getNString(4);

            // subtract from sender
            withdraw(from, branch, amount, "transfer");

            // add to receiver
            deposit(to, receiverBranch, amount, "transfer");

            JOptionPane.showMessageDialog(null, "Successfully transferred amount");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initial(){
        settingUpConnections();
        checkOrCreateDatabase();
        getDistrictCounts();
    }
    private static void dropDatabase(){
        try {
            statement.executeUpdate("drop database " + DATABASE_NAME + ";");
        }catch (Exception e){
            e.printStackTrace();
        }
        for(String s : DISTRICTS){
            try {
                statement.executeUpdate("drop database " + s + ";");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void removeAll(){
        settingUpConnections();
        dropDatabase();
    }
}

// TODO - check again SQL syntax where quotation marks used in such like username = 'something'