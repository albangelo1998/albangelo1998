package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    public void on_button_click(View view) {
        TextView tv = (TextView) this.findViewById(R.id.myTextView);



        tv.setText(Integer.toString(roll_the_dice()));
        EditText guesser = (EditText) findViewById(R.id.NumberGuesser);
        String User_Guess = guesser.getText().toString();
        check_answer(User_Guess);
    }

    public void Game_click(View view)
    {
        String questions [] = {"If you could go anywhere in the world, where would you go?", "If you were stranded on a desert island, what three things would you want to take with you?","If you could eat only one food for the rest of your life, what would that be?","If you won a million dollars, what is the first thing you would buy?","If you could spaned the day with one fictional character, who would it be?","If you found a magic lantern and a genie gave you three wishes, what would you wish?"};
        TextView tv = this.findViewById(R.id.textView);
        tv.setText(questions[roll_the_dice()-1]);
    }

    public void check_answer(String input_guess)
    {
        TextView tv = (TextView)this.findViewById(R.id.myTextView); //
        TextView scorer = (TextView)this.findViewById(R.id.Score);
        try {
            int rolled_dice = Integer.parseInt(tv.getText().toString());
            int guess = Integer.parseInt(input_guess);
            if (rolled_dice != guess) {
                tv.setText("Incorrect, the actual number was " + rolled_dice);
                EditText guesser = (EditText) findViewById(R.id.NumberGuesser);
                guesser.setText("");
            } else {
                tv.setText("Congratulations!");
                score = score + 1;
                scorer.setText("Score = " + score);

            }
        }
        catch(Exception ex){
            Log.e("MyErrors",ex.toString());
        }
    }

    public void DisplayIncorrect (int x) {
        TextView tv = this.findViewById(R.id.myTextView);
        tv.setText("Incorrect, the number was" + x);
    }

    public void DisplayCorrect() {
        TextView tv = this.findViewById(R.id.myTextView);
        tv.setText("Congratulations!");
    }

    public int roll_the_dice() {
        Random r = new Random();
        int number = r.nextInt(6)+1;
        return number;
    }
    public void sendMessage(View view) {

        Intent intent = new Intent( this,Acitivity2.class);
        startActivity(intent);
    }

}






