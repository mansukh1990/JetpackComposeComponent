package com.example.jetpackcopmmposecomponent.component.`40_resources`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.outlined.DirectionsBike
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R

@Composable
fun Resources(modifier: Modifier = Modifier) {
    val smallPadding = dimensionResource(R.dimen.padding_small)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(text = stringResource(R.string.compose))
            Text(text = stringResource(R.string.congratulate, "New Year", 2026))
            Text(text = pluralStringResource(R.plurals.runtime_format, 1, 40))
            Text(
                text = stringResource(R.string.compose), modifier = Modifier.padding(smallPadding)
            )
            HorizontalDivider(color = colorResource(R.color.purple_500))
            //Vector assets and image resources
            Icon(
                painter = painterResource(id = R.drawable.baseline_fast_forward_24),
                contentDescription = null,
                modifier = Modifier.padding(top = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.coffee_1),
                contentDescription = null,
                modifier = Modifier.padding(top = 10.dp)
            )
            Icon(Icons.Rounded.Menu, contentDescription = "Localized description")
            Icon(Icons.Default.Person, contentDescription = null)
            Icon(Icons.Filled.Settings, contentDescription = null)
            Icon(Icons.Outlined.Settings, contentDescription = null)
            Icon(Icons.AutoMirrored.Outlined.DirectionsBike, contentDescription = null)
            Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = null)
            Icon(Icons.TwoTone.DateRange, contentDescription = null)

        }

    }


}