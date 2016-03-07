package fr.teiki.linqboardgame;

/**
 * Created by antoine on 07/03/2016.
 */
public class Game {

    private Player[] players;
    private String word;

    public Game(int nb_players) {
        this.players = new Player[nb_players];
        this.word = Words.getAWord();

        for(int i=0; i< players.length; i++){
            players[i] = new Player("Joueur"+i,false);
        }
        int idx_firs_spy = (int)(Math.random()*players.length);
        int idx_second_spy = (int)(Math.random()*players.length);
        while (idx_firs_spy == idx_second_spy)
            idx_second_spy = (int)(Math.random()*players.length);

        players[idx_firs_spy].setSpy(true);
        players[idx_second_spy].setSpy(true);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
