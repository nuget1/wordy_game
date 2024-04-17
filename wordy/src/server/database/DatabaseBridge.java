package server.database;

import misc.GameRoom;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The DatabaseBridge is a class meant to be used by the server in initiating a connection to the
 * MySQL database to be used for the Wordy backend. Everything that the server needs to
 * access in the database should be provided here using methods.
 */
public class DatabaseBridge {

    private static Connection connection;
    private static ArrayList<GameRoom> games = new ArrayList<>();
    //TODO: Implement the DatabaseBridge class.

    public DatabaseBridge() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/wordy", "root", "");
    }

    public String[] getUserData(String username) {
        String[] queryResult = null;
        String query = "SELECT * FROM player WHERE username = ?";
        try (PreparedStatement preparedStatement =
                connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.beforeFirst();
            if (resultSet.next()) {
                String player_id = resultSet.getString("player_id");
                String queriedUsername = resultSet.getString("username");
                String queriedPassword = resultSet.getString("password");
                String status = resultSet.getString("status");
                String num_wins = resultSet.getString("num_wins");
                String game_id = resultSet.getString("game_id");
                queryResult = new String[]{
                    player_id, queriedUsername, queriedPassword, status, num_wins, game_id
                };
            }

            System.out.println("QUERY SUCCESS");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("QUERY FAILED");
        }

        return queryResult;
    }


    public int getEquivalentPlayerStatus(String status) {

        String query = String.format("SELECT status_id FROM player_status WHERE LOWER(status) LIKE \"%s\"",
        status.toLowerCase());
        int statusCode = 0;
        try (Statement statement =
                     connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.beforeFirst();
            if (!resultSet.next()) throw new SQLException();
            else statusCode = resultSet.getInt("status_id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return statusCode;

    }

    public String[] getTopPlayers(int limit) {
        String query = String.format("SELECT username, num_wins FROM player ORDER BY num_wins DESC LIMIT %d", limit);

        try (Statement statement =
                     connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet result = statement.executeQuery(query);
            List<String> topPlayers = new ArrayList<>();

            while (result.next()) {
                String username = result.getString("username");
                int numWins = result.getInt("num_wins");
                topPlayers.add(String.format("%s - %d wins", username, numWins));
            }

            return topPlayers.toArray(new String[0]);

        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + query);
            e.printStackTrace();
            return new String[0];
        }
    }

    public String[] getLongestWords(int limit) {
        String query = String.format("SELECT word FROM longest_word ORDER BY LENGTH(word) DESC LIMIT %d", limit);

        try (Statement statement =
                     connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet result = statement.executeQuery(query);
            List<String> longestWords = new ArrayList<>();

            while (result.next()) {
                String word = result.getString("word");
                longestWords.add(word);
            }

            return longestWords.toArray(new String[0]);

        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + query);
            e.printStackTrace();
            return new String[0];
        }
    }
    public static ArrayList<GameRoom> getGames() {
        games.clear();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT game_id, game_status, num_rounds FROM Game");

            while (resultSet.next()) {
                int gameId = resultSet.getInt("game_id");
                int gameStatus = resultSet.getInt("game_status");
                int numRounds = resultSet.getInt("num_rounds");

                GameRoom gameRoom = new GameRoom(gameId, gameStatus, numRounds);
                games.add(gameRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    public static void insert(String table, String[] tuples, String[] values) throws SQLException {
        String tuple = "";
        String value = "";

        for (String col : tuples) {
            tuple += col + ", ";
        }
        for (int x = 0; x < tuples.length; x++) {
            value += "?, ";
        }
        tuple = tuple.substring(0, tuple.length() - 2);
        value = value.substring(0, value.length() - 2);

        String query = "INSERT INTO " + table + " (" + tuple + ") VALUES (" + value + ");";

        PreparedStatement prep = connection.prepareStatement(query);

        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                prep.setNull(i + 1, java.sql.Types.NULL);
            } else {
                prep.setObject(i + 1, values[i]);
            }
        }

        prep.executeUpdate();
        prep.close();
    }

    public static void update(String table, String[] tuples, String[] values, String whereArg) throws SQLException {
        String args = "";

        for (int x = 0; x < tuples.length; x++) {
            args += tuples[x] + " = ?, ";
        }
        args = args.substring(0, args.length() - 2);

        String query = "UPDATE " + table + " SET " + args + " WHERE " + whereArg + ";";

        PreparedStatement prep = connection.prepareStatement(query);

        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                prep.setNull(i + 1, java.sql.Types.NULL);
            } else {
                prep.setObject(i + 1, values[i]);
            }
        }

        prep.executeUpdate();
        prep.close();
    }
}
