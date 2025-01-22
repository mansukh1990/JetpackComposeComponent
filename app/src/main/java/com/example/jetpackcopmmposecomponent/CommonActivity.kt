package com.example.jetpackcopmmposecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcopmmposecomponent.SharedViewmodel.ScreenNavigation
import com.example.jetpackcopmmposecomponent.component.PickImageFromGallery.PickImageFromGallery
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackComposeComponentTheme

class CommonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentTheme {
                var selected by remember { mutableStateOf(false) }
                //TextLayout()
                //ButtonLayout()
                //BoxLayout()
                //TextFieldLayout()
                //  TabViewLayout()
                //LoginPageWithConstraintLayout()
                //GuideLineExample()
               // CreateBarrierExample()
                //CreateChainExample()
                //  ParentContent()
              //  CustomTitleBar()
                //CustomToggleButton()

                //   SuggestionChipsLayout()
                // FilterChipLayout()
                //SearchViewLayout()
                Surface {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        PickImageFromGallery()
                     //   TextFieldLayout()
//                        CustomToggleButton(
//                            selected = selected,
//                            onChangeValue = {
//                                selected = it
//                            }
//                        )
                    }
                }


            }
        }
    }
}