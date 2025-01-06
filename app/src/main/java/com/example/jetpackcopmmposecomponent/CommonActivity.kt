package com.example.jetpackcopmmposecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcopmmposecomponent.component.GuidelinesBarrierchains.CreateBarrierExample
import com.example.jetpackcopmmposecomponent.component.GuidelinesBarrierchains.CreateChainExample
import com.example.jetpackcopmmposecomponent.component.GuidelinesBarrierchains.GuideLineExample
import com.example.jetpackcopmmposecomponent.ui.theme.JetpackCopmmposeComponentTheme

class CommonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCopmmposeComponentTheme {
                //TextLayout()
                //ButtonLayout()
                //BoxLayout()
                //TextFieldLayout()
                //  TabViewLayout()
                //LoginPageWithConstraintLayout()
                //GuideLineExample()
               // CreateBarrierExample()
                CreateChainExample()
            }
        }
    }
}