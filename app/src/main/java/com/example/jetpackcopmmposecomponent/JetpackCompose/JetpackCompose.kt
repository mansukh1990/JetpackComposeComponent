package com.example.jetpackcopmmposecomponent.JetpackCompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.component.MLKitDocumentScanner.MLKitDocumentScanner
import com.example.jetpackcopmmposecomponent.component.TranslucentStatusBar.TranslucentStatusBar
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class JetpackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            JetpackComposeComponentTheme {
                TranslucentStatusBar(color = Color.Blue)
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    ComposePreview()
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
            //ChipsComposable(modifier = modifier)
            //LazyColumnComposable(modifier = modifier)
            // LazyRowComposable(modifier = modifier)
            //LazyVerticalGridComposable(modifier = modifier)
            //LazyHorizontalGridComposable(modifier = modifier)
            // LazyVerticalStaggeredGridComposable(modifier = modifier)
            //LazyHorizontalStaggeredGridComposable(modifier = modifier)
            // CheckBoxComposable(modifier = modifier)
            //  CheckBoxUi()
            //StarBucksNavigation()
            //TextFieldLayout()
            //ComposableBottomSheet()
            // ScaffoldComposable()
            //  NavigationDrawerComposable()
            //DialogComposable()
            //  BottomSheetComposable()
            // SideEffectComposable()
            // DisposableEffectComposable(modifier = modifier)
            // SideEffectsComposable(modifier=modifier)
            // RememberCoroutineScopeComposable(modifier = modifier)
            //RememberUpdateStateComposable(modifier = modifier)
            // ProduceStateComposable(modifier = modifier)
            //DerivedStateComposable(modifier = modifier)
            //  LazyListScreen(modifier = modifier)
            // ExposedDropdownMenuComposable(modifier = modifier)
            // LazyVerticalStgGridComposable(modifier = modifier)
            // LazyHorizontalStgGridComposable(modifier = modifier)
            //  TimePickerComposable(modifier = modifier)
            // DateRangePickerComposable(modifier = modifier)
            //  DatePickerComposable(modifier = modifier)
            //  PickImageFromGallery()
            //PickImageFromCamera()
            // ShowSwitch(modifier = modifier)
            // RadioButtonLayout()
            //  HorizontalPagerScreen()
            //  VerticalPagerScreen()
            //TabViewLayout(modifier = modifier)
            //CustomTitleBar()
            // PasswordValidationScreen()
           // MultiplePhotoPickerFromGallery()
            //  DrawingScreen()
           // SegmentedButtonsComposable()
           //OtpTextField
            //  LottieAnimationComposable()
            // ImageLoaderComposable()
            //  ImageForCoilComposable()
            MLKitDocumentScanner()
        }

    }
}

