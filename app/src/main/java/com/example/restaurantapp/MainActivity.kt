package com.example.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantapp.ui.theme.BlackTextColor
import com.example.restaurantapp.ui.theme.CardItemBg
import com.example.restaurantapp.ui.theme.IconColor
import com.example.restaurantapp.ui.theme.Orange500
import com.example.restaurantapp.ui.theme.RestaurantAppTheme
import com.example.restaurantapp.ui.theme.Typography
import com.example.restaurantapp.ui.theme.Yellow200
import com.example.restaurantapp.ui.theme.Yellow500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantAppTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    ) {
        Column {
            Header()

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(156.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Yellow200) //add material
                    .padding(24.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = BlackTextColor,
                                fontStyle = Typography.bodyLarge.fontStyle)) {
                                append("The Fastest In\n" + "Delivery")
                            }

                            withStyle(style = SpanStyle(
                                color = Yellow500, //add material
                                fontStyle = Typography.bodyLarge.fontStyle)) {
                                append(" Food")
                            }
                        })

                        Spacer(modifier = Modifier.padding(2.dp))

                        Box(
                            modifier = Modifier
                                .size(width = 126.dp, height = 40.dp)
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                                .background(Yellow500), //add material
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Order Now",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.man),
                        contentDescription = "Man",
                        modifier = Modifier.size(156.dp))
                }
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        BoxWithRes(resId = R.drawable.menu, description = "Menu")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Location",
                tint = Orange500,
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Tel Aviv")

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "Down",
                tint = Orange500,
                modifier = Modifier.size(16.dp)
            )
        }

        BoxWithRes(resId = R.drawable.search, description = "Search")

    }
}

@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = CardItemBg,
    iconColor: Color? = IconColor,
    boxSize: Int? = 40,
    iconSize: Int = 24
) {
    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(bgColor!!),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            tint = iconColor!!,
            modifier = Modifier.size(iconSize.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestaurantAppTheme {
        HomeScreen()
    }
}