package com.sdk.quran.common

abstract class Callback<T> {
    abstract fun success(volumes: List<T>)
    abstract fun failure(e: Throwable)
}