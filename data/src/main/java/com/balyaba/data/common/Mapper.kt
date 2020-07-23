package com.balyaba.data.common


interface Mapper<S, D> {

    fun mapFromObject(source: S): D

    fun mapFromObjects(sources: Collection<S>) = sources.map { mapFromObject(it) }
}