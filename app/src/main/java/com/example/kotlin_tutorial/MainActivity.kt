package com.example.kotlin_tutorial

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                            ),
                            BottomNavItem(
                                name = "Chat",
                                route = "chat",
                                icon = Icons.Default.Notifications,
                                badgeCount = 24
                            ),
                            BottomNavItem(
                                name = "Settings",
                                route = "settings",
                                icon = Icons.Default.Settings
                            )
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        })
                }
            ) {
                Navigation(navController = navController)
            }
        }
    }
}
//----------  리 스 트 뷰 ------------------
//        setContent {
//            LazyColumn {
//                itemsIndexed(
//                    arrayOf("This", "is", "Jetpack", "Compose", "I", "Learned")
//                ) { index, item ->
//                    Card(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        elevation = 5.dp,
//                        shape = RoundedCornerShape(15.dp)
//                    ) {
//                        Text(
//                            text = "$item",
//                            textAlign = TextAlign.Center,
//                            fontSize = 24.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 24.dp)
//                        )
//                    }
//                }
//            }
//        }

//---------- Text font 적용 및 꾸미기------------------
// res/font 에 폰트 넣기(*Convention 유의 (소문자 & 언더바 _ ))
//        val fontFamily = FontFamily(
//            Font(R.font.indieflower_regular, FontWeight.Medium),
//        )
//        setContent {
//
//            Box(
//                Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//            ) {
//                Text(
//                    text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                Color.Green,
//                                fontSize = 50.sp
//                            ),
//                        ) {
//                            append("J")
//                        }
//                        append("etpack ")
//
//                        withStyle(
//                            style = SpanStyle(
//                                Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("C")
//                        }
//                        append("ompose")
//                    },
//                    textAlign = TextAlign.Center,
//                    fontFamily = fontFamily,
//                    fontSize = 30.sp,
//                    color = Color.White,
//                    fontStyle = FontStyle.Italic,
//                    textDecoration = TextDecoration.Underline
//
//                )
//            }

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


/**
 * 하단 콘텐츠에 대한 Data class 지정
 * 하단 콘텐츠에는 아이콘 명, 루트 이름, 아이콘 이미지, 뱃지카운트를 넣을 것이기 때문에 data class 의 파라미터로 정의해줍니다.
 */
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)

/**
 * 네비게이션 컨트롤러 정의
 * 처음에 시작할 화면과, 각각의 화면에 대한 루트를 지정합니다.
 */
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}

/**
 * 하단 네이게이션 바 구성
 * 하단 네비게이션 레이아웃을 구성하고 아이템 상태 변화에 대한 스타일 처리를 해줍니다.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        // items 배열에 담긴 모든 항목을 추가합니다.
        items.forEach { item ->
            // 뷰의 활동 상태를 백스택에 담아 저장합니다.
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        // 뱃지카운트가 1이상이면, 아이콘에 뱃지카운트가 표시됩니다.
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            } // 뱃지 카운트가 0이면, 아이콘만 표시합니다.
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        // 아이콘이 선택 되었을 때, 아이콘 밑에 텍스트를 표시합니다.
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}


/**
 * > Bottom Navigation
 *전환할 각각의 화면 구성하기
 *MainActivity 하단에 컴포저블 함수를 지정하여 각각의 화면을 구성해줍니다.
 */
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home screen")
    }
}

@Composable
fun ChatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Chat screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings screen")
    }
}
