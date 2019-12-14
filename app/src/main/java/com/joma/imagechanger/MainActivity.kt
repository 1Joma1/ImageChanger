package com.joma.imagechanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button
    private var index: Int = 0
    private val url1: String =
        "https://www.tesla.com/sites/default/files/modelsx-new/social/model-x-social.jpg"
    private val url2: String = "https://images.barrons.com/im-118311?width=620&size=1.5"
    private val url3: String =
        "https://www.extremetech.com/wp-content/uploads/2019/11/Cybertruck-4-640x354.jpg"
    private val url4: String =
        "https://www.teslarati.com/wp-content/uploads/2019/06/red-roadster-model-y-1-1024x567.jpg"
    private val url5: String =
        "https://cdn.cnn.com/cnnnext/dam/assets/191114132216-tesla-vehicles-1023-super-tease.jpg"
    private val mutableList: List<String> = mutableListOf(url1, url2, url3, url4, url5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initAction()
    }

    private fun initView() {
        image = findViewById(R.id.img_main)
        btnNext = findViewById(R.id.btn_next)
        btnPrev = findViewById(R.id.btn_prev)
    }

    private fun initAction() {
        loadImage(index)
        btnNext.setOnClickListener { loadImage(++index) }
        btnPrev.setOnClickListener { loadImage(--index) }
    }

    private fun loadImage(index: Int) {
        Picasso.get().load(mutableList[index]).into(image)
        when (index) {
            0 -> btnPrev.visibility = View.GONE
            mutableList.size - 1 -> btnNext.visibility = View.GONE
            else -> {
                btnNext.visibility = View.VISIBLE
                btnPrev.visibility = View.VISIBLE
            }
        }
    }
}
