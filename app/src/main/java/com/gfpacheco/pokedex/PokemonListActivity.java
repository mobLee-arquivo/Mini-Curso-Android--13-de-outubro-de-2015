package com.gfpacheco.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class PokemonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        ListView listView = (ListView) findViewById(R.id.list_view);

        final PokemonAdapter adapter = new PokemonAdapter(
                this
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = adapter.getItem(position).name;
                Intent i = new Intent(PokemonListActivity.this, PokemonDetailActivity.class);
                i.putExtra("name", name);
                startActivity(i);
            }
        });

        Ion.with(this)
                .load("http://pokeapi.co/api/v1/pokemon?limit=50")
                .as(new TypeToken<PokeAPIResult>() {})
                .setCallback(new FutureCallback<PokeAPIResult>() {
                    @Override
                    public void onCompleted(Exception e, PokeAPIResult result) {
                        adapter.setPokemonList(result.objects);
                    }
                });
    }
}
















