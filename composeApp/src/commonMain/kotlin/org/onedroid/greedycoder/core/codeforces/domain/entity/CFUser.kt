package org.onedroid.greedycoder.core.codeforces.domain.entity

data class CFUser(
    val firstName: String?,
    val lastName: String?,
    val handle: String,
    val avatar: String,
    val titlePhoto: String,
    val rating: Int?,
    val rank: String?,
    val maxRating: Int?,
    val maxRank: String?,
    val organization: String?,
    val country: String?,
    val city: String?,
    val friendOfCount: Int?,
    val contribution: Int,
    val lastOnlineTimeSeconds: Long,
    val registrationTimeSeconds: Long
)