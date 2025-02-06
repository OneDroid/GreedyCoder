package org.onedroid.greedycoder.core.codeforces.data.network

import org.onedroid.greedycoder.core.codeforces.data.dto.CFSearchDto
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result

interface CFRemoteDataSource {
    suspend fun searchUser(
        handle: String
    ): Result<CFSearchDto, DataError.Remote>
}