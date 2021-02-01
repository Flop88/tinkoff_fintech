package ru.mvlikhachev.tinkoff_fintech

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*
import ru.mvlikhachev.tinkoff_fintech.model.Model
import ru.mvlikhachev.tinkoff_fintech.repository.Repository


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var cacheModel : ArrayList<Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()

        previousButton.setOnClickListener {
            loadPreviousImage()
        }

        nextButton.setOnClickListener {
            loadNextImage()
        }
    }

    private fun initialization() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        cacheModel = ArrayList()
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        loadNextImage()
    }

    private fun loadNextImage() {

        if (isNetworkAvailable()) {
            viewModel.getModel()
            viewModel.myResponse.observe(this, { response ->
                val requestOptions = RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                if (response.isSuccessful) {
                    val media = response.body()?.gifURL.toString()
                    if (media !== null) {
                        Glide.with(this)
                                .load(media)
                                .apply(requestOptions)
                                .into(loadImageView)
                    }
                }
            })
        } else {
            loadImageView.setImageResource(R.drawable.ic_baseline_signal_cellular_off_24)
        }
    }


    private fun loadPreviousImage() {

        }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }

}