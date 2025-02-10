package org.onedroid.greedycoder.core.codeforces.domain.entity

data class CFContest(
    val id: Int,
    val name: String,
    val type: String,
    val phase: String,
    val durationSeconds: Long,
    val startTimeSeconds: Long,
    val relativeTimeSeconds: Long
)
