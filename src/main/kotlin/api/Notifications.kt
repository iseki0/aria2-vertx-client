package api

typealias NotificationListener = suspend (Gid) -> Unit

fun aria2.onDownloadStart(handler: NotificationListener) =
    addNotificationListener("aria2.onDownloadStart", handler)

fun aria2.onDownloadPause(handler: NotificationListener) =
    addNotificationListener("aria2.onDownloadPause", handler)

fun aria2.onDownloadStop(handler: NotificationListener) =
    addNotificationListener("aria2.onDownloadStop", handler)

fun aria2.onDownloadComplete(handler: NotificationListener) =
    addNotificationListener("aria2.onDownloadComplete", handler)

fun aria2.onDownloadError(handler: NotificationListener) =
    addNotificationListener("aria2.onDownloadError", handler)

fun aria2.onBtDownloadComplete(handler: NotificationListener) =
    addNotificationListener("aria2.onBtDownloadComplete", handler)