package net.vezk.contact_form


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import net.vezk.contact_form.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.vbAcept.setOnClickListener {
            if (!Validator.validText(1, binding.etEmail.text.toString())) binding.etEmail.error =
                getString(R.string.email)
            else if (!Validator.validText(2, binding.etPhone.text.toString())) binding.etPhone.error =
                getString(R.string.phone)
            else{
                val snackBar = Snackbar.make(
                    binding.clMain, getString(R.string.valide_fields),
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null)
                snackBar.show()
            }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/name/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
