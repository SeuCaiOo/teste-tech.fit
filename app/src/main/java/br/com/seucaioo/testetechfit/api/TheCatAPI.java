package br.com.seucaioo.testetechfit.api;


import java.util.List;

import br.com.seucaioo.testetechfit.model.Breed;
import br.com.seucaioo.testetechfit.model.Category;
import br.com.seucaioo.testetechfit.model.Image;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheCatAPI {

    @GET("/v1/categories")
    Call<List<Category>> getCategories();

    @GET("v1/breeds")
    Call<List<Breed>> getBreeds();

    @GET("/v1/images/search/?category_ids=2&limit=10")
    Call<List<Image>> getTenRandomImages();

    @GET("/v1/images/search")
    Call<Image> getRandomImage();

    @GET("/v1/images/{image_id}")
    Call<Image> getImageById(@Path("image_id") String id);
}
