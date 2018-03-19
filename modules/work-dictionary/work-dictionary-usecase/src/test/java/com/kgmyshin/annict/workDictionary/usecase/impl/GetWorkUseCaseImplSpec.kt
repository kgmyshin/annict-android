package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.DomainHelper
import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.common.random.RandomHelper
import io.reactivex.Maybe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class GetWorkUseCaseImplSpec : SubjectSpek<GetWorkUseCaseImpl>({

    val repository = Mockito.mock(WorkRepository::class.java)

    subject {
        GetWorkUseCaseImpl(repository)
    }

    given("WorkRepository.findById return work") {
        val workId = WorkId(RandomHelper.randomString())
        val work = DomainHelper.work()

        beforeGroup {
            Mockito.`when`(repository.findById(workId)).thenReturn(Maybe.just(work))
        }

        on("execute") {
            val maybe = subject.execute(workId)

            it("should return work") {
                maybe.test().await().assertValue(work).assertComplete()
            }
        }
    }

})