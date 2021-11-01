package kkt.sai.composetodoapp.entity

import  kkt.sai.composetodoapp.entity.OutCome.Success
import kotlinx.coroutines.flow.Flow

sealed class OutCome<out R> {

    data class Success<out T>(val data: T) : OutCome<T>()
    data class Error(val exception: String?) : OutCome<Nothing>()
    object Loading : OutCome<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [OutCome] is of type [Success] & holds non-null [Success.data].
 */
val OutCome<*>.succeeded
    get() = this is Success && data != null