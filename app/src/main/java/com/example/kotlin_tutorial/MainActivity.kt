package com.example.kotlin_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //---------- Text font 적용 및 꾸미기------------------
        // res/font 에 폰트 넣기(*Convention 유의 (소문자 & 언더바 _ ))
        val fontFamily = FontFamily(
            Font(R.font.indieflower_regular, FontWeight.Medium),
        )
        setContent {

            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                Color.Green,
                                fontSize = 50.sp
                            ),
                        ) {
                            append("J")
                        }
                        append("etpack ")

                        withStyle(
                            style = SpanStyle(
                                Color.Green,
                                fontSize = 50.sp
                            )
                        ) {
                            append("C")
                        }
                        append("ompose")
                    },
                    textAlign = TextAlign.Center,
                    fontFamily = fontFamily,
                    fontSize = 30.sp,
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline

                )
            }

            //---------- 이미지 + 카드 나열 ------------------
//            val painter = painterResource(id = R.drawable.kermit)
//            val description = "Kermit in the snow"
//            val title = "Kermit is playing in the snow"
//            Column(Modifier.background(Color.Cyan)) {
//                Row(
//                    Modifier
//                        .fillMaxWidth()
//                )
//                {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth(0.5f)
//                            .padding(16.dp)
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            contentDescription = description,
//                            title = title
//                        )
//                    }
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            contentDescription = description,
//                            title = title
//                        )
//                    }
//                }
//                Row(
//                    Modifier
//                        .fillMaxWidth()
//                )
//                {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth(0.5f)
//                            .padding(16.dp)
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            contentDescription = description,
//                            title = title
//                        )
//                    }
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            contentDescription = description,
//                            title = title
//                        )
//                    }
//                }
//                Row(
//                    Modifier
//                        .fillMaxWidth()
//                )
//                {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth(0.5f)
//                            .padding(16.dp)
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            contentDescription = description,
//                            title = title
//                        )
//                    }
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            contentDescription = description,
//                            title = title
//                        )
//                    }
//                }
//            }
        }
    }

    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(modifier = modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black,
                                ),
                                startY = 300f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }
}

