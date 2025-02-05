package org.onedroid.greedycoder.core.codeforces.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CFUserDto(
    @SerialName("firstName") val firstName: String?,
    @SerialName("lastName") val lastName: String?,
    @SerialName("handle") val handle: String,
    @SerialName("avatar") val avatar: String,
    @SerialName("titlePhoto") val titlePhoto: String,
    @SerialName("rating") val rating: Int,
    @SerialName("rank") val rank: Int,
    @SerialName("maxRating") val maxRating: Int,
    @SerialName("maxRank") val maxRank: String,
    @SerialName("organization") val organization: String?,
    @SerialName("country") val country: String?,
    @SerialName("city") val city: String?,
    @SerialName("friendOfCount") val friendOfCount: Int,
    @SerialName("contribution") val contribution: Int,
    @SerialName("lastOnlineTimeSeconds") val lastOnlineTimeSeconds: Long,
    @SerialName("registrationTimeSeconds") val registrationTimeSeconds: Long
)