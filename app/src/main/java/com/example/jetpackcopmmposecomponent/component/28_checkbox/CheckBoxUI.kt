package com.example.jetpackcopmmposecomponent.component.`28_checkbox`

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxUi() {

    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            },
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Yellow,
                checkmarkColor = Color.Black
            )
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
        CustomCheckBox()

    }

}

@Composable
fun CustomCheckBox() {

    var isCheck by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier,
            elevation = CardDefaults.cardElevation(0.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(Color.White),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .background(
                        if (isCheck) Color.Green else Color.White
                    )
                    .clickable {
                        isCheck = !isCheck
                    },
                contentAlignment = Alignment.Center

            ) {
                if (isCheck)
                    Icon(
                        Icons.Default.Check,
                        contentDescription = "",
                        tint = Color.White
                    )

            }
        }
        Text(
            text = "Accept all Terms and Conditions",
            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterVertically)
        )

    }

}