package com.example.pokeapp.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pokeapp.models.Pokemon;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonRequest {

    private Retrofit retrofit;

    private MutableLiveData<List<Pokemon>> results = new MutableLiveData<>();

    public PokemonRequest() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public LiveData<List<Pokemon>> obtenerDatos() {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<List<Pokemon>> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response.isSuccessful()) {
                    
                    results.postValue(response.body());

                } else {
                    Log.e("PokemonNetwork", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                results.postValue(new ArrayList<>());
                Log.e("PokemonNetwork", " onFailure: " + t.getMessage());
            }
        });

        return results;
    }
}
