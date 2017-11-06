package com.kgmyshin.record.infra.api

import com.kgmyshin.record.infra.api.json.GetRecordListJson
import com.kgmyshin.record.infra.api.json.GetReviewListJson
import com.kgmyshin.record.infra.api.json.RecordJson
import com.kgmyshin.record.infra.api.json.ReviewJson
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

internal interface RecordApiClient {

    @GET("/v1/reviews")
    fun getReviews(
            @Query("filter_ids") filterIds: String? = null,
            @Query("filter_work_id") filterWorkId: String? = null,
            @Query("page") page: Int = 1,
            @Query("per_page") prePage: Int = 50, // default: 25, max: 50
            @Query("sort_id") sordId: String? = null, // "asc" or "desc"
            @Query("sort_likes_count") sortLikesCount: String? = null, // "asc" or "desc"
            @Query("access_token") accessToken: String
    ): Single<GetReviewListJson>

    @POST("/v1/me/reviews")
    fun createReview(
            @Query("work_id") workId: String,
            @Query("title") title: String,
            @Query("body") body: String,
            @Query("rating_animation_sate") ratingAnimationState: String,
            @Query("rating_music_state") ratingMusicState: String,
            @Query("rating_story_state") ratingStoryState: String,
            @Query("rating_character_state") ratingCharacterState: String,
            @Query("rating_overall_state") ratingOverallState: String,
            @Query("share_twitter") shareTwitter: Boolean,
            @Query("share_facebook") shareFacebook: Boolean,
            @Query("access_token") accessToken: String
    ): Single<ReviewJson>

    @PATCH("/v1/me/reviews/{id}")
    fun updateReview(
            @Path("id") id: String,
            @Query("title") title: String,
            @Query("body") body: String,
            @Query("rating_animation_sate") ratingAnimationState: String,
            @Query("rating_music_state") ratingMusicState: String,
            @Query("rating_story_state") ratingStoryState: String,
            @Query("rating_character_state") ratingCharacterState: String,
            @Query("rating_overall_state") ratingOverallState: String,
            @Query("share_twitter") shareTwitter: Boolean,
            @Query("share_facebook") shareFacebook: Boolean,
            @Query("access_token") accessToken: String
    ): Single<ReviewJson>

    @DELETE("/v1/me/reviews/{id}")
    fun deleteReview(
            @Path("id") id: String,
            @Query("access_token") accessToken: String
    ): Completable

    @GET("/v1/records")
    fun getRecords(
            @Query("filter_ids") filterIds: String? = null,
            @Query("filter_episode_id") filterEpisodeId: String? = null,
            @Query("filter_has_record_comment") filterHasRecordComment: Boolean? = null,
            @Query("page") page: Int = 1,
            @Query("per_page") prePage: Int = 50, // default: 25, max: 50
            @Query("sort_id") sordId: String? = null, // "asc" or "desc"
            @Query("sort_likes_count") sortLikesCount: String? = null, // "asc" or "desc"
            @Query("access_token") accessToken: String
    ): Single<GetRecordListJson>

    @POST("/v1/me/records")
    fun createRecord(
            @Query("episode_id") episodeId: String,
            @Query("comment") comment: String,
            @Query("rating_state") ratingState: String,
            @Query("share_twitter") shareTwitter: Boolean,
            @Query("share_facebook") shareFacebook: Boolean,
            @Query("access_token") accessToken: String
    ): Single<RecordJson>

    @PATCH("/v1/me/records/{id}")
    fun updateRecord(
            @Path("id") id: String,
            @Query("comment") comment: String,
            @Query("rating_state") ratingState: String,
            @Query("share_twitter") shareTwitter: Boolean,
            @Query("share_facebook") shareFacebook: Boolean,
            @Query("access_token") accessToken: String
    ): Single<RecordJson>

    @DELETE("/v1/me/records/{id}")
    fun deleteRecored(
            @Path("id") id: String,
            @Query("access_token") accessToken: String
    ): Completable

}