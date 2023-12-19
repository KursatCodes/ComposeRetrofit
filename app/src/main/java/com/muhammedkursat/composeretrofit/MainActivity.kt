package com.muhammedkursat.composeretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammedkursat.composeretrofit.ui.theme.ComposeRetrofitTheme

class MainActivity : ComponentActivity() {

    private val BASE_URL="https://github.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            //https://github.com/
            // KursatCodes/API-Files
        }
    }
}
@Composable
fun MainScreen(){
    Column(modifier = Modifier.fillMaxSize(),
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
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
        MainScreen()
}