package com.example.pokeapp.pokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel Alvarez on 28/7/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public interface PokeapiService {

    @GET("pokemon")
    Call<com.example.pokeapp.models.PokemonRequest> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

}
