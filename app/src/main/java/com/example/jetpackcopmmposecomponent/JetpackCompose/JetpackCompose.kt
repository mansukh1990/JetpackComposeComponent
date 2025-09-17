package com.example.jetpackcopmmposecomponent.JetpackCompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.component.`21_chips`.ChipsComposable
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class JetpackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeComponentTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ComposePreview(modifier = Modifier.padding(innerPadding))
                }
            }

        }
    }

    @Preview(showBackground = true, showSystemUi = true, name = "Light Mode")
    @Preview(
        showBackground = true,
        showSystemUi = true,
        name = "Night Mode",
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun ComposePreview(modifier: Modifier = Modifier) {
        JetpackComposeComponentTheme {
            //TextLayout(name = "Android", modifier = modifier)
            //ButtonComposableLayout()
            // ButtonLayout()
            // ButtonComposable(modifier = modifier)
            //ColumnComposable(modifier = modifier)
            //  RowComposable(modifier = modifier)
            // BoxComposable(modifier = modifier)
            // SurfaceComposable(modifier = modifier)
            // CardComposable(modifier = modifier)
            // CounterApp(modifier = modifier)
            // ImageComposable(modifier = modifier)
            //IconsComposable(modifier = modifier)
            //TextFieldComposable(modifier = modifier)
            ChipsComposable(modifier = modifier)
            //StarBucksNavigation()
            //TextFieldLayout()
            //ComposableBottomSheet()
        }

    }
}

