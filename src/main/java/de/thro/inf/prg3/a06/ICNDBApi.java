package de.thro.inf.prg3.a06;

import de.thro.inf.prg3.a06.model.Joke;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public interface ICNDBApi {

	@GET("/jokes/random")
	Call<Joke> getRandomJoke();

	@GET("/jokes/random")
	Call<Joke> getRandomJoke(@Query("firstName") String firstName, @Query("lastName") String lastName);

	@GET("/jokes/random/{count}")
	Call<Joke[]> getRandomJokes(@Path("count") int count);

	@GET("/jokes/random/{count}")
	Call<Joke[]> getRandomJokes(@Path("count") int count, @Query("firstName") String firstName, @Query("lastName") String lastName);

	@GET("/jokes/random/{count}")
	Call<Joke[]> getRandomJokes(@Path("count") int count, @Query("limitTo") String[] categories);

	@GET("/jokes/random/{count}")
	Call<Joke[]> getRandomJokes(@Path("count") int count, @Query("limitTo") String[] categories, @Query("firstName") String firstName, @Query("lastName") String lastName);

	@GET("/jokes/{id}")
	Call<Joke> getJoke(@Path("id") int number);
}
