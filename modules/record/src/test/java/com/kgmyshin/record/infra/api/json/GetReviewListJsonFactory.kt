package com.kgmyshin.record.infra.api.json

object GetReviewListJsonFactory {
  fun create(reviewList: List<com.kgmyshin.record.infra.api.json.ReviewJson> = listOf(com.kgmyshin.record.infra.api.json.ReviewJsonFactory.create(), com.kgmyshin.record.infra.api.json.ReviewJsonFactory.create(), com.kgmyshin.record.infra.api.json.ReviewJsonFactory.create())): GetReviewListJson = com.kgmyshin.record.infra.api.json.GetReviewListJson(reviewList)
}
