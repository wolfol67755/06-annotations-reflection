package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ohm.softa.a06.model.Joke;
import ohm.softa.a06.model.JokeAdapter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		Gson gson = new GsonBuilder()
			.registerTypeAdapter(Joke.class, new JokeAdapter())
			.create();


		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.icndb.com")
			.addConverterFactory(GsonConverterFactory.create())
			.build();


		ICNDBApi service = retrofit.create(ICNDBApi.class);

		Call<Joke> call = service.getRandomJoke();
		Response<Joke> resp = call.execute();
		Joke j = resp.body();

		List<Joke> li = service.getRandomJokes(3).execute().body();



		System.out.println();
	}

}
