package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.DomainHelper
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.common.random.RandomHelper
import io.reactivex.Single
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class SearchWorkListUseCaseImplSpec : SubjectSpek<SearchWorkListUseCaseImpl>({

    val repository = Mockito.mock(WorkRepository::class.java)

    subject {
        SearchWorkListUseCaseImpl(repository)
    }

    given("WorkRepository.findAllByKeyword return workList") {
        val keyword = RandomHelper.randomString()
        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )
        beforeGroup {
            Mockito.`when`(repository.findAllByKeyword(keyword)).thenReturn(Single.just(workList))
        }

        on("execute") {
            val single = subject.execute(keyword)

            it("should return workList") {
                single.test().await().assertValue(workList).assertComplete()
            }
        }
    }

})