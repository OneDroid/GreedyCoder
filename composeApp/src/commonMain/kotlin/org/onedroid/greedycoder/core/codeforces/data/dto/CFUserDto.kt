package org.onedroid.greedycoder.core.codeforces.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CFUserDto(
    @SerialName("firstName") val firstName: String? = null,
    @SerialName("lastName") val lastName: String? = null,
    @SerialName("handle") val handle: String,
    @SerialName("avatar") val avatar: String,
    @SerialName("titlePhoto") val titlePhoto: String,
    @SerialName("rating") val rating: Int? = null,
    @SerialName("rank") val rank: String? = null,
    @SerialName("maxRating") val maxRating: Int? = null,
    @SerialName("maxRank") val maxRank: String? = null,
    @SerialName("organization") val organization: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("friendOfCount") val friendOfCount: Int? = null,
    @SerialName("contribution") val contribution: Int,
    @SerialName("lastOnlineTimeSeconds") val lastOnlineTimeSeconds: Long,
    @SerialName("registrationTimeSeconds") val registrationTimeSeconds: Long
)