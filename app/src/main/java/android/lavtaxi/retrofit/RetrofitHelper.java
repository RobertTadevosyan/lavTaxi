package android.lavtaxi.retrofit;

import android.content.Context;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anahit on 7/15/16.
 */
public class RetrofitHelper {

    static GitHubService gitHubService;
    static Retrofit retrofit;

    public static GitHubService gitHubService(Context context) {
        if (gitHubService == null) {
            Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            }).setLenient().create();

            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            retrofit = new Retrofit.Builder()
                    .baseUrl(ConfigHelper.getString(context, "application.base_url"))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .callFactory(httpClientBuilder.build())
                    .build();
            gitHubService = retrofit.create(GitHubService.class);
        }
        return gitHubService;
    }

}
