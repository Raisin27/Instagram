package com.example.instagram

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.instagram.ui.theme.InstagramTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(modifier: Modifier) {
    Scaffold(
//        bottomBar = { InstaBottomNavigation()}
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}


    @Composable
    fun StoryElement(
        modifier: Modifier = Modifier,
        @DrawableRes drawable: Int,
        @StringRes text: Int
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier) {
            val rainbowColorsBrush = remember {
                Brush.sweepGradient(
                    listOf(
                        Color(0xFFBA68C8),
                        Color(0xFFE57373),
                        Color(0xFFFFB74D),
                        Color(0xFF9575CD)
                    )
                )
            }

            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
                    .border(2.dp, rainbowColorsBrush, CircleShape),
                contentScale = ContentScale.Crop,

                )

            Text(
                text = stringResource(id = text),
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
    @Composable
    fun AddStoryElement(
        modifier: Modifier = Modifier,
        @DrawableRes drawable: Int,
//    @StringRes text: Int,
        @ColorRes color: Int
    ){
        Column(
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = null,
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = "Your story",
                    modifier = Modifier
                        .paddingFromBaseline(top = 24.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = color)
                )
            }
            IconButton(onClick = { /*TODO*/ },
                Modifier.absoluteOffset(44.dp,-56.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null)
            }
        }

    }
    @Preview(showBackground = true)
    @Composable
    fun AddStoryElementPreview(){
        InstagramTheme {
            AddStoryElement(
                drawable = R.drawable.str6_men,
                color = R.color.grey
            )
        }
    }
    @Composable
    fun StoryRow(
        modifier: Modifier = Modifier
    ){
        LazyRow(
            modifier = Modifier.absoluteOffset(0.dp, 20.dp),
//            .heightIn(80.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            item{
                AddStoryElement(
                    drawable = R.drawable.str5_girl,
                    color = R.color.grey)
            }
            items(storyData){item ->
                StoryElement(
                    drawable = item.drawable,
                    text = item.text)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun StoryElementPreview(){
        InstagramTheme {
            StoryElement(
                text = R.string.str1_work,
                drawable = R.drawable.str1_work,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun StoryRowPreview(){
        InstagramTheme {
            StoryRow(
                modifier = Modifier.padding(8.dp)
            )
        }
    }
    @Composable
    fun NewFeedName(
        modifier: Modifier,
        @DrawableRes drawable: Int,
    ){
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                Modifier
                    .padding(start = 8.dp)
                    .size(30.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(text = "hello",
                    style = TextStyle(fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                )
                Text(text = "My music")
            }
        }
    }
    @Composable
    fun NewFeedElementButtonGroup(modifier: Modifier){
        Row(modifier = Modifier
//        .padding(8.dp)
            .height(40.dp)){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null
                )

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Create,
                    contentDescription = null
                )

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Send,
                    contentDescription = null
                )

            }
            Spacer(modifier = Modifier.padding(96.dp))

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = null
                )
            }
        }
    }
    @Composable
    fun NewFeedElementText(modifier: Modifier){
        Row (modifier = Modifier){
            Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
                Text(text = "user1 and others liked",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,

                        ),
                    modifier = Modifier.padding(bottom = 8.dp)

                )
                Text(text = "Material Design is an adaptable system of guidelines, " +
                        "components, and tools that support the best practices of user " +
                        "interface design. Backed by open-source code, Material Design " +
                        "streamlines collaboration between designers and developers, and " +
                        "helps teams quickly build beautiful products.")

            }
        }
    }
    @Composable
    fun NewFeedElement(
        modifier: Modifier = Modifier,
//    user: UserData,
//    onClick: () -> Unit,
        @DrawableRes drawable: Int,
//    @StringRes text: Int,
    ){
        Column(
            Modifier
//            .clickable(onClick = onClick)
//            .padding(16.dp)
                .fillMaxWidth()
        ) {
            NewFeedName(modifier = Modifier, drawable = drawable)
            Spacer(modifier = Modifier.padding(4.dp))
            Image(painter = painterResource(id = drawable), contentDescription = null)
            NewFeedElementButtonGroup(modifier = Modifier)
            NewFeedElementText(modifier = Modifier)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
    @Composable
    fun NewFeedColumn(
        modifier: Modifier = Modifier
    ){
        LazyColumn (
            modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(0.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(newFeedData){item ->
                NewFeedElement(
                    drawable = item.drawable)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun NewFeedColumnPreview(){
        InstagramTheme {
            NewFeedColumn()
        }
    }

    @Composable
    fun TopAppBarCustom() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically) {
            val lobster = FontFamily(Font(R.font.lobster_regular))
            Spacer(modifier = Modifier.padding(8.dp))

            Text("Instagram",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = lobster,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 28.sp
                )
            )
            Spacer(modifier = Modifier.padding(72.dp))
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Likes"
                )
            }
//            Spacer(modifier = Modifier.padding(8.dp))

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Send,
                    contentDescription = "Direct"
                )
            }
//            Spacer(modifier = Modifier.padding(8.dp))


        }
    }
    @Preview(showBackground = true)
    @Composable
    fun TopAppBarCustomPreview() {
        InstagramTheme {
            TopAppBarCustom()
        }
    }


    @Composable
    fun HomeScreen(modifier: Modifier = Modifier, ) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            LazyColumn(
            ) {
                item {
                    TopAppBarCustom()
                }
                item {
                    StoryRow()
                }
                items(newFeedData) { item ->
                    NewFeedElement(
                        drawable = item.drawable
                    )
                }
            }
        }

    }

    @Preview(showBackground = true, heightDp = 500)
    @Composable
    fun HomeScreenPreview() {
        InstagramTheme {
            HomeScreen()
        }
    }

    @Composable
    private fun InstaBottomNavigation(modifier: Modifier = Modifier) {
        NavigationBar(
            modifier = modifier,
            containerColor = Color.White,
        ) {
            NavigationBarItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
            )
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
            )
            NavigationBarItem(
                selected = false,
                onClick = {
//                    loadFragment()
                },
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.AddCircle,
                        contentDescription = null
                    )
                },
            )
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = null
                    )
                },
            )
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = null
                    )
                },
            )
        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFFFFF)
    @Composable
    fun BottomNavigationPreview() {
        InstagramTheme {
            InstaBottomNavigation()
        }
    }
