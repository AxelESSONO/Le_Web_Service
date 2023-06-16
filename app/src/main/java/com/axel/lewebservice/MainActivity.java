package com.axel.lewebservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private TVShowService tvShowService;
    private Call<TVShowRoot> tvShowRootCall;
    private static final String BASE_URL = "https://www.episodate.com/api/";
    private Thread thread;
    private RecyclerView tvShowRecycler;
    private TVShowAdapter tvShowAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowRecycler = findViewById(R.id.tvShowRecycler);

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        // Client Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Création d'une implémentation de l'interface TvShowService
        tvShowService = retrofit.create(TVShowService.class);

        /**
         * Récupération d'un objet de type Call qui permettra de faire des requêtes
         * sur le web service
         * Les requêtes ont cette forme :
         * https://www.episodate.com/api/most-popular?page=1
         */
        tvShowRootCall = tvShowService.getTVShowList(2);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<TVShowRoot> response = tvShowRootCall.execute();
                    if (response.isSuccessful()){

                        List<TVShow> tvShowList = response.body().getTvShowList();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                tvShowAdapter = new TVShowAdapter(
                                        getApplicationContext(),
                                        tvShowList
                                );

                                // Connecter le recyckerView à l'adapter
                                tvShowRecycler.setAdapter(tvShowAdapter);
                                tvShowRecycler.setLayoutManager(layoutManager);
                                tvShowRecycler.setHasFixedSize(true);

                            }
                        });
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();


    }
}

































