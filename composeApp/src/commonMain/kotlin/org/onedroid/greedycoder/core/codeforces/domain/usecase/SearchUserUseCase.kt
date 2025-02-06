package org.onedroid.greedycoder.core.codeforces.domain.usecase

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser
import org.onedroid.greedycoder.core.codeforces.domain.repository.CFRepository
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result

class SearchUserUseCase(
    private val repository: CFRepository
) {
    suspend operator fun invoke(handle: String): Result<CFUser, DataError.Remote> {
        return repository.searchCFUser(handle)
    }
}