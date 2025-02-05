package org.onedroid.greedycoder.core.codeforces.data.mappers

import org.onedroid.greedycoder.core.codeforces.data.dto.CFUserDto
import org.onedroid.greedycoder.core.codeforces.domain.entity.CFUser

fun CFUserDto.toCFUser(): CFUser {
    return CFUser(
        firstName = firstName,
        lastName = lastName,
        handle = handle,
        avatar = avatar,
        titlePhoto = titlePhoto,
        rating = rating,
        rank = rank,
        maxRating = maxRating,
        maxRank = maxRank,
        organization = organization,
        country = country,
        city = city,
        friendOfCount = friendOfCount,
        contribution = contribution,
        lastOnlineTimeSeconds = lastOnlineTimeSeconds,
        registrationTimeSeconds = registrationTimeSeconds
    )
}