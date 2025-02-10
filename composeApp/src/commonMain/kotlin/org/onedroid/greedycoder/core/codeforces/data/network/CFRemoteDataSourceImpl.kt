package org.onedroid.greedycoder.core.codeforces.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.onedroid.greedycoder.core.codeforces.data.dto.CFContestSearchDto
import org.onedroid.greedycoder.core.codeforces.data.dto.CFUserSearchDto
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result
import org.onedroid.greedycoder.core.network.safeCall
import org.onedroid.greedycoder.core.utils.CODEFORCES_BASE_URL

class CFRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : CFRemoteDataSource {
    override suspend fun cfUserSearch(
        handle: String
    ): Result<CFUserSearchDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "${CODEFORCES_BASE_URL}/user.info"
            ) {
                parameter("handles", handle)
            }
        }
    }

    override suspend fun cfContests(): Result<CFContestSearchDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "${CODEFORCES_BASE_URL}/contest.list"
            )
        }
    }
}