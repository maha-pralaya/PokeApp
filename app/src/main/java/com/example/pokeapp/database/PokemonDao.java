package com.example.pokeapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokeapp.models.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAllPokemons();

    @Insert
    void insertPokemon(Pokemon pokemon);
}
