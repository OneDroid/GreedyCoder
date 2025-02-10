package org.onedroid.greedycoder.core.codeforces.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CFContestSearchDto(
    @SerialName("result") val contests: List<CFContestDto>
)
