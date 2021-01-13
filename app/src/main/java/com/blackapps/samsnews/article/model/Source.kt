package com.blackapps.samsnews.article.model

sealed class Source {
    abstract val name: String
}

object YNET : Source(){
    override val name: String
        get() = "Ynet"
}

object CNN : Source(){
    override val name: String
        get() = "CNN"

}

object Sources {
    val sources = listOf(YNET,CNN)
}