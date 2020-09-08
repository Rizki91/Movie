package com.fahrul.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fahrul.movie.adapter.AdapterListSimpel;
import com.fahrul.movie.model.MovieModel;
import com.fahrul.movie.model.SearchList;
import com.fahrul.movie.service.APIClient;
import com.fahrul.movie.service.APIInterfaceRest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity   {

    RecyclerView lstMovie;
    private ArrayList<MovieModel> lstMovieOMD;
    EditText txtCari;
    Button btn_cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCari = findViewById(R.id.txtCari);
        btn_cari = findViewById(R.id.btn_cari);
        lstMovie = findViewById(R.id.lstMovie);

        btn_cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callMovie(txtCari.getText().toString());
            }
        });


    }

    APIInterfaceRest apiInterface;
    ProgressDialog progressDialog;
    public void callMovie(String judul){

        apiInterface = APIClient.getClient().create(APIInterfaceRest.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<SearchList> call3 = apiInterface.getSearch(judul,"763c4ddf");
        call3.enqueue(new Callback<SearchList>() {
            @Override
            public void onResponse(Call<SearchList> call, Response<SearchList> response) {
                progressDialog.dismiss();
                SearchList searchList = response.body();
                //Toast.makeText(LoginActivity.this,userList.getToken().toString(),Toast.LENGTH_LONG).show();
                if (searchList !=null) {
                    //     txtKota.setText(dataWeather.getName());
                    //     txtTemperature.setText(new DecimalFormat("##.##").format(dataWeather.getMain().getTemp()-273.15));

//                    List<MovieModel> lstMovieOMD = new ArrayList<MovieModel>();
//                    lstMovieOMD.add(dataVideo);

                    AdapterListSimpel adapter = new AdapterListSimpel(MainActivity.this,searchList.getSearch());

                    lstMovie.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    lstMovie.setItemAnimator(new DefaultItemAnimator());
                    lstMovie.setAdapter(adapter);


                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchList> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}