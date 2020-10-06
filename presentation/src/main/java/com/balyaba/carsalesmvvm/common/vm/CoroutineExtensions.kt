package com.balyaba.carsalesmvvm.common.vm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


fun CoroutineScope.launchOperation(
    operationBuilderFunc: CoroutineWorkBuilder.() -> Unit
) = this.launch {
    val builder = CoroutineWorkBuilder().apply { operationBuilderFunc() }
    try {
        builder.progressFunction?.invoke(this)
        builder.workFunction?.invoke(this)
    } catch (error: Throwable) {
        builder.errorFunction?.invoke(this, error)
    }
}

class CoroutineWorkBuilder {
    internal var progressFunction: (suspend CoroutineScope.() -> Unit)? = null
    internal var workFunction: (suspend CoroutineScope.() -> Unit)? = null
    internal var errorFunction: (suspend CoroutineScope.(Throwable) -> Unit)? = null
}

fun CoroutineWorkBuilder.progress(progressFunc: suspend CoroutineScope.() -> Unit) {
    this.progressFunction = progressFunc
}

fun CoroutineWorkBuilder.work(workFunc: suspend CoroutineScope.() -> Unit) {
    this.workFunction = workFunc
}

fun CoroutineWorkBuilder.error(errorFunc: suspend CoroutineScope.(Throwable) -> Unit) {
    this.errorFunction = errorFunc
}