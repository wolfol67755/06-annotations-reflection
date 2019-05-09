package ohm.softa.a06.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter<Joke> {

	@Override
	public void write(JsonWriter out, Joke value) throws IOException {
		throw new RuntimeException();
	}

	private Gson gson = new Gson();

	private static class Wrapper{
		String type;
		Joke value;
	}

	@Override
	public Joke read(JsonReader in) throws IOException {
		Wrapper w = gson.fromJson(in, Wrapper.class);
		if(w.type.equals("success"))
			return w.value;
		else
			throw new IOException();
	}
}
