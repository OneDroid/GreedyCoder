package org.onedroid.greedycoder.core.network

sealed interface DataError: Error {
    enum class Remote: DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER,
        SERIALIZATION,
        NOT_FOUND,
        UNKNOWN
    }
    enum class Local: DataError {
        DISK_FULL,
        UNKNOWN
    }
}