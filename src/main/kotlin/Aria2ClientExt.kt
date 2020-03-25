@file:Suppress("unused")

import io.vertx.core.Vertx

fun Vertx.createAria2Client(aria2ClientOptions: Aria2ClientOptions) =
    Aria2Client(this, aria2ClientOptions)