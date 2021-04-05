package com.daffa.acehfoods

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAcehfoods: RecyclerView
    private var list: ArrayList<Acehfood> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvAcehfoods = findViewById(R.id.rv_acehfoods)
        rvAcehfoods.setHasFixedSize(true)

        list.addAll(AcehfoodsData.listData)
        showRecyclerlist()
    }

    private fun showSelectedFood(food: Acehfood) {
        val moveWithDataIntent = Intent(this, DetailAcehfood::class.java)
        moveWithDataIntent.putExtra(DetailAcehfood.EXTRA_NAME, food.name)
        moveWithDataIntent.putExtra(DetailAcehfood.EXTRA_DETAIL, food.detail)
        moveWithDataIntent.putExtra(DetailAcehfood.EXTRA_PHOTO, food.photo)
        startActivity(moveWithDataIntent)
    }

    private fun showRecyclerlist(){
        rvAcehfoods.layoutManager = LinearLayoutManager(this)
        val listAcehfoodAdapter = ListAcehfoodAdapter(list)
        rvAcehfoods.adapter = listAcehfoodAdapter

        listAcehfoodAdapter.setOnItemClickCallback(object : ListAcehfoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Acehfood) {
                showSelectedFood(data)
            }
        })
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private var title: String = "Aceh Foods Kuliner"

    override fun onCreateOptionsMenu (menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.img_profil -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
    }

}