package org.onedroid.greedycoder.core.codeforces.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onedroid.greedycoder.core.codeforces.data.dto.CFSearchDto
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result
import org.onedroid.greedycoder.core.network.safeCall
import org.onedroid.greedycoder.core.utils.CODEFORCES_BASE_URL

class CFRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : CFRemoteDataSource {
    override suspend fun searchUser(
        handle: String
    ): Result<CFSearchDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "${CODEFORCES_BASE_URL}/user.info"
            ) {
                parameter("handles", handle)
            }
        }
    }
}