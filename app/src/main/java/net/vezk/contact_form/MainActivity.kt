package net.vezk.contact_form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import net.vezk.contact_form.databinding.ActivityMainBinding
import retrofit2.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface = ApiInterface.create().getCountry()
        apiInterface.enqueue( object : Callback<List<data>>{
            override fun onResponse(call: Call<List<data>>?, response: Response<List<data>>?) {
                if(response?.body() != null){
                    val originalList: List<data> = response.body()!!
                    val newList: List<String> = originalList
                        .sortedBy { it.name.common }
                        .map { it.name.common }
                    newList.sorted()
                    val adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_spinner_item,newList)
                    binding.spCountry.adapter=adapter
                }
            }
            override fun onFailure(call: Call<List<data>>?, t: Throwable?) {}
        })

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
}


