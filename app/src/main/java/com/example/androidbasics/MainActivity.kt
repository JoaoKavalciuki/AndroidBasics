package com.example.androidbasics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasics.models.PcComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pcComponentAdapter : PcComponentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSource()
    }

    private fun addDataSource() {
        val dataSource = DataSource.createDataSet()

        this.pcComponentAdapter.setDataSet(dataSource)
    }

    private fun initRecyclerView(){
        this.pcComponentAdapter = PcComponentAdapter{ pcComponent ->
            openLink(pcComponent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = this.pcComponentAdapter
    }

    private fun openLink(pcComponent: PcComponent){
        val url = Intent(Intent.ACTION_VIEW, Uri.parse(pcComponent.buyLink))
        startActivity(url)
    }
}
