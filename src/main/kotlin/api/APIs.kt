@file:Suppress("unused", "RemoveExplicitTypeArguments")

package api

suspend fun aria2.addUri(secret: Secret, uris: List<String>, options: Aria2Option, position: Int): Gid =
    sendRequest<Gid>(
        "api.aria2.addUri",
        listOf("secret" to secret, "uris" to uris, "options" to options, "position" to position)
    )

suspend fun aria2.addUri(secret: Secret, uris: List<String>, options: Aria2Option): Gid =
    sendRequest<Gid>("api.aria2.addUri", listOf("secret" to secret, "uris" to uris, "options" to options))

suspend fun aria2.addUri(secret: Secret, uris: List<String>): Gid =
    sendRequest<Gid>("api.aria2.addUri", listOf("secret" to secret, "uris" to uris))

suspend fun aria2.addUri(uris: List<String>, options: Aria2Option, position: Int): Gid =
    sendRequest<Gid>("api.aria2.addUri", listOf("uris" to uris, "options" to options, "position" to position))

suspend fun aria2.addUri(uris: List<String>, options: Aria2Option): Gid =
    sendRequest<Gid>("api.aria2.addUri", listOf("uris" to uris, "options" to options))

suspend fun aria2.addUri(uris: List<String>): Gid =
    sendRequest<Gid>("api.aria2.addUri", listOf("uris" to uris))

suspend fun aria2.addTorrent(
    secret: Secret,
    torrent: Torrent,
    uris: List<String>,
    options: Aria2Option,
    position: Int
): Gid =
    sendRequest<Gid>(
        "api.aria2.addTorrent",
        listOf("secret" to secret, "torrent" to torrent, "uris" to uris, "options" to options, "position" to position)
    )

suspend fun aria2.addTorrent(secret: Secret, torrent: Torrent, uris: List<String>, options: Aria2Option): Gid =
    sendRequest<Gid>(
        "api.aria2.addTorrent",
        listOf("secret" to secret, "torrent" to torrent, "uris" to uris, "options" to options)
    )

suspend fun aria2.addTorrent(secret: Secret, torrent: Torrent, uris: List<String>): Gid =
    sendRequest<Gid>("api.aria2.addTorrent", listOf("secret" to secret, "torrent" to torrent, "uris" to uris))

suspend fun aria2.addTorrent(secret: Secret, torrent: Torrent): Gid =
    sendRequest<Gid>("api.aria2.addTorrent", listOf("secret" to secret, "torrent" to torrent))

suspend fun aria2.addTorrent(torrent: Torrent, uris: List<String>, options: Aria2Option, position: Int): Gid =
    sendRequest<Gid>(
        "api.aria2.addTorrent",
        listOf("torrent" to torrent, "uris" to uris, "options" to options, "position" to position)
    )

suspend fun aria2.addTorrent(torrent: Torrent, uris: List<String>, options: Aria2Option): Gid =
    sendRequest<Gid>("api.aria2.addTorrent", listOf("torrent" to torrent, "uris" to uris, "options" to options))

suspend fun aria2.addTorrent(torrent: Torrent, uris: List<String>): Gid =
    sendRequest<Gid>("api.aria2.addTorrent", listOf("torrent" to torrent, "uris" to uris))

suspend fun aria2.addTorrent(torrent: Torrent): Gid =
    sendRequest<Gid>("api.aria2.addTorrent", listOf("torrent" to torrent))

suspend fun aria2.addMetalink(secret: Secret, metalink: Metalink, options: Aria2Option, position: Int): List<Gid> =
    sendRequest<List<Gid>>(
        "api.aria2.addMetalink",
        listOf("secret" to secret, "metalink" to metalink, "options" to options, "position" to position)
    )

suspend fun aria2.addMetalink(secret: Secret, metalink: Metalink, options: Aria2Option): List<Gid> =
    sendRequest<List<Gid>>(
        "api.aria2.addMetalink",
        listOf("secret" to secret, "metalink" to metalink, "options" to options)
    )

suspend fun aria2.addMetalink(secret: Secret, metalink: Metalink): List<Gid> =
    sendRequest<List<Gid>>("api.aria2.addMetalink", listOf("secret" to secret, "metalink" to metalink))

suspend fun aria2.addMetalink(metalink: Metalink, options: Aria2Option, position: Int): List<Gid> =
    sendRequest<List<Gid>>(
        "api.aria2.addMetalink",
        listOf("metalink" to metalink, "options" to options, "position" to position)
    )

