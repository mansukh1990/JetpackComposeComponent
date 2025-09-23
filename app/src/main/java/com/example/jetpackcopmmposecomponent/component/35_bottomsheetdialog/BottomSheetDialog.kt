package com.example.jetpackcopmmposecomponent.component.`35_bottomsheetdialog`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ComposableBottomSheet(modifier: Modifier = Modifier) {

    var showBottomSheetDialog by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    val sheetState = rememberModalBottomSheetState()

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            showBottomSheetDialog = true
        }) {
            Text(
                text = "Show Bottom Sheet"
            )
        }
    }
    if (showBottomSheetDialog) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheetDialog = false
            }, sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(), text = "Select", style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 26.sp, textAlign = TextAlign.Center
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Edit")
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "")
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Share")
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "ShoppingCart")
                }
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    onClick = {
                        scope.launch {
                            sheetState.hide()
                            showBottomSheetDialog = false
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 8.dp),
                        text = "Close Bottom Sheet",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

        }
    }
}