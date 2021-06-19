package com.example.pokeapp.database;

import android.content.Context;

import com.example.pokeapp.models.Pokemon;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Pokemon.class, version = 1)
public abstract class PokemonDatabase extends RoomDatabase {
    public abstract PokemonDao pokemonDao();

    public static PokemonDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context, PokemonDatabase.class, "pokemon-database").build();
    }
}
