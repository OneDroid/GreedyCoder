package org.onedroid.greedycoder.core.codeforces.domain.usecase

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFContest
import org.onedroid.greedycoder.core.codeforces.domain.repository.CFRepository
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result

class FetchCFContestsUseCase(
    private val repository: CFRepository
) {
    suspend operator fun invoke(): Result<List<CFContest>, DataError.Remote> {
        return repository.cfContests()
    }
}