package com.example.apisuccessimplement;

import com.example.apisuccessimplement.wishresponse.WishResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WishApiService {
    @GET("mujib/api/letters")
    Call<WishResponse> getWishResponse();
}
