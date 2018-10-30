package com.gavin.kotlindependencyinjection.base

/**
 * description:
 * Created by liNan on 2018/10/15 15:31

 */
sealed class Resource<T> {
    companion object {
        fun <T> create(error: Throwable): ErrorResource<T> {
            return ErrorResource(error.message ?: "unknown error")
        }

        fun <T> create(bean: T?): Resource<T> {
            return if (bean == null) {
                EmptyResource()
            } else {
                SuccessResource(bean)
            }
        }
    }
}

class EmptyResource<T> : Resource<T>()

data class SuccessResource<T>(val body: T) : Resource<T>()

data class ErrorResource<T>(val errorMessage: String) : Resource<T>()