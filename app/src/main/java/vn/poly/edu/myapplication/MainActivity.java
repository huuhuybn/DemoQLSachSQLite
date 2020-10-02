package vn.poly.edu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.poly.edu.myapplication.sqlite.MySqlite;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySqlite mySqlite = new MySqlite(this);


    }
}