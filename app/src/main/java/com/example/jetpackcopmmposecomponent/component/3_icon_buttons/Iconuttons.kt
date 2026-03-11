package com.example.jetpackcopmmposecomponent.component.`3_icon_buttons`

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.UnfoldMore
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R
import kotlinx.coroutines.delay

@Composable
fun IconButtonsExample() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        ToggleIconButtonExample()
        MomentaryIconButton(
            unselectedImage = R.drawable.outline_arrow_circle_up_24,
            selectedImage = R.drawable.outline_arrow_circle_down_24,
            contentDescription = "Toggle",
            stepDelay = 500L,
            onClick = {}
        )
        MomentaryIconButtonExample()
        SingleChoiceSegmentedButton()
        MultiChoiceSegmentedButton()
    }

}

@Composable
fun ToggleIconButtonExample() {

    var isToggle by rememberSaveable { mutableStateOf(false) }

    IconButton(
        onClick = {
            isToggle = !isToggle
        }
    ) {
        Icon(
            if (isToggle) Icons.Filled.UnfoldMore else Icons.Filled.AccountBalance,
            contentDescription = null
        )
    }

}

@Composable
fun MomentaryIconButton(
    unselectedImage: Int,
    selectedImage: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    stepDelay: Long = 100L, // Minimum value is 1L milliseconds.
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressedListener by rememberUpdatedState(onClick)

    LaunchedEffect(isPressed) {
        while (isPressed) {
            delay(stepDelay.coerceIn(1L, Long.MAX_VALUE))
            pressedListener()
        }
    }

    IconButton(
        modifier = modifier,
        onClick = onClick,
        interactionSource = interactionSource
    ) {
        Icon(
            painter = if (isPressed) painterResource(id = selectedImage) else painterResource(id = unselectedImage),
            contentDescription = contentDescription,
        )
    }
}

@Composable
fun MomentaryIconButtonExample() {
    var pressedCount by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MomentaryIconButton(
            unselectedImage = R.drawable.outline_fast_rewind_24,
            selectedImage = R.drawable.baseline_fast_rewind_24,
            stepDelay = 100L,
            onClick = { pressedCount -= 1 },
            contentDescription = "Decrease count button"
        )
        Spacer(modifier = Modifier)
        Text("advanced by $pressedCount frames")
        Spacer(modifier = Modifier)
        MomentaryIconButton(
            unselectedImage = R.drawable.outline_fast_forward_24,
            selectedImage = R.drawable.baseline_fast_forward_24,
            contentDescription = "Increase count button",
            stepDelay = 100L,
            onClick = { pressedCount += 1 }
        )
    }
}

@Composable
fun SingleChoiceSegmentedButton() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Day", "Month", "Week")

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}

@Composable
fun MultiChoiceSegmentedButton() {
    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }
    val options = listOf("Walk", "Ride", "Drive")

    MultiChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                checked = selectedOptions[index],
                onCheckedChange = {
                    selectedOptions[index] = !selectedOptions[index]
                },
                icon = { SegmentedButtonDefaults.Icon(selectedOptions[index]) },
                label = {
                    when (label) {
                        "Walk" -> Icon(
                            imageVector =
                                Icons.AutoMirrored.Filled.DirectionsWalk,
                            contentDescription = "Directions Walk"
                        )

                        "Ride" -> Icon(
                            imageVector =
                                Icons.Default.DirectionsBus,
                            contentDescription = "Directions Bus"
                        )

                        "Drive" -> Icon(
                            imageVector =
                                Icons.Default.DirectionsCar,
                            contentDescription = "Directions Car"
                        )
                    }
                }
            )
        }
    }
}