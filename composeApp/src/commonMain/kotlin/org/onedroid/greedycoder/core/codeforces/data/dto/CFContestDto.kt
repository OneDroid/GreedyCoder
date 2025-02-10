package org.onedroid.greedycoder.core.codeforces.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CFContestDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("type") val type: String,
    @SerialName("phase") val phase: String,
    @SerialName("durationSeconds") val durationSeconds: Long,
    @SerialName("startTimeSeconds") val startTimeSeconds: Long,
    @SerialName("relativeTimeSeconds") val relativeTimeSeconds: Long,
)