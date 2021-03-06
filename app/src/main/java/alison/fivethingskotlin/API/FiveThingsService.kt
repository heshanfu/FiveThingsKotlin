package alison.fivethingskotlin.API

import alison.fivethingskotlin.Models.PaginatedSearchResults
import alison.fivethingskotlin.Models.SearchResult
import alison.fivethingskotlin.Models.Thing
import retrofit2.Call
import retrofit2.http.*

interface FiveThingsService {
    companion object {
        fun create(): FiveThingsService = RetrofitHelper.build().create(FiveThingsService::class.java)
    }

    @GET("get_things_for_day/{year}/{month}/{day}")
    fun getFiveThings(@Header("Authorization") token: String,
                                   @Path("year") year: String,
                                   @Path("month") month: String,
                                   @Path("day") day: String): Call<List<Thing>>

    @PUT("things_for_day/")
    fun updateFiveThings(@Header("Authorization") token: String, @Body fiveThingsRequest: Array<Thing>): Call<List<String>>

    @POST("things_for_day/")
    fun writeFiveThings(@Header("Authorization") token: String, @Body fiveThingsRequest: Array<Thing>): Call<List<String>>

    @GET("get_days_written")
    fun getWrittenDates(@Header("Authorization") token: String): Call<List<String>>

    @GET("search_all/{keyword}")
    fun searchAll(@Header("Authorization") token: String, @Path("keyword") keyword: String): Call<List<SearchResult>>

    @GET("search/{keyword}")
    fun search(@Header("Authorization") token: String,
               @Path("keyword") keyword: String,
               @Query("page_size") pageSize: Int,
               @Query("page") page: Int): Call<PaginatedSearchResults>

}
