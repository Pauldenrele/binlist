package com.example.binlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.binlist.Model.Numbre
import com.example.binlist.Model.Scheme
import com.example.binlist.Model.brand
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*


class MainActivity : AppCompatActivity() {


    private var disposable: Disposable? = null
     val apiInterface: ApiInterface? = null
    private var myCompositeDisposable: CompositeDisposable? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_search.setOnClickListener {
            if (edit_search.text.toString().isNotEmpty()) {
               loadData(edit_search.text.toString())
            }
        }




    }

    private val ApiServe by lazy {
        ApiInterface.create()
    }



    private fun loadData(searchString: String) {
        ApiServe.getScheme("https://lookup.binlist.net/${searchString}").enqueue(object :Callback<Scheme>{
            override fun onFailure(call: Call<Scheme>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Failed" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Scheme>, response: Response<Scheme>) {
                  val sub = response.body()
                txt_search_scheme.text = "${sub!!.scheme}"
                Toast.makeText(this@MainActivity , " response ${sub!!.scheme}" , Toast.LENGTH_LONG).show()

            }

        })



        ApiServe.getBrand("https://lookup.binlist.net/${searchString}").enqueue(object :Callback<brand>{
            override fun onFailure(call: Call<brand>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Failed" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<brand>, response: Response<brand>) {
                val sub = response.body()
                txt_search_brand.text = "${sub!!.brand}"
                Toast.makeText(this@MainActivity , " brand ${sub!!.brand}" , Toast.LENGTH_LONG).show()

            }

        })



        ApiServe.getNumbre("https://lookup.binlist.net/${searchString}").enqueue(object :Callback<Numbre>{
            override fun onFailure(call: Call<Numbre>, t: Throwable) {
                Toast.makeText(this@MainActivity , "Failed" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Numbre>, response: Response<Numbre>) {
                val sub = response.body()
                txt_search_number.text = "${sub!!.length}"
                txt_search_luhn.text = "${sub!!.luhn}"
                Toast.makeText(this@MainActivity , " brand ${sub!!.length}" , Toast.LENGTH_LONG).show()

            }

        })



    }



}











