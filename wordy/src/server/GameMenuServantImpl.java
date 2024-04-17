package server;

import misc.GameRoom;
import server.database.DatabaseBridge;
import wordy_idl.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is the implementation of the object to be used for the client
 * for initiating operations in the main menu such as: logging in,
 * starting a new game, joining a game, getting the list of the best players,
 * or getting the list of the longest words.
 */
public class GameMenuServantImpl extends GameMenuServantPOA {

    //TODO: Implement the methods in the Game menu servant.
    static DatabaseBridge databasebridge;
    static int player_id, gID = -1;

    static ArrayList<GameRoom> games;

    GameRoom room;


    static {
        try {
            System.out.println("Initiating database connection...");
            databasebridge = new DatabaseBridge();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not connect to the database. Did you forget to set it up first?");
        }
    }


    @Override
    public int logIn(String username, String password)
            throws InvalidPasswordException, NoUserFoundException, LoggedInException {
        System.out.printf("Responding to login query for user: %s\n", username);
        String[] queryResult = databasebridge.getUserData(username);

        // Check if a result has been found for a given username.
        if (queryResult == null) throw new NoUserFoundException();
        else {
            player_id = Integer.parseInt(queryResult[0]);
            String queriedPassword = queryResult[2];
            int userStatus = Integer.parseInt(queryResult[3]);

            // Check if the passwords are different
            if (!queriedPassword.equals(password)) throw new InvalidPasswordException();

                // Check if the user is already online.
            else if (userStatus == databasebridge.getEquivalentPlayerStatus("online")) throw new LoggedInException();

                // If everything is in order, return the player's id within the database.
            else return player_id;
        }
    }

    @Override
    public void startGame() throws NoPlayersJoinedException {
        boolean create = true;

        System.out.println("Getting Table...");
        games = DatabaseBridge.getGames();
        System.out.println("Table retrieved");


        if (games.isEmpty()) {
            System.out.println("Creating Game Data...");
            create();
        }
        for (GameRoom curr : games) {
            int status = curr.getStatus();
            if (status == 1) {
                gID = curr.getGameID();
                System.out.println("data");
                create = false;
            }
        }
        if(create){
            create();
        }
    }

    public void create(){
        try {
        DatabaseBridge.insert("game", new String[]{"game_status", "num_rounds"},
                new String[]{"1", null});
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        games = DatabaseBridge.getGames();
        gID = games.get(games.size() - 1).getGameID();
        room = new GameRoom(gID);
    }

    @Override
    public String[] getBestPlayers() {
        return databasebridge.getTopPlayers(10);
    }

    @Override
    public String[] getLongestWords() {
        return databasebridge.getLongestWords(10);
    }

    @Override
    public void logOut(String username) {

    }
    @Override
    public int updateCountdown(int value) {
        System.out.println("Countdown updated to: " + value);
        return value;
    }

    @Override
    public int inQueue() {
        Timer timer = new Timer();
        final int[] countdown = {10};

        if (gID != -1) {
            // Add player to game room if it exists
            List<Integer> players = room.getPlayers();

            if (players.size() == 0) {
                // Create new game room for the first player to join
                players.add(player_id);
                System.out.println("In queue...");
                System.out.println(players.size());

                // Start timer for the first player to join
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        updateCountdown(countdown[0]); // callback method
                        countdown[0] = countdown[0] - 1;

                        if (countdown[0] == 0) {
                            cancel();
                            System.out.println("Timer Ended");

                            if (players.size() == 1) {
                                System.out.println("No other player joined the game.");
                            } else {
                                // Update tables
                                int[] playersArray = players.stream().mapToInt(Integer::intValue).toArray();
                                playersUpdated(playersArray);

                                System.out.println("Game Starting...");
                            }
                        }
                    }
                }, 0, 1000);
            } else {
                // Add player to existing game room
                players.add(player_id);
                System.out.println("In queue...");
                System.out.println(players.size());
            }
        }

        return countdown[0];
    }

    @Override
    public void playersUpdated(int[] players) {
        int finalGID = gID;
        try {
            for (int current : players) {
                DatabaseBridge.update("player", new String[]{"game_id"},
                        new String[]{String.valueOf(finalGID)}, "player_id = " + current);
            }

            DatabaseBridge.update("game", new String[]{"game_status"},
                    new String[]{"2"}, "game_id = " + finalGID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void gameStarted() {

    }

}
