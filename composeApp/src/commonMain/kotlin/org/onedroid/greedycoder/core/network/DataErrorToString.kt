package org.onedroid.greedycoder.core.network

import greedycoder.composeapp.generated.resources.Res
import greedycoder.composeapp.generated.resources.error_disk_full
import greedycoder.composeapp.generated.resources.error_request_timeout
import greedycoder.composeapp.generated.resources.error_too_many_requests
import greedycoder.composeapp.generated.resources.error_unknown
import greedycoder.composeapp.generated.resources.error_no_internet
import greedycoder.composeapp.generated.resources.error_not_found
import greedycoder.composeapp.generated.resources.error_serialization
import org.onedroid.greedycoder.core.utils.UiText

fun DataError.toUiText(): UiText {
    val stringRes = when (this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.NOT_FOUND -> Res.string.error_not_found
    }

    return UiText.StringResourceId(stringRes)
}