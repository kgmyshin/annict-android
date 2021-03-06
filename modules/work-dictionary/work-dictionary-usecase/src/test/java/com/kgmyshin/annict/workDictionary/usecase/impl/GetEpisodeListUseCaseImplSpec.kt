package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.DomainHelper
import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.domain.work.episode.EpisodeRepository
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
internal class GetEpisodeListUseCaseImplSpec : SubjectSpek<GetEpisodeListUseCaseImpl>({

    val repository = Mockito.mock(EpisodeRepository::class.java)

    subject {
        GetEpisodeListUseCaseImpl(repository)
    }

    given("EpisodeRepository.findAllByWorkId return episodeList") {
        val workId = WorkId(RandomHelper.randomString())
        val episodeList = listOf(
                DomainHelper.episode(),
                DomainHelper.episode(),
                DomainHelper.episode()
        )

        beforeGroup {
            Mockito.`when`(repository.findAllByWorkId(workId)).thenReturn(Single.just(episodeList))
        }

        on("execute") {
            val single = subject.execute(workId)

            it("should return episodeList") {
                single.test().await().assertValue(episodeList).assertComplete()
            }
        }

    }

})