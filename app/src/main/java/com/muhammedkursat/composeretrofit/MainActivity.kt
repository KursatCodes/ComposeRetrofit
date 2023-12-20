package com.muhammedkursat.composeretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammedkursat.composeretrofit.model.CrytoModel
import com.muhammedkursat.composeretrofit.service.CryptoAPI
import com.muhammedkursat.composeretrofit.ui.theme.ComposeRetrofitTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRetrofitTheme {
                MainScreen()
            }

            //https://raw.githubusercontent.com/
            // KursatCodes/API-Files/master/cryptoApi.json
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val BASE_URL="https://raw.githubusercontent.com/"
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(CryptoAPI::class.java)
    val call = retrofit.getDatalar()
    call.enqueue(object :Callback<List<CrytoModel>>{
        override fun onResponse(
            call: Call<List<CrytoModel>>,
            response: Response<List<CrytoModel>>
        ) {
            if(response.isSuccessful){
                response.body()?.let {
                    it.forEach(){
                        println(it.currency)
                    }
                }
            }
        }

        override fun onFailure(call: Call<List<CrytoModel>>, t: Throwable) {
            t.printStackTrace()
        }

    })
    Scaffold (topBar = {MyBar()}){
        var myit=it
    }
/*Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var text1 = remember {
            mutableStateOf("Selam")
        }
        Text(text = text1.value, fontSize = 35.sp)
        Spacer(modifier = Modifier.padding(7.dp))
        Text(text = "Aleykum", fontSize = 35.sp, modifier = Modifier.clickable {
            if(text1.value.equals("Selam")){
                text1.value="Selam Sana"
            }else{
                text1.value="Selam"
            }
        })
    }*/
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBar(){

    TopAppBar(title = {Text(text = "Retrofit Crypto")},
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green),
        modifier = Modifier.background(color = Color.Blue))
}
@Composable
fun Tittle(){

}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    ComposeRetrofitTheme {
        MainScreen()
    }
}