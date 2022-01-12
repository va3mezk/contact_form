package net.vezk.contact_form.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
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

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.VMresponse.observe(this, Observer {
            val adapter = ArrayAdapter(this@MainActivity, R.layout.spinner_item, it)
            binding.spCountry.adapter = adapter
        })

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


