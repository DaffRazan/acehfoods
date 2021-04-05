package com.daffa.acehfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailAcehfood : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra name"
        const val EXTRA_DETAIL = "extra detail"
        const val EXTRA_PHOTO = "extra photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_acehfood)
        setActionBarTitle(title)

        val img_data_received: ImageView = findViewById(R.id.img_data_received)
        val tv_name_received: TextView = findViewById(R.id.tv_name_received)
        val tv_detail_received: TextView = findViewById(R.id.tv_detail_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        Glide.with(this)
            .load(photo)
            .into(img_data_received)

        val nameText = "$name"
        val detailText = "$detail"

        tv_name_received.text = nameText
        tv_detail_received.text = detailText

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private var title: String = "Food Detail"
}