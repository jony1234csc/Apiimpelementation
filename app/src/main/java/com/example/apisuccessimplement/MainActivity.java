package com.example.apisuccessimplement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.apisuccessimplement.wishresponse.Datum;
import com.example.apisuccessimplement.wishresponse.WishResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://ezze.dev/";
    private static final String tag = "retrofit call";
    private RecyclerView recyclerView;
    private WishAdapter wishAdapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleViewID);
        linearLayoutManager = new LinearLayoutManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WishApiService apiService = retrofit.create(WishApiService.class);
        apiService.getWishResponse().enqueue(new Callback<WishResponse>() {
            @Override
            public void onResponse(Call<WishResponse> call, Response<WishResponse> response) {

                WishResponse res = response.body();

                if (response.isSuccessful()) {


                    List<Datum> data = res.getData();
                    wishAdapter = new WishAdapter(MainActivity.this, data);
                    recyclerView.setAdapter(wishAdapter);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    Toast.makeText(MainActivity.this, "if: " +res.getMessage(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "else: "+response.code(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<WishResponse> call, Throwable t) {

                Log.e(tag, t.getLocalizedMessage());

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}