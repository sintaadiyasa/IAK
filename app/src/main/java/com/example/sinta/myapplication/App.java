package com.example.sinta.myapplication;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class App extends Application {
    private static App instance;
    private EventBus eventBus;
    private Gson gson;
    private Retrofit retrofit;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createEventBus();
        createGson();
        createRetrofit();
    }

    private void createGson() {
        gson = new GsonBuilder().create();
    }

    private void createEventBus() {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    private void createRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MovieApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Gson getGson() {
        return gson;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public MovieApi getMovieApi() {
        return getRetrofit().create(MovieApi.class);
    }

    public static App getInstance() {
        return instance;
    }
}

