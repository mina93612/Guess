package com.mina.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
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
    int guesstime;
    String TAG = MainActivity.class.getSimpleName();
    private EditText number;
    int secret = new Random().nextInt(10) + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = findViewById(R.id.ed_num);
        Log.d(TAG, "Secret:" + secret);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    public void Guess(View view) {
        guesstime += 1;
        TextView times = findViewById(R.id.times);
        TextView inform = findViewById(R.id.inform);
        int num = Integer.parseInt(String.valueOf(number.getText().toString()));
        if (num > secret) {
            new AlertDialog.Builder(this)
                    .setMessage("Smaller")
                    .setTitle("result")
                    .show();

            // inform.setText("Smaller!!");
        } else if (num < secret) {
            // inform.setText("!Bigger!");
            new AlertDialog.Builder(this)
                    .setMessage("Bigger")
                    .setTitle("result")
                    .show();
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("Bingo")
                    .setTitle("result")
                    .setPositiveButton("OK", null)
                    .show();
            //inform.setText("Bingo!!!");
        }
        times.setText("猜了"+guesstime+"次");
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
