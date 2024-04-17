package misc;

import java.util.ArrayList;
import java.util.List;

public class GameRoom {
    private List<Integer> players;
    private int gameID;
    private int status;
    private int numRounds;

    public GameRoom(int gameID) {
        this.gameID = gameID;
        players = new ArrayList<>();
    }

    public GameRoom(int gameID, int status, int numRounds) {
        this.gameID = gameID;
        this.status = status;
        this.numRounds = numRounds;
    }

    public List<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Integer> players) {
        this.players = players;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumRounds() {
        return numRounds;
    }

    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }
}