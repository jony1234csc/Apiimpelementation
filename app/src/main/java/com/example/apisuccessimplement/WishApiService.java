package com.example.apisuccessimplement;

import com.example.apisuccessimplement.wishresponse.WishResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WishApiService {
    @GET("api/news")
    Call<WishResponse> getWishResponse();
}
