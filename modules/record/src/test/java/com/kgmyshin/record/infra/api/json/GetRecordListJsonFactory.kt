package com.kgmyshin.record.infra.api.json

import com.kgmyshin.random.RandomHelper

object GetRecordListJsonFactory {
  fun create(recordList: List<com.kgmyshin.record.infra.api.json.RecordJson> = listOf(com.kgmyshin.record.infra.api.json.RecordJsonFactory.create(), com.kgmyshin.record.infra.api.json.RecordJsonFactory.create(), com.kgmyshin.record.infra.api.json.RecordJsonFactory.create())): GetRecordListJson = com.kgmyshin.record.infra.api.json.GetRecordListJson(recordList)
}
