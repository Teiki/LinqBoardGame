package fr.teiki.linqboardgame;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayersNumberActivity extends AppCompatActivity {

    private Button save;
    private EditText nb_players;

    public static final String TAG_NB_PLAYERS = "TAG_NB_PLAYERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_number);

        nb_players = (EditText) findViewById(R.id.nb_players);
        save = (Button) findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nb_players.getText().toString().isEmpty() || Integer.valueOf(nb_players.getText().toString()) < 3){
                    Snackbar.make(save, "Lis les règles, vous devez être au moins 3 pour jouer!!", Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(PlayersNumberActivity.this, MainActivity.class);
                    intent.putExtra(TAG_NB_PLAYERS, Integer.valueOf(nb_players.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }
}
