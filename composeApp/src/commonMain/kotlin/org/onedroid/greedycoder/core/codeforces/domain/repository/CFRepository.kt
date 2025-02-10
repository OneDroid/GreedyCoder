package org.onedroid.greedycoder.core.codeforces.domain.repository

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFContest
import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result

interface CFRepository {
    suspend fun cfUserSearch(handle: String): Result<CFUser, DataError.Remote>
    suspend fun cfContests(): Result<List<CFContest>, DataError.Remote>
}