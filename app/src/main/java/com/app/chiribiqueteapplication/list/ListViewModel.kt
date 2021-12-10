package com.app.chiribiqueteapplication.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.chiribiqueteapplication.model.Poi
import com.app.chiribiqueteapplication.model.PoiItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel :ViewModel (){

    private  var poisLoad :MutableLiveData <ArrayList<PoiItem>> = MutableLiveData()
    val onpoisLoaded:LiveData<ArrayList<PoiItem>> = poisLoad

    fun loadMockPoisfromJson(poisString: InputStream?) {
        val poisString=poisString?.bufferedReader().use { it?.readText()!! }
        val gson = Gson()
        poisLoad.value= gson.fromJson(poisString, Poi::class.java)

    }

}