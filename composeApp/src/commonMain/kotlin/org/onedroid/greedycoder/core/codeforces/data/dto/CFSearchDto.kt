package org.onedroid.greedycoder.core.codeforces.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CFSearchDto(
    @SerialName("result") val users: List<CFUserDto>
)