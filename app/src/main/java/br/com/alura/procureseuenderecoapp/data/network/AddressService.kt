package br.com.alura.procureseuenderecoapp.data.network

import br.com.alura.procureseuenderecoapp.data.model.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {

    @GET("{cep}/json")
    suspend fun findAddress(@Path("cep") cep: String): AddressResponse

}