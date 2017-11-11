package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import io.reactivex.Single
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class GetBeforeSeasonWorkListUseCaseImplSpec : SubjectSpek<GetBeforeSeasonWorkListUseCaseImpl>({

    val repository = Mockito.mock(WorkRepository::class.java)

    subject {
        GetBeforeSeasonWorkListUseCaseImpl(repository)
    }

    given("WorkRepository.findAllBySeason return workList") {
        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )
        Mockito.`when`(repository.findAllBySeason(Season.beforeSeason())).thenReturn(Single.just(workList))

        on("execute") {
            val single = subject.execute()

            it("should return workList") {
                single.test().await().assertValue(workList).assertComplete()
            }

        }

    }

})
