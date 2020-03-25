package api

import com.fasterxml.jackson.annotation.JsonProperty


@Suppress("unused")
class Aria2Option {

    @JsonProperty("all-proxy")
    var allProxy: String? = null

    @JsonProperty("all-proxy-passwd")
    var allProxyPasswd: String? = null

    @JsonProperty("all-proxy-user")
    var allProxyUser: String? = null

    @JsonProperty("allow-overwrite")
    var allowOverwrite: String? = null

    @JsonProperty("allow-piece-length-change")
    var allowPieceLengthChange: String? = null

    @JsonProperty("always-resume")
    var alwaysResume: String? = null

    @JsonProperty("async-dns")
    var asyncDns: String? = null

    @JsonProperty("auto-file-renaming")
    var autoFileRenaming: String? = null

    @JsonProperty("bt-enable-hook-after-hash-check")
    var btEnableHookAfterHashCheck: String? = null

    @JsonProperty("bt-enable-lpd")
    var btEnableLpd: String? = null

    @JsonProperty("bt-exclude-tracker")
    var btExcludeTracker: String? = null

    @JsonProperty("bt-external-ip")
    var btExternalIp: String? = null

    @JsonProperty("bt-force-encryption")
    var btForceEncryption: String? = null

    @JsonProperty("bt-hash-check-seed")
    var btHashCheckSeed: String? = null

    @JsonProperty("bt-load-saved-metadata")
    var btLoadSavedMetadata: String? = null

    @JsonProperty("bt-max-peers")
    var btMaxPeers: String? = null

    @JsonProperty("bt-metadata-only")
    var btMetadataOnly: String? = null

    @JsonProperty("bt-min-crypto-level")
    var btMinCryptoLevel: String? = null

    @JsonProperty("bt-prioritize-piece")
    var btPrioritizePiece: String? = null

    @JsonProperty("bt-api.remove-unselected-file")
    var btRemoveUnselectedFile: String? = null

    @JsonProperty("bt-request-peer-speed-limit")
    var btRequestPeerSpeedLimit: String? = null

    @JsonProperty("bt-require-crypto")
    var btRequireCrypto: String? = null

    @JsonProperty("bt-save-metadata")
    var btSaveMetadata: String? = null

    @JsonProperty("bt-seed-unverified")
    var btSeedUnverified: String? = null

    @JsonProperty("bt-stop-timeout")
    var btStopTimeout: String? = null

    @JsonProperty("bt-tracker")
    var btTracker: String? = null

    @JsonProperty("bt-tracker-connect-timeout")
    var btTrackerConnectTimeout: String? = null

    @JsonProperty("bt-tracker-interval")
    var btTrackerInterval: String? = null

    @JsonProperty("bt-tracker-timeout")
    var btTrackerTimeout: String? = null

    @JsonProperty("check-integrity")
    var checkIntegrity: String? = null

    @JsonProperty("checksum")
    var checksum: String? = null

    @JsonProperty("conditional-get")
    var conditionalGet: String? = null

    @JsonProperty("connect-timeout")
    var connectTimeout: String? = null

    @JsonProperty("content-disposition-default-utf8")
    var contentDispositionDefaultUtf8: String? = null

    @JsonProperty("continue")
    var `continue`: String? = null

    @JsonProperty("dir")
    var dir: String? = null

    @JsonProperty("dry-run")
    var dryRun: String? = null

    @JsonProperty("enable-http-keep-alive")
    var enableHttpKeepAlive: String? = null

    @JsonProperty("enable-http-pipelining")
    var enableHttpPipelining: String? = null

    @JsonProperty("enable-mmap")
    var enableMmap: String? = null

    @JsonProperty("enable-peer-exchange")
    var enablePeerExchange: String? = null

    @JsonProperty("file-allocation")
    var fileAllocation: String? = null

    @JsonProperty("follow-metalink")
    var followMetalink: String? = null

    @JsonProperty("follow-torrent")
    var followTorrent: String? = null

    @JsonProperty("force-save")
    var forceSave: String? = null

    @JsonProperty("ftp-passwd")
    var ftpPasswd: String? = null

    @JsonProperty("ftp-pasv")
    var ftpPasv: String? = null

    @JsonProperty("ftp-proxy")
    var ftpProxy: String? = null

    @JsonProperty("ftp-proxy-passwd")
    var ftpProxyPasswd: String? = null

    @JsonProperty("ftp-proxy-user")
    var ftpProxyUser: String? = null

    @JsonProperty("ftp-reuse-connection")
    var ftpReuseConnection: String? = null

    @JsonProperty("ftp-type")
    var ftpType: String? = null

