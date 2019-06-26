package com.example.week4day2;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RestrofitExample {
    public static final String URL="http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1";
    public static final String BASE_URL="http://api.flickr.com/services/";
    public static final String PATH="feeds/photos_public.gne";

    public static final String QUERY_TAG="tag";
    public static final String QUERY_FORMAT="format";
    public static final String QUERY_NOJSONCALLBACK="nojsoncallback";
    public Retrofit getRetrofitInstance(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        return new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }
    public PictureService getService(){
        return getRetrofitInstance().create(PictureService.class);
    }
    public interface PictureService{
        @GET(PATH)
        Call<Image> getPicture(@Query(QUERY_TAG) String tag, @Query(QUERY_FORMAT) String format,@Query(QUERY_NOJSONCALLBACK) String num);

    }
}
