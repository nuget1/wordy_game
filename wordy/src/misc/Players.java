package misc;

public class Players {

    private int player_id;
    private String username;
    private String password;
    private String status;
    private int num_wins;
    private int game_id;

    // Constructor
    public Players(int player_id, String username, String password, String status, int num_wins, int game_id) {
        this.player_id = player_id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.num_wins = num_wins;
        this.game_id = game_id;
    }

    // Getter and setter for player_id
    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and setter for num_wins
    public int getNum_wins() {
        return num_wins;
    }

    public void setNum_wins(int num_wins) {
        this.num_wins = num_wins;
    }

    // Getter and setter for game_id
    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
}