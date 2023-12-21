@file:OptIn(ExperimentalMaterial3Api::class)

package com.muhammedkursat.composeretrofit
/*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
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

    var cryptoList= remember {
        mutableListOf<CrytoModel>()
    }
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
                    cryptoList.addAll(it)
                }
            }
        }
        override fun onFailure(call: Call<List<CrytoModel>>, t: Throwable) {
            t.printStackTrace()
        }
    })
    Scaffold(topBar = { AppBar() }) {
        Surface(color = MaterialTheme.colorScheme.surface) {
            CryptoList(cryptos = cryptoList)
        }
    }
    /*Scaffold (topBar = { AppBar() }){
        Surface {
            CryptoList(cryptos = cryptoList)

        }

    }*/

}
@Composable
fun CryptoList(cryptos: List<CrytoModel>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}
/*LazyColumn{
        /*items(crytos){item ->
        MyColumn(crpto = item)
        }*/
        items(crytos) { crypto ->
            MyColumn(crpto = crypto)
        }
    }
}*/
@Composable
fun CryptoRow(crypto: CrytoModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = crypto.currency,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = crypto.price,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(2.dp))
    }
}
@Composable
fun MyColumn(crpto:CrytoModel){
    /*Column (modifier = Modifier.fillMaxWidth()){
        Text(text = crpto.price)
        Text(text = crpto.currency)
    }*/
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = crpto.currency,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = crpto.price,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(2.dp))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){

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

    */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.muhammedkursat.composeretrofit.model.CrytoModel
import com.muhammedkursat.composeretrofit.service.CryptoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    private val BASE_URL = "https://raw.githubusercontent.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
                MainScreen()

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun MainScreen() {
        var cryptoModels = remember { mutableStateListOf<CrytoModel>() }

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)

        val call = retrofit.getDatalar()

        call.enqueue(object: Callback<List<CrytoModel>> {
            override fun onFailure(call: Call<List<CrytoModel>>, t: Throwable) {
                t.printStackTrace()
            }
            override fun onResponse(
                call: Call<List<CrytoModel>>,
                response: Response<List<CrytoModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        cryptoModels.addAll(it)
                    }
                }
            }
        })

        Scaffold() {
            Surface(color = MaterialTheme.colorScheme.surface) {
                CryptoList(cryptos = cryptoModels)
            }
        }
    }
}

class ComposeRetroTheme(function: () -> Unit) {

}

@Composable
fun CryptoList(cryptos: List<CrytoModel>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}

@Composable
fun CryptoRow(crypto: CrytoModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.surface)) {
        Text(text = crypto.currency,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = crypto.price,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(2.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}