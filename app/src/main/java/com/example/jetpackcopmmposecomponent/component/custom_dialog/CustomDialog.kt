package com.example.jetpackcopmmposecomponent.component.custom_dialog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcopmmposecomponent.R


@Composable
fun ShowCustomDeleteDialog() {

    val context = LocalContext.current

    var showDialog by remember {
        mutableStateOf(false)
    }

    if (showDialog) {
        CustomDeleteDialog(
            onYesClick = {
                showDialog = false
                Toast.makeText(context, "Yes click", Toast.LENGTH_SHORT).show()
            },
            onNoClick = {
                showDialog = false
                Toast.makeText(context, "No Click", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp
            ),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(5.dp, Color.Red),
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color.Red,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.Red
            ),
            contentPadding = PaddingValues(vertical = 15.dp),
            onClick = {
                showDialog = true
            }
        ) {
            Text(
                text = "Show Dialog",
                style = TextStyle(color = Color.White, fontSize = 12.sp)
            )
        }
    }

}

@Composable
fun CustomDeleteDialog(
    onYesClick: () -> Unit,
    onNoClick: () -> Unit,
) {
    Dialog(
        onDismissRequest = {}
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(size = 16.dp))
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(height = 16.dp))
                //Title
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = "Delete?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                //Description
                Text(
                    text = "Are you sure you want to delete the item from the list?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
                //Yes Button
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.error_color)
                    ),
                    onClick = {
                        onYesClick()
                    }
                ) {

                    Text(
                        text = "Yes, delete the item",
                        color = Color.White
                    )
                }
                //No Button
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    onClick = {
                        onNoClick()
                    }
                ) {
                    Text(
                        text = "No, keep the item!",
                        color = Color.Black
                    )

                }

            }
            Icon(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = colorResource(R.color.error_color),
                        shape = CircleShape
                    )
                    .padding(16.dp)
                    .align(alignment = Alignment.TopCenter),
                painter = painterResource(R.drawable.ic_round_auto_delete_24),
                contentDescription = "delete icon",
                tint = colorResource(R.color.error_color)
            )
        }
    }

}