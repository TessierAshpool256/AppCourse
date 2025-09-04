package org.appcourse.cours_api

import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.appcourse.cours_api.models.CoursesDTO
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.GET


interface CourseApi {
    @GET("/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun CoursesList(
    ): Result<CoursesDTO>
}


fun CourseApi(
    okHttpClient: OkHttpClient = OkHttpClient(),
    url: String? = "https://drive.usercontent.google.com"
): CourseApi {
    val json = Json {
        ignoreUnknownKeys = false
    }

    val retrofitBuilder = Retrofit.Builder()
        .client(okHttpClient)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )

    url?.let { retrofitBuilder.baseUrl(it) }

    return retrofitBuilder.build().create<CourseApi>()
}
