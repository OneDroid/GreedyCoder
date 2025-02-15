package org.onedroid.greedycoder.core.codeforces.data.repository

import org.onedroid.greedycoder.core.codeforces.data.mappers.toCFContest
import org.onedroid.greedycoder.core.codeforces.data.mappers.toCFUser
import org.onedroid.greedycoder.core.codeforces.data.network.CFRemoteDataSource
import org.onedroid.greedycoder.core.codeforces.domain.entity.CFContest
import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser
import org.onedroid.greedycoder.core.codeforces.domain.repository.CFRepository
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result
import org.onedroid.greedycoder.core.network.map

class CFRepositoryImpl(
    private val remoteDataSource: CFRemoteDataSource
) : CFRepository {
    override suspend fun cfUserSearch(handle: String): Result<CFUser, DataError.Remote> {
        return when (val result = remoteDataSource.cfUserSearch(handle)) {
            is Result.Success -> {
                val users = result.data.users
                if (users.isNotEmpty()) {
                    Result.Success(users[0].toCFUser())
                } else {
                    Result.Error(DataError.Remote.NOT_FOUND)
                }
            }

            is Result.Error -> result
        }
    }

    override suspend fun cfContests(): Result<List<CFContest>, DataError.Remote> {
        return remoteDataSource.cfContests().map { dto ->
            dto.contests.map { it.toCFContest() }
        }
    }
}