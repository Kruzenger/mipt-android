package com.example.myapplication.data

import com.example.myapplication.model.MarsPhoto
import com.example.myapplication.network.MarsApiService

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(
    private val marsApiService: MarsApiService
) : MarsPhotosRepository {
    var marsPhotos: List<MarsPhoto>? = null

    override suspend fun getMarsPhotos(): List<MarsPhoto> {

        if(marsPhotos == null){
            marsPhotos = marsApiService.getPhotos()
        }
        return marsPhotos as List<MarsPhoto>
    }
}