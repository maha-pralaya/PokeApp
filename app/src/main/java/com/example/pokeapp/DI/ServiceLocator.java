package com.example.pokeapp.DI;

import android.content.Context;

import com.example.pokeapp.database.PokemonDatabase;
import com.example.pokeapp.network.PokemonRequest;

public class ServiceLocator {
    private static ServiceLocator _instance;

    private PokemonDatabase database;
    private PokemonRequest request;

    public static ServiceLocator getInstance() {
        return  _instance;
    }

    private ServiceLocator(Context context) {
        database = PokemonDatabase.getDatabase(context);
        request = new PokemonRequest();
    }

    public PokemonDatabase getDatabase() {
        return database;
    }

    public PokemonRequest getRequest() {
        return request;
    }

    public static void init(Context context) {
        _instance = new ServiceLocator(context);
    }
}
