package com.example.pokeapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Retrofit;

import com.example.pokeapp.DI.ServiceLocator;
import com.example.pokeapp.view.adapter.ListPokemonAdapter;
import com.example.pokeapp.R;
import com.example.pokeapp.models.Pokemon;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceLocator.init(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ServiceLocator.getInstance().getRequest().obtenerDatos().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(List<Pokemon> pokemons) {
                if (!pokemons.isEmpty()) {
                    recyclerView.setAdapter(new ListPokemonAdapter(getApplicationContext(), pokemons));
                }
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}
