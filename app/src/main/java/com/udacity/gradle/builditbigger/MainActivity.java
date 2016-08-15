package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.util.Pair;
import com.example.akshitgupta.jokeddisplaylibrary.MainlibActivity;
import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {
    private ProgressBar spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
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

    public void tellJoke(View view) {
        spinner.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                spinner.setVisibility(View.INVISIBLE);
            }
        }, 3000);
        final Intent intent = new Intent(this, MainlibActivity.class);

        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                intent.putExtra("key", result);
                startActivity(intent);
            }
        });
        task.execute(new Pair<Context, String>(this, "Manfred"));

    }
}