suspend fun aria2.addMetalink(metalink: Metalink, options: Aria2Option): List<Gid> =
    sendRequest<List<Gid>>("api.aria2.addMetalink", listOf("metalink" to metalink, "options" to options))

suspend fun aria2.addMetalink(metalink: Metalink): List<Gid> =
    sendRequest<List<Gid>>("api.aria2.addMetalink", listOf("metalink" to metalink))

suspend fun aria2.remove(secret: Secret, gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.remove", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.remove(gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.remove", listOf("gid" to gid))

suspend fun aria2.forceRemove(secret: Secret, gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.forceRemove", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.forceRemove(gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.forceRemove", listOf("gid" to gid))

suspend fun aria2.pause(secret: Secret, gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.pause", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.pause(gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.pause", listOf("gid" to gid))

suspend fun aria2.pauseAll(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.pauseAll", listOf("secret" to secret))

suspend fun aria2.pauseAll(): Ok =
    sendRequest<Ok>("api.aria2.pauseAll", emptyList())

suspend fun aria2.forcePause(secret: Secret, gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.forcePause", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.forcePause(gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.forcePause", listOf("gid" to gid))

suspend fun aria2.forcePauseAll(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.forcePauseAll", listOf("secret" to secret))

suspend fun aria2.forcePauseAll(): Ok =
    sendRequest<Ok>("api.aria2.forcePauseAll", emptyList())

suspend fun aria2.unpause(secret: Secret, gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.unpause", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.unpause(gid: Gid): Gid =
    sendRequest<Gid>("api.aria2.unpause", listOf("gid" to gid))

suspend fun aria2.unpauseAll(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.unpauseAll", listOf("secret" to secret))

suspend fun aria2.unpauseAll(): Ok =
    sendRequest<Ok>("api.aria2.unpauseAll", emptyList())

suspend fun aria2.tellStatus(secret: Secret, gid: Gid, keys: Set<StatusField>): DownloadStatus =
    sendRequest<DownloadStatus>("api.aria2.tellStatus", listOf("secret" to secret, "gid" to gid, "keys" to keys))

suspend fun aria2.tellStatus(secret: Secret, gid: Gid): DownloadStatus =
    sendRequest<DownloadStatus>("api.aria2.tellStatus", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.tellStatus(gid: Gid, keys: Set<StatusField>): DownloadStatus =
    sendRequest<DownloadStatus>("api.aria2.tellStatus", listOf("gid" to gid, "keys" to keys))

suspend fun aria2.tellStatus(gid: Gid): DownloadStatus =
    sendRequest<DownloadStatus>("api.aria2.tellStatus", listOf("gid" to gid))

suspend fun aria2.getUris(secret: Secret, gid: Gid): List<UriStatus> =
    sendRequest<List<UriStatus>>("api.aria2.getUris", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.getUris(gid: Gid): List<UriStatus> =
    sendRequest<List<UriStatus>>("api.aria2.getUris", listOf("gid" to gid))

suspend fun aria2.getFiles(secret: Secret, gid: Gid): List<FileInfo> =
    sendRequest<List<FileInfo>>("api.aria2.getFiles", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.getFiles(gid: Gid): List<FileInfo> =
    sendRequest<List<FileInfo>>("api.aria2.getFiles", listOf("gid" to gid))

suspend fun aria2.getPeers(secret: Secret, gid: Gid): List<PeerInfo> =
    sendRequest<List<PeerInfo>>("api.aria2.getPeers", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.getPeers(gid: Gid): List<PeerInfo> =
    sendRequest<List<PeerInfo>>("api.aria2.getPeers", listOf("gid" to gid))

suspend fun aria2.getServers(secret: Secret, gid: Gid): List<ServerInfoList> =
    sendRequest<List<ServerInfoList>>("api.aria2.getServers", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.getServers(gid: Gid): List<ServerInfoList> =
    sendRequest<List<ServerInfoList>>("api.aria2.getServers", listOf("gid" to gid))

suspend fun aria2.tellActive(secret: Secret, keys: Set<StatusField>): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellActive", listOf("secret" to secret, "keys" to keys))

suspend fun aria2.tellActive(secret: Secret): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellActive", listOf("secret" to secret))

suspend fun aria2.tellActive(keys: Set<StatusField>): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellActive", listOf("keys" to keys))

suspend fun aria2.tellActive(): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellActive", emptyList())

suspend fun aria2.tellWaiting(secret: Secret, offset: Int, num: Int, keys: Set<StatusField>): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>(
        "api.aria2.tellWaiting",
        listOf("secret" to secret, "offset" to offset, "num" to num, "keys" to keys)
    )

suspend fun aria2.tellWaiting(secret: Secret, offset: Int, num: Int): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>(
        "api.aria2.tellWaiting",
        listOf("secret" to secret, "offset" to offset, "num" to num)
    )

suspend fun aria2.tellWaiting(offset: Int, num: Int, keys: Set<StatusField>): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellWaiting", listOf("offset" to offset, "num" to num, "keys" to keys))

suspend fun aria2.tellWaiting(offset: Int, num: Int): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellWaiting", listOf("offset" to offset, "num" to num))

suspend fun aria2.tellStopped(secret: Secret, offset: Int, num: Int, keys: Set<StatusField>): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>(
        "api.aria2.tellStopped",
        listOf("secret" to secret, "offset" to offset, "num" to num, "keys" to keys)
    )

suspend fun aria2.tellStopped(secret: Secret, offset: Int, num: Int): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>(
        "api.aria2.tellStopped",
        listOf("secret" to secret, "offset" to offset, "num" to num)
    )

suspend fun aria2.tellStopped(offset: Int, num: Int, keys: Set<StatusField>): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellStopped", listOf("offset" to offset, "num" to num, "keys" to keys))

suspend fun aria2.tellStopped(offset: Int, num: Int): List<DownloadStatus> =
    sendRequest<List<DownloadStatus>>("api.aria2.tellStopped", listOf("offset" to offset, "num" to num))

suspend fun aria2.changePosition(secret: Secret, gid: Gid, pos: Int, how: PositionMethod): Int =
    sendRequest<Int>("api.aria2.changePosition", listOf("secret" to secret, "gid" to gid, "pos" to pos, "how" to how))

suspend fun aria2.changePosition(gid: Gid, pos: Int, how: PositionMethod): Int =
    sendRequest<Int>("api.aria2.changePosition", listOf("gid" to gid, "pos" to pos, "how" to how))

suspend fun aria2.changeUri(
    secret: Secret,
    gid: Gid,
    fileIndex: Int,
    delUris: List<String>,
    addUris: List<String>,
    position: Int
): UriChanges =
    sendRequest<UriChanges>(
        "api.aria2.changeUri",
        listOf(
            "secret" to secret,
            "gid" to gid,
            "fileIndex" to fileIndex,
            "delUris" to delUris,
            "addUris" to addUris,
            "position" to position
        )
    )

suspend fun aria2.changeUri(
    secret: Secret,
    gid: Gid,
    fileIndex: Int,
    delUris: List<String>,
    addUris: List<String>
): UriChanges =
    sendRequest<UriChanges>(
        "api.aria2.changeUri",
        listOf("secret" to secret, "gid" to gid, "fileIndex" to fileIndex, "delUris" to delUris, "addUris" to addUris)
    )

suspend fun aria2.changeUri(
    gid: Gid,
    fileIndex: Int,
    delUris: List<String>,
    addUris: List<String>,
    position: Int
): UriChanges =
    sendRequest<UriChanges>(
        "api.aria2.changeUri",
        listOf(
            "gid" to gid,
            "fileIndex" to fileIndex,
            "delUris" to delUris,
            "addUris" to addUris,
            "position" to position
        )
    )

suspend fun aria2.changeUri(gid: Gid, fileIndex: Int, delUris: List<String>, addUris: List<String>): UriChanges =
    sendRequest<UriChanges>(
        "api.aria2.changeUri",
        listOf("gid" to gid, "fileIndex" to fileIndex, "delUris" to delUris, "addUris" to addUris)
    )

suspend fun aria2.getOption(secret: Secret, gid: Gid): Aria2Option =
    sendRequest<Aria2Option>("api.aria2.getOption", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.getOption(gid: Gid): Aria2Option =
    sendRequest<Aria2Option>("api.aria2.getOption", listOf("gid" to gid))

suspend fun aria2.changeOption(secret: Secret, gid: Gid, options: Aria2Option): Ok =
    sendRequest<Ok>("api.aria2.changeOption", listOf("secret" to secret, "gid" to gid, "options" to options))

suspend fun aria2.changeOption(gid: Gid, options: Aria2Option): Ok =
    sendRequest<Ok>("api.aria2.changeOption", listOf("gid" to gid, "options" to options))

suspend fun aria2.getGlobalOption(secret: Secret): Aria2Option =
    sendRequest<Aria2Option>("api.aria2.getGlobalOption", listOf("secret" to secret))

suspend fun aria2.getGlobalOption(): Aria2Option =
    sendRequest<Aria2Option>("api.aria2.getGlobalOption", emptyList())

suspend fun aria2.changeGlobalOption(secret: Secret, options: Aria2Option): Ok =
    sendRequest<Ok>("api.aria2.changeGlobalOption", listOf("secret" to secret, "options" to options))

suspend fun aria2.changeGlobalOption(options: Aria2Option): Ok =
    sendRequest<Ok>("api.aria2.changeGlobalOption", listOf("options" to options))

suspend fun aria2.getGlobalStat(secret: Secret): GlobalStat =
    sendRequest<GlobalStat>("api.aria2.getGlobalStat", listOf("secret" to secret))

suspend fun aria2.getGlobalStat(): GlobalStat =
    sendRequest<GlobalStat>("api.aria2.getGlobalStat", emptyList())

suspend fun aria2.purgeDownloadResult(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.purgeDownloadResult", listOf("secret" to secret))

suspend fun aria2.purgeDownloadResult(): Ok =
    sendRequest<Ok>("api.aria2.purgeDownloadResult", emptyList())

suspend fun aria2.removeDownloadResult(secret: Secret, gid: Gid): Ok =
    sendRequest<Ok>("api.aria2.removeDownloadResult", listOf("secret" to secret, "gid" to gid))

suspend fun aria2.removeDownloadResult(gid: Gid): Ok =
    sendRequest<Ok>("api.aria2.removeDownloadResult", listOf("gid" to gid))

suspend fun aria2.getVersion(secret: Secret): Version =
    sendRequest<Version>("api.aria2.getVersion", listOf("secret" to secret))

suspend fun aria2.getVersion(): Version =
    sendRequest<Version>("api.aria2.getVersion", emptyList())

suspend fun aria2.getSessionInfo(secret: Secret): SessionId =
    sendRequest<SessionId>("api.aria2.getSessionInfo", listOf("secret" to secret))

suspend fun aria2.getSessionInfo(): SessionId =
    sendRequest<SessionId>("api.aria2.getSessionInfo", emptyList())

suspend fun aria2.shutdown(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.shutdown", listOf("secret" to secret))

suspend fun aria2.shutdown(): Ok =
    sendRequest<Ok>("api.aria2.shutdown", emptyList())

suspend fun aria2.forceShutdown(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.forceShutdown", listOf("secret" to secret))

suspend fun aria2.forceShutdown(): Ok =
    sendRequest<Ok>("api.aria2.forceShutdown", emptyList())

suspend fun aria2.saveSession(secret: Secret): Ok =
    sendRequest<Ok>("api.aria2.saveSession", listOf("secret" to secret))

suspend fun aria2.saveSession(): Ok =
    sendRequest<Ok>("api.aria2.saveSession", emptyList())

//suspend fun api.api.system.multicall(methods: null): null =
//    api.sendRequest<null>("api.api.system.multicall", listOf("methods" to methods))

suspend fun system.listMethods(): List<String> =
    sendRequest<List<String>>("api.system.listMethods", emptyList())

suspend fun system.listNotifications(): List<String> =
    sendRequest<List<String>>("api.system.listNotifications", emptyList())
//
//suspend fun api.aria2.onDownloadStart(): null =
//    api.sendRequest<null>("api.aria2.onDownloadStart", emptyList())
//
//suspend fun api.aria2.onDownloadPause(): null =
//    api.sendRequest<null>("api.aria2.onDownloadPause", emptyList())
//
//suspend fun api.aria2.onDownloadStop(): null =
//    api.sendRequest<null>("api.aria2.onDownloadStop", emptyList())
//
//suspend fun api.aria2.onDownloadComplete(): null =
//    api.sendRequest<null>("api.aria2.onDownloadComplete", emptyList())
//
//suspend fun api.aria2.onDownloadError(): null =
//    api.sendRequest<null>("api.aria2.onDownloadError", emptyList())
//
//suspend fun api.aria2.onBtDownloadComplete(): null =
//    api.sendRequest<null>("api.aria2.onBtDownloadComplete", emptyList())