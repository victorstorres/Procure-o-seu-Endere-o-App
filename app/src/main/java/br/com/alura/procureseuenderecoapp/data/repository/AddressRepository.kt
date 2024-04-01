package br.com.alura.procureseuenderecoapp.data.repository

import br.com.alura.procureseuenderecoapp.data.model.AddressResponse
import br.com.alura.procureseuenderecoapp.data.service.RetrofitInitialize

class AddressRepository {

    private val addressService = RetrofitInitialize.initializeRetrofit()

    suspend fun findAddress(cep: String): AddressResponse{
        return addressService.findAddress(cep)
    }

}