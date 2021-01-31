package ru.mvlikhachev.tinkoff_fintech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import ru.mvlikhachev.tinkoff_fintech.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()


    }

    private fun initialization() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getModel()
        loadImage()
    }

    private fun loadImage() {
        viewModel.myResponse.observe(this, { response ->
            val media = response.gifURL.toString()
            if (media !== null) {
                Glide.with(this)
                        .load(media)
                        .into(loadImageView)
            } else {
                loadImageView.setImageResource(R.drawable.ic_launcher_background)
            }
        })
    }


}