package com.example.instagram

import android.widget.EditText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.instagram.ui.theme.InstagramTheme

@Composable
fun NewPost(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
//            .align(Alignment.Center),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
        ) {
            Text(text="New Post",
                fontSize = 24.sp)
            TextFieldElement(modifier = Modifier)
        }
    }
}

@Composable
fun TextFieldElement(
    modifier: Modifier
){
    var text by remember {
        mutableStateOf(TextFieldValue("" ))}

    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter your post")},
        onValueChange =  {
            text = it
        }
    )
}
@Preview(showBackground = true)
@Composable
fun NewPostPreview(){
    InstagramTheme {
        NewPost()
    }
}
//@OptIn(ExperimentalCoilApi::class, ExperimentalFoundationApi::class)
//@Composable
//fun ImageUploadElement() {
//
//    var selectImages by remember { mutableStateOf(listOf<Uri>()) }
//
//    val galleryLauncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
//            selectImages = it
//        }
//
//    Column(
//        Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(
//            onClick = { galleryLauncher.launch("image/*") },
//            modifier = Modifier
//                .wrapContentSize()
//                .padding(10.dp)
//        ) {
//            Text(text = "Pick Image From Gallery")
//        }
//
//        LazyVerticalGrid(cells = GridCells.Fixed(3)) {
//            items(selectImages) { uri ->
//                Image(
//                    painter = rememberImagePainter(uri),
//                    contentScale = ContentScale.FillWidth,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .padding(16.dp, 8.dp)
//                        .size(100.dp)
//                        .clickable {
//
//                        }
//                )
//            }
//        }
//    }
//}}