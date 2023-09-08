package com.example.crystallball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.crystallball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private val words = arrayOf("ፍቅር", "Hate", "Okwagala", "友達", "Studies", "Màthair", "Дружба", "Деньги", "Семья")
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this).load(R.drawable.kkk).into(binding.gitView)
        binding.buttonResult.setOnClickListener {
            changeText()
            handler.postDelayed({
                stopChangeText()
                takeRandomPredict()
            }, 1500)
        }
    }

    fun takeRandomPredict() {
        val array = predict()
        val randomPredict = (0 until array.size).random()
        binding.textResult.text = array[randomPredict]
    }

    private fun changeText() {
        binding.textResult.text = words[currentIndex]
        currentIndex = (currentIndex + 1) % words.size
        handler.postDelayed({
            changeText()
        }, 100)
    }

    private fun stopChangeText() {
        handler.removeCallbacksAndMessages(null)
    }

    fun predict(): Array<String> {
        return arrayOf(
            "В ближайшее время вы получите хорошие новости.",
            "Предстоит период перемен и изменений в вашей жизни.",
            "Возможно, вы встретите свою вторую половинку в ближайшее время.",
            "Будьте осторожны в своих финансовых делах, может быть нестабильный период.",
            "Ваше здоровье будет укрепляться и улучшаться.",
            "Вам предстоит принять важное решение, не торопитесь и обдумайте все внимательно.",
            "Возможен переезд или длительная поездка в ближайшее время.",
            "Ваше творческое начинание принесет вам успех и признание.",
            "Старайтесь не доверять всем людям, будьте более осторожны в общении.",
            "Вам предстоит испытание, но вы справитесь с ним благодаря своей силе и уверенности."
        )
    }
}