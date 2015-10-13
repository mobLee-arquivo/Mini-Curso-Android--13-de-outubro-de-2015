package com.gfpacheco.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        String name = getIntent().getStringExtra("name");

        TextView textView = (TextView) findViewById(R.id.text_view_name);
        textView.setText(name);
    }
}
