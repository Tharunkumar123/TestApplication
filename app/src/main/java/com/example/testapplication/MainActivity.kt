package com.example.testapplication


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithactiveinactive.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        val modelClass:ArrayList<ModelClass> =ArrayList()
        for (i in 0..100){
            modelClass.add(ModelClass(0))
        }
        linearLayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
        recyclerView.adapter=AdapterClass(modelClass)


    }


}
