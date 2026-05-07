package com.example.jetpackcopmmposecomponent.JetpackCompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcopmmposecomponent.JetpackCompose.ClusterGoogleMap.ClusterMapScreen
import com.example.jetpackcopmmposecomponent.component.`1_text`.TextLayout
import com.example.jetpackcopmmposecomponent.component.`2_floating_action_button`.FloatingActionButtonExample
import com.example.jetpackcopmmposecomponent.component.`3_icon_buttons`.IconButtonsExample
import com.example.jetpackcopmmposecomponent.component.`43_snackbar`.AppSnackbar
import com.example.jetpackcopmmposecomponent.component.TranslucentStatusBar.TranslucentStatusBar
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class JetpackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                android.graphics.Color.TRANSPARENT,
                Color.Transparent.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.auto(
                android.graphics.Color.TRANSPARENT,
                Color.Transparent.toArgb()
            )
        )

        setContent {

            val scope = rememberCoroutineScope()

            JetpackComposeComponentTheme {
                TranslucentStatusBar(color = Color.Transparent)
                Scaffold (
                    snackbarHost = {
                        SnackbarHost(
                            hostState = AppSnackbar.snackbarHostState
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {

                    ComposePreview()
                }
            }

        }
    }

    @Preview(
        showBackground = true,
        showSystemUi = true,
        name = "Light Mode",
        uiMode = Configuration.UI_MODE_NIGHT_NO
    )
    @Preview(
        showBackground = true,
        showSystemUi = true,
        name = "Night Mode",
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun ComposePreview(modifier: Modifier = Modifier) {
        JetpackComposeComponentTheme {
            val scaffoldState = rememberScaffoldState()

            //TextLayout(name = "Android", modifier = modifier)
            //ButtonComposableLayout()
            //ButtonLayout()
            //ButtonComposable(modifier = modifier)
            //ColumnComposable()
            //RowComposable()
            //BoxComposable()
            //BoxLayout()
            //SurfaceComposable()
            //CardComposable()
            //CardExample()
            //CounterApp(modifier = modifier)
            //ImageComposable()
            //IconsComposable()
            //ImageAndIcon()
            //TextFieldComposable()
            //TextFieldLayout()
            //TextFieldsLayout()
            //ChipsComposable()
            //FilterChipLayout()
            //LazyColumnComposable()
            //LazyRowComposable()
            //LazyVerticalGridComposable()
            //LazyHorizontalGridComposable()
            //LazyVerticalStaggeredGridComposable()
            //LazyHorizontalStaggeredGridComposable()
            //CheckBoxComposable()
            //CheckBoxUi()
            //CheckboxMinimalExample()
            //CheckboxParentExamples()
            //TopAppBarComp()
            //StarBucksNavigation()
            //ComposableBottomSheet()
            //ScaffoldComposable()
            //NavigationDrawerComposable()
            //DialogComposable()
            //BottomSheetComposable()
            //SideEffectComposable()
            //DisposableEffectComposable(modifier = modifier)
            //SideEffectsComposable(modifier=modifier)
            //RememberCoroutineScopeComposable(modifier = modifier)
            //RememberUpdateStateComposable(modifier = modifier)
            //ProduceStateComposable(modifier = modifier)
            //DerivedStateComposable(modifier = modifier)
            //LazyListScreen(modifier = modifier)
            //ExposedDropdownMenuComposable(modifier = modifier)
            //LazyVerticalStgGridComposable(modifier = modifier)
            //LazyHorizontalStgGridComposable(modifier = modifier)
            //TimePickerComposable(modifier = modifier)
            //DateRangePickerComposable(modifier = modifier)
            //DatePickerComposable(modifier = modifier)
            //PickImageFromGallery()
            //PickImageFromCamera()
            //ShowSwitch(modifier = modifier)
            //RadioButtonLayout()
            //HorizontalPagerScreen()
            //VerticalPagerScreen()
            //TabViewLayout(modifier = modifier)
            //CustomTitleBar()
            //PasswordValidationScreen()
            //MultiplePhotoPickerFromGallery()
            //DrawingScreen()
            //SegmentedButtonsComposable()
            //OtpTextField
            //LottieAnimationComposable()
            //ImageLoaderComposable()
            //ImageForCoilComposable()
            //MLKitDocumentScanner()
            //RemoveItemsBySwiping()
            //BlurImages()
            //SharedElementTransition()
            //OverflowIndicator()
            //AdaptiveListDetailLayout()
            //ImageCarousel()
            //NetworkScreen()
            //PullToRefresh()
            // VideoScreen()
            //ShowCustomDeleteDialog()
            //CustomProgressScreen()
            //LoadingDialogSscreen()
            //BadgeExample()
            //BadgeInteractiveExample()
            //ModalBottomSheetExample()
            //PartialBottomSheet()
            //ButtonExample()
            //FloatingActionButtonExample()
            IconButtonsExample()
            //Carousel()
            //Chip()
            //DatePickerDocked()
            //ShowDatePickerModal()
            //DialogExamples()
            //Divider()
            //MinimalDropdownMenu()
            //LongBasicDropdownMenu()
            //DropdownMenuWithDetails()
//            DetailedDrawerExample(
//                content = {}
//            )
          //NavigationRailExample()
            //LinearDeterminateIndicator()
            //IndeterminateCircularIndicator()
            //PullToRefreshBasic()
            //PullToRefreshCustomStyle()
            //RadioButtonSingleSelection()
            //Resources()
            //Searchbar()
            //Slider()
            //SnackBarScreen()
            //SwitchExample()
            //TimePickerComposables()
            //ClusterMapScreen()
        }

    }
}

