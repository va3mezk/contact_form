package net.vezk.contact_form.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.*
import com.google.android.material.snackbar.Snackbar
import net.vezk.contact_form.*
import net.vezk.contact_form.data.ApiInterface
import net.vezk.contact_form.databinding.ActivityMainBinding
import net.vezk.contact_form.domain.*
import net.vezk.contact_form.utils.Validator
import retrofit2.*

/**
 * @author Victor Escalante
 * Noviembre 2021
 **/

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = ApiInterface.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(
                this,
                MainViewModelFactory(MainRepository(retrofitService))
            )[MainViewModel::class.java]
        viewModel.countryList.observe(this, Observer {
            val adapter = ArrayAdapter(this@MainActivity, R.layout.spinner_item, it)
            binding.spCountry.adapter = adapter
        })
        viewModel.getCountry()

        binding.vbAccept.setOnClickListener {
            if (!Validator.validText(1, binding.etEmail.text.toString()))
                binding.etEmail.error = getString(R.string.email_invalid)
            else if (!Validator.validText(2, binding.etPhone.text.toString()))
                binding.etPhone.error = getString(R.string.phone_invalid)
            else {
                val snackBar = Snackbar.make(
                    binding.clMain, getString(R.string.validField),
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null)
                snackBar.show()
            }
        }
    }
}


