package com.svstudio.eccomerceapp.presentation.scree_auth.profile.info.componets

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.svstudio.eccomerceapp.MainActivity
import com.svstudio.eccomerceapp.R
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.profile.ProfileScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.info.ProfileViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(paddingValues: PaddingValues,navController: NavHostController,vm: ProfileViewModel= hiltViewModel()){
    val activity = LocalContext.current as? Activity

    Box(modifier = Modifier.padding(paddingValues = paddingValues)){
        Image( modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f,0.6f,0.6f,1f)
                }
            )

        )
        Column (modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .weight(2f)
                .fillMaxWidth()){
                IconButton( onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }) {
                    Icon(
                        modifier = Modifier
                            .size(35.dp)
                            .align(Alignment.TopStart),
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                if(!vm.user?.image.isNullOrBlank()){
                    AsyncImage(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .align(Alignment.Center),
                        model = vm.user?.image,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
                else{
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center),
                    painter = painterResource( id = R.drawable.user_image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                }
            }

            Card (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                  topEnd = 40.dp,
                    topStart = 40.dp
                )
            ) {
                Column(modifier = Modifier.padding(20.dp)){
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp))
                        Column (modifier = Modifier.padding(start = 20.dp)) {
                            Text("${vm.user?.name} ${vm.user?.lastname}"
                            , fontSize = 15.sp)
                            Text("Nombre de usuario",
                                fontSize = 12.sp,
                                color = Color.DarkGray

                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp))
                        Column (modifier = Modifier.padding(start = 20.dp)) {
                            Text(text = vm.user?.email?:""
                                , fontSize = 15.sp)
                            Text("Correo electronico",
                                fontSize = 12.sp,
                                color = Color.DarkGray

                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "",
                            modifier = Modifier.size(40.dp))
                        Column (modifier = Modifier.padding(start = 20.dp)) {
                            Text(text = vm.user?.phone?:""
                                , fontSize = 15.sp)
                            Text("Numero de telefono",
                                fontSize = 12.sp,
                                color = Color.DarkGray

                            )
                        }
                    }
                    Button(
                        onClick = {
                            navController.navigate(route = "${ProfileScreen.ProfileUpdate.route}/${vm.user?.toJson()}")
                        },
                        modifier = Modifier
                            .padding(top = 30.dp, start = 10.dp, end = 10.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF000000)
                        )
                        ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = ""
                            )
                            Text("Actualizar Informacion")
                        }
                    }

                }

            }
        }

    }
    /*
    androidx.compose.material.Button(
        onClick = {
        vm.logout()
            activity?.finish()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
    },
       ) { Text("Cerrar Cession")}*/
}