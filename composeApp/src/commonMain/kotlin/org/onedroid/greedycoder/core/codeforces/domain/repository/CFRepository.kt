package org.onedroid.greedycoder.core.codeforces.domain.repository

import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser
import org.onedroid.greedycoder.core.network.DataError
import org.onedroid.greedycoder.core.network.Result

interface CFRepository {
    suspend fun searchCFUser(handel: String): Result<CFUser, DataError.Remote>
}