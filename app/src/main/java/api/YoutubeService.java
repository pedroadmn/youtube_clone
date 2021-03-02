package api;

import models.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeService {

    @GET("search")
    Call<Result> getVideos(@Query("part") String part,
                           @Query("order") String order,
                           @Query("maxResults") String maxResults,
                           @Query("key") String key,
                           @Query("channelId") String channelId,
                           @Query("q") String q
    );
}