    @JsonProperty("ftp-user")
    var ftpUser: String? = null

    @JsonProperty("gid")
    var gid: String? = null

    @JsonProperty("hash-check-only")
    var hashCheckOnly: String? = null

    @JsonProperty("header")
    var header: String? = null

    @JsonProperty("http-accept-gzip")
    var httpAcceptGzip: String? = null

    @JsonProperty("http-auth-challenge")
    var httpAuthChallenge: String? = null

    @JsonProperty("http-no-cache")
    var httpNoCache: String? = null

    @JsonProperty("http-passwd")
    var httpPasswd: String? = null

    @JsonProperty("http-proxy")
    var httpProxy: String? = null

    @JsonProperty("http-proxy-passwd")
    var httpProxyPasswd: String? = null

    @JsonProperty("http-proxy-user")
    var httpProxyUser: String? = null

    @JsonProperty("http-user")
    var httpUser: String? = null

    @JsonProperty("https-proxy")
    var httpsProxy: String? = null

    @JsonProperty("https-proxy-passwd")
    var httpsProxyPasswd: String? = null

    @JsonProperty("https-proxy-user")
    var httpsProxyUser: String? = null

    @JsonProperty("index-out")
    var indexOut: String? = null

    @JsonProperty("lowest-speed-limit")
    var lowestSpeedLimit: String? = null

    @JsonProperty("max-connection-per-server")
    var maxConnectionPerServer: String? = null

    @JsonProperty("max-download-limit")
    var maxDownloadLimit: String? = null

    @JsonProperty("max-file-not-found")
    var maxFileNotFound: String? = null

    @JsonProperty("max-mmap-limit")
    var maxMmapLimit: String? = null

    @JsonProperty("max-resume-failure-tries")
    var maxResumeFailureTries: String? = null

    @JsonProperty("max-tries")
    var maxTries: String? = null

    @JsonProperty("max-upload-limit")
    var maxUploadLimit: String? = null

    @JsonProperty("metalink-base-uri")
    var metalinkBaseUri: String? = null

    @JsonProperty("metalink-enable-unique-protocol")
    var metalinkEnableUniqueProtocol: String? = null

    @JsonProperty("metalink-language")
    var metalinkLanguage: String? = null

    @JsonProperty("metalink-location")
    var metalinkLocation: String? = null

    @JsonProperty("metalink-os")
    var metalinkOs: String? = null

    @JsonProperty("metalink-preferred-protocol")
    var metalinkPreferredProtocol: String? = null

    @JsonProperty("metalink-version")
    var metalinkVersion: String? = null

    @JsonProperty("min-split-size")
    var minSplitSize: String? = null

    @JsonProperty("no-file-allocation-limit")
    var noFileAllocationLimit: String? = null

    @JsonProperty("no-netrc")
    var noNetrc: String? = null

    @JsonProperty("no-proxy")
    var noProxy: String? = null

    @JsonProperty("out")
    var out: String? = null

    @JsonProperty("parameterized-uri")
    var parameterizedUri: String? = null

    @JsonProperty("api.pause")
    var pause: String? = null

    @JsonProperty("api.pause-metadata")
    var pauseMetadata: String? = null

    @JsonProperty("piece-length")
    var pieceLength: String? = null

    @JsonProperty("proxy-method")
    var proxyMethod: String? = null

    @JsonProperty("realtime-chunk-checksum")
    var realtimeChunkChecksum: String? = null

    @JsonProperty("referer")
    var referer: String? = null

    @JsonProperty("remote-time")
    var remoteTime: String? = null

    @JsonProperty("api.remove-control-file")
    var removeControlFile: String? = null

    @JsonProperty("retry-wait")
    var retryWait: String? = null

    @JsonProperty("reuse-uri")
    var reuseUri: String? = null

    @JsonProperty("rpc-save-upload-metadata")
    var rpcSaveUploadMetadata: String? = null

    @JsonProperty("seed-ratio")
    var seedRatio: String? = null

    @JsonProperty("seed-time")
    var seedTime: String? = null

    @JsonProperty("select-file")
    var selectFile: String? = null

    @JsonProperty("split")
    var split: String? = null

    @JsonProperty("ssh-host-key-md")
    var sshHostKeyMd: String? = null

    @JsonProperty("stream-piece-selector")
    var streamPieceSelector: String? = null

    @JsonProperty("timeout")
    var timeout: String? = null

    @JsonProperty("uri-selector")
    var uriSelector: String? = null

    @JsonProperty("use-head")
    var useHead: String? = null

    @JsonProperty("user-agent")
    var userAgent: String? = null

}