//topBar = {
//    TopAppBar(
//        title = {
//            val lobster = FontFamily(Font(R.font.lobster_regular))
//            Text("Instagram",
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                fontFamily = lobster
//            )
//        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            titleContentColor = MaterialTheme.colorScheme.primary
//        ),
//        actions = {
//            IconButton(onClick = {}){
//                Icon(imageVector = Icons.Outlined.FavoriteBorder,
//                    contentDescription = "Likes"
//                )
//            };
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Outlined.Send,
//                    contentDescription = "Direct")
//            }
//        },
//
//        )
//
//},

//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun MyInstaApp() {
//        val navController = rememberNavController()
//        val items = listOf(
//            Screen.Profile,
//            Screen.AddPost,
//        )
//        Scaffold(
//            bottomBar = { InstaBottomNavigation{
//
//
//
//        ) { padding ->
//            HomeScreen(Modifier.padding(padding))
//        }
//    }

    @Preview(showBackground = true)
    @Composable
    fun MyInstaAppPreview() {
//        MyInstaApp()
    }


    private val storyData = listOf(
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,

//        R.drawable.str2_flower to R.string.str2_flower,
//        R.drawable.str3_magazines to R.string.str3_magazines,
//        R.drawable.str4_mountain to R.string.str4_mountain,
//        R.drawable.str5_girl to R.string.str5_girl,
//    R.drawable.str6_men to R.string.str6_men,
//    R.drawable.str7_adventure to R.string.str7_adventure,
//    R.drawable.str8_grey to R.string.str8_grey,
//    R.drawable.str9_light to R.string.str9_light,
//    R.drawable.str10_sad to R.string.str10_sad
    ).map { DrawableStringPair(it.first, it.second) }

    private val newFeedData = listOf(
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,
        R.drawable.str1_work to R.string.str1_work,

//        R.drawable.str2_flower to R.string.str2_flower,
//        R.drawable.str3_magazines to R.string.str3_magazines,
//        R.drawable.str4_mountain to R.string.str4_mountain,
//        R.drawable.str5_girl to R.string.str5_girl,
//        R.drawable.str6_men to R.string.str6_men,
//        R.drawable.str7_adventure to R.string.str7_adventure,
//        R.drawable.str8_grey to R.string.str8_grey,
//        R.drawable.str9_light to R.string.str9_light,
//        R.drawable.str10_sad to R.string.str10_sad
    ).map { DrawableStringPair(it.first, it.second) }

    private data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: Int
    )
