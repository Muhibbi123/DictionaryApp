package com.mrt.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.mrt.dictionary.Models.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();  /*retrofit api ile iletişimi kurar, gson ise onları javada kullanacağımız hale çevirir*/

    public RequestManager(Context context) { /*constructor metodu*/
        this.context = context;
    }

    public void getWordMeaning(OnFetchDataListener listener, String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<APIResponse>> call = callDictionary.callMeanings(word);

        try{
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    if(!response.isSuccessful()){ /*response if not succesful*/
                        Toast.makeText(context, "error.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0), response.message());

                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                    listener.onError("Request failed.");
                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "An error occured.", Toast.LENGTH_SHORT).show();
        }

    }

    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callMeanings(
            @Path("word") String word
        );


    }
}
