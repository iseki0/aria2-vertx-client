@file:Suppress("unused")

package api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

data class Secret(@JsonValue val key: String)

data class Torrent(@JsonValue val base64: String)

data class Metalink(@JsonValue val base64: String)


data class Gid(@JsonValue val value: String)

data class Ok(@JsonValue val ok: String = "Ok")

@JsonIgnoreProperties(ignoreUnknown = true)
data class DownloadStatus(
    val gid: Gid? = null,
    val status: Status? = null,
    val totalLength: Long? = null,
    val completedLength: Long? = null,
    val uploadLength: Long? = null,
    val bitfield: BitField? = null,
    val downloadSpeed: Long? = null,
    val uploadSpeed: Long? = null,
    val infoHash: String? = null,
    val numSeeders: Int? = null,
    val seeder: Boolean? = null,
    val pieceLength: Long? = null,
    val numPieces: Long? = null,
    val connections: Int? = null,
    val errorCode: ErrorCode? = null,
    val errorMessage: String? = null,
    val followedBy: List<Gid>? = null,
    val following: List<Gid>? = null,
    val belongsTo: Gid? = null,
    val dir: String? = null,
    val files: List<FileInfo>? = null,
    val bittorrent: BitTorrent? = null,
    val verifiedLength: Long? = null,
    val verifyIntegrityPending: Boolean? = null

) {
    enum class Status(@JsonValue val text: String) {
        ACTIVE("active"),
        WAITING("waiting"),
        PAUSED("paused"),
        ERROR("error"),
        COMPLETE("complete"),
        REMOVED("removed")
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class BitTorrent(
        val announceList: List<String>? = null,
        val comment: String? = null,
        val creationDate: Int? = null,
        val mode: Mode? = null
    ) {
        enum class Mode(@JsonValue val text: String) {
            SINGLE("single"), MULTI("multi")
        }
    }

    class BitFieldDeserializer : StdDeserializer<BitField>(BitField::class.java) {
        override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): BitField? {
            return p?.readValueAsTree<JsonNode>()?.takeIf { it.isTextual }?.asText()
                ?.let { s ->
                    IntArray(s.length.let { it / 8 + if (it % 8 != 0) 1 else 0 }) { p ->
                        var buf = 0
                        repeat(8) {
                            val chPos = p * 8 + it
                            val shlPos = 32 - it * 4
                            val ch = s[chPos]
                            buf += when (ch) {
                                in '0'..'9' -> ch - '0'
                                in 'a'..'f' -> ch - 'a' + 10
                                in 'A'..'F' -> ch - 'A' + 10
                                else -> error("unknown hex:$s")
                            } shl shlPos
                        }
                        buf
                    }
                }?.let(::BitField)
        }
    }

    @JsonDeserialize(using = BitFieldDeserializer::class)
    data class BitField(val bits: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as BitField

            if (!bits.contentEquals(other.bits)) return false

            return true
        }

        override fun hashCode(): Int {
            return bits.contentHashCode()
        }
    }
}

data class ErrorCode(@JsonValue val code: Int = 0)

data class UriStatus(val uri: String, val status: Status) {
    enum class Status(@JsonValue val text: String) {
        WAITING("waiting"),
        USED("used"),
    }
}

data class Version(val version: String, val enabledFeatures: List<String>)

data class SessionId(val sessionId: String)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GlobalStat(
    val downloadSpeed: Long,
    val uploadSpeed: Long,
    val numActive: Int,
    val numWaiting: Int,
    val numStopped: Int,
    val numStoppedTotal: Int
)

data class UriChanges(val deleted: Int, val added: Int)

@JsonIgnoreProperties(ignoreUnknown = true)
data class PeerInfo(
    val peerId: Int? = null,
    val ip: Int? = null,
    val port: Int? = null,
    val bitfield: DownloadStatus.BitField? = null,
    val amChoking: Boolean? = null,
    val peerChoking: Boolean? = null,
    val downloadSpeed: Long? = null,
    val uploadSpeed: Long? = null,
    val seeder: Boolean? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ServerInfoList(val index: Int, val servers: List<Info>) {
    data class Info(
        val uri: String? = null,
        val currentUri: String? = null,
        val downloadSpeed: Int? = null
    )
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class FileInfo(
    val index: Int? = null,
    val path: String? = null,
    val length: Long? = null,
    val completedLength: Long? = null,
    val selected: Boolean? = null,
    val uris: List<String>? = null
)

enum class PositionMethod {
    POS_SET,
    POS_CUR,
    POS_END
}

enum class StatusField(@JsonValue val value: String) {
    GID("gid"),
    STATUS("status"),
    TOTAL_LENGTH("totalLength"),
    COMPLETED_LENGTH("completedLength"),
    UPLOAD_LENGTH("uploadLength"),
    BITFIELD("bitfield"),
    DOWNLOAD_SPEED("downloadSpeed"),
    INFO_HASH("infoHash"),
    NUM_SEEDERS("numSeeders"),
    SEEDER("seeder"),
    PIECE_LENGTH("pieceLength"),
    NUM_PIECES("numPieces"),
    CONNECTIONS("connections"),
    ERROR_CODE("errorCode"),
    ERROR_MESSAGE("errorMessage"),
    FOLLOWED_BY("followedBy"),
    FOLLOWING("following"),
    BELONGS_TO("belongsTo"),
    DIR("dir"),
    FILES("files"),
    BITTORRENT_ANNOUNCE_LIST("bittorrent.announceList"),
    BITTORRENT_COMMENT("bittorrent.comment"),
    BITTORRENT_CREATION_DATE("bittorrent.creationDate"),
    BITTORRENT_MODE("bittorrent.mode"),
    BITTORRENT_INFO_NAME("bittorrent.info.name"),
    VERIFIED_LENGTH("verifiedLength"),
    VERIFY_INTEGRITY_PENDING("verifyIntegrityPending")
}
