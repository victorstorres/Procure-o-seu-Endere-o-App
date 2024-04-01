package br.com.alura.procureseuenderecoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import br.com.alura.procureseuenderecoapp.data.repository.AddressRepository
import br.com.alura.procureseuenderecoapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tryFindCep()


    }


    fun tryFindCep(){
        binding.mainButtonSearch.setOnClickListener {
            val cep = binding.mainTextFieldCepInput.text.toString()
            lifecycleScope.launch {
                try {
                    AddressRepository().findAddress(cep).let{ adress ->
                        binding.apply {
                            mainTextFieldCepInput.setText(adress.cep)
                            mainTextFieldInputLogradouro.setText(adress.logradouro)
                            mainTextFieldInputComplemento.setText(adress.complemento)
                            mainTextFieldInputBairro.setText(adress.bairro)
                            mainTextFieldInputLocalidade.setText(adress.localidade)
                            mainTextFieldInputUf.setText(adress.uf)
                        }

                    }

                }catch (e: Exception){
                    Log.e("Erro", "${e.message}")
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Tente Novamente")
                        .setMessage("Não conseguimos achar o cep")
                        .setPositiveButton("Continue"){ _, _ ->   }
                        .show()
                }
            }
        }


    }

}