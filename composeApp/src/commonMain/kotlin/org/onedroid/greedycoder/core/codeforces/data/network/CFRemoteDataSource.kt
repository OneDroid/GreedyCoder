package org.onedroid.greedycoder.core.codeforces.data.network

import org.onedroid.greedycoder.core.codeforces.data.dto.CFContestSearchDto
import org.onedroid.greedycoder.core.codeforces.data.dto.CFUserSearchDto
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result

interface CFRemoteDataSource {
    suspend fun cfUserSearch(
        handle: String
    ): Result<CFUserSearchDto, DataError.Remote>

    suspend fun cfContests(): Result<CFContestSearchDto, DataError.Remote>
}