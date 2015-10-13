package com.gfpacheco.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends BaseAdapter {

    private final LayoutInflater inflater;

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    private List<Pokemon> pokemonList = new ArrayList<>();

    public PokemonAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Pokemon getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_pokemon, parent, false);
        }

        Pokemon pokemon = pokemonList.get(position);

        ((TextView) convertView.findViewById(R.id.text_view_name)).setText(pokemon.name);
        ((TextView) convertView.findViewById(R.id.text_view_type)).setText(pokemon.type);

        return convertView;
    }
}
