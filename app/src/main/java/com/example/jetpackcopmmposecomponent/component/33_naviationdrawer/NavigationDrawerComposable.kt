package com.example.jetpackcopmmposecomponent.component.`33_naviationdrawer`

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcopmmposecomponent.component.`31_scaffold`.ScaffoldComposable

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationDrawerComposable() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet() {
                Text(
                    modifier = Modifier.padding(30.dp),
                    text = "Drawer Content",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.Black
                )
                Spacer(Modifier.height(20.dp))

                NavigationDrawerItem(
                    label = { Text(text = "Inbox") },
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "")
                    },
                    badge = {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Outbox")
                    },
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = "")
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Favourite"
                        )
                    },
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite, contentDescription = ""
                        )
                    }
                )
            }
        },
        drawerState = drawerState
    ) {
        ScaffoldComposable()

    }
}