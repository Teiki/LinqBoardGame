package fr.teiki.linqboardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int nb_players;
    private Game game;

    private TextView txt_word;
    private TextView lbl_word;
    private TextView txt_player_role;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_word = (TextView) findViewById(R.id.txt_word);
        lbl_word = (TextView) findViewById(R.id.lbl_word);
        txt_player_role = (TextView) findViewById(R.id.txt_player_role);
        next = (Button) findViewById(R.id.next);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        if (getIntent() != null && getIntent().hasExtra(PlayersNumberActivity.TAG_NB_PLAYERS))
            nb_players = getIntent().getIntExtra(PlayersNumberActivity.TAG_NB_PLAYERS,0);
        else
            finish();

        if (nb_players > 0){
            game = new Game(nb_players);
            dispatchRole(0);
        }

    }

    private void dispatchRole(final int idx) {
        Player player = game.getPlayers()[idx];
        txt_player_role.setText(player.toString());
        if (player.isASpy()) {
            txt_word.setText(game.getWord());
        }
        lbl_word.setVisibility(player.isASpy()?View.VISIBLE:View.GONE);
        next.setText("J'ai retenu mon rôle!");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeRole(idx+1);
            }
        });
    }

    private void removeRole(final int idx) {
        if (idx < game.getPlayers().length) {
            next.setText("Je suis le joueur "+(idx+1));
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchRole(idx);
                }
            });
        } else {
            next.setText("Partie finie");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PlayersNumberActivity.class);
                    startActivity(intent);
                }
            });
        }
        txt_player_role.setText("");
        txt_word.setText("");
        lbl_word.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
