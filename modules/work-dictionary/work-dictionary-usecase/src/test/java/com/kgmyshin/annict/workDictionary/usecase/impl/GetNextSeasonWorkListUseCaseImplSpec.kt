package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.DomainHelper
import com.kgmyshin.annict.workDictionary.domain.work.Season
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import io.reactivex.Single
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class GetNextSeasonWorkListUseCaseImplSpec : SubjectSpek<GetNextSeasonWorkListUseCaseImpl>({

    val repository = Mockito.mock(WorkRepository::class.java)

    subject {
        GetNextSeasonWorkListUseCaseImpl(repository)
    }

    given("WorkRepository.findAllBySeason return workList") {
        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )

        beforeGroup {
            Mockito.`when`(repository.findAllBySeason(Season.nextSeason())).thenReturn(Single.just(workList))
        }

        on("execute") {
            val single = subject.execute()

            it("") {
                single.test().await().assertValue(workList).assertComplete()
            }
        }
    }

})