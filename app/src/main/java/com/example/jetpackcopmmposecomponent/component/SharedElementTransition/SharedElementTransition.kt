package com.example.jetpackcopmmposecomponent.component.SharedElementTransition

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcopmmposecomponent.R
import kotlin.random.Random

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedElementTransition() {

    val coffeeList = remember {
        mutableStateListOf(
            Coffee(
                name = "Espresso",
                description = "Strong and bold coffee brewed by forcing hot water through finely ground beans.",
                image = R.drawable.coffee_1
            ),
            Coffee(
                name = "Cappuccino",
                description = "Espresso with steamed milk and foam, offering a smooth and creamy taste.",
                image = R.drawable.coffee_2
            ),
            Coffee(
                name = "Latte",
                description = "Creamy coffee made with espresso and steamed milk, topped with a light layer of foam.",
                image = R.drawable.coffee_3
            ),
            Coffee(
                name = "Americano",
                description = "Espresso diluted with hot water, giving it a lighter flavor.",
                image = R.drawable.coffee_4
            ),
            Coffee(
                name = "Mocha",
                description = "A mix of espresso, chocolate syrup, and steamed milk, topped with whipped cream.",
                image = R.drawable.coffee_5
            ), Coffee(
                name = "Espresso",
                description = "Strong and bold coffee brewed by forcing hot water through finely ground beans.",
                image = R.drawable.coffee_1
            ),
            Coffee(
                name = "Cappuccino",
                description = "Espresso with steamed milk and foam, offering a smooth and creamy taste.",
                image = R.drawable.coffee_2
            ),
            Coffee(
                name = "Latte",
                description = "Creamy coffee made with espresso and steamed milk, topped with a light layer of foam.",
                image = R.drawable.coffee_3
            ),
            Coffee(
                name = "Americano",
                description = "Espresso diluted with hot water, giving it a lighter flavor.",
                image = R.drawable.coffee_4
            ),
            Coffee(
                name = "Mocha",
                description = "A mix of espresso, chocolate syrup, and steamed milk, topped with whipped cream.",
                image = R.drawable.coffee_5
            )
        )
    }

    var selectedCoffee by remember { mutableStateOf<Coffee?>(null) }

    var showDetail by remember { mutableStateOf(false) }

    SharedTransitionLayout {
        AnimatedContent(
            targetState = showDetail
        ) { isVisible ->
            if (!isVisible) {
                SharedTransitionLayoutScreen(
                    coffeeList = coffeeList,
                    onSelected = {
                        selectedCoffee = it
                        showDetail = true
                    },
                    transitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedContent
                )

            } else {
                selectedCoffee?.let {
                    SharedTransitionLayoutDetailScreen(
                        onBack = {
                            showDetail = false
                        },
                        selectedCoffee = it,
                        transitionScope = this@SharedTransitionLayout,
                        animatedVisibilityScope = this@AnimatedContent
                    )
                }


            }
        }

    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionLayoutScreen(
    coffeeList: List<Coffee>,
    modifier: Modifier = Modifier,
    onSelected: (Coffee) -> Unit,
    transitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 10.dp
        ),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(
            items = coffeeList
        ) { coffee ->
            with(transitionScope) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
//                        .sharedBounds(
//                            rememberSharedContentState(key = coffee.id),
//                            animatedVisibilityScope = animatedVisibilityScope
//                        )
                        .clickable {
                            onSelected(coffee)
                        }
                ) {
                    Image(
                        painter = painterResource(id = coffee.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .sharedElement(
                                rememberSharedContentState(key = coffee.id),
                                animatedVisibilityScope = animatedVisibilityScope
                            )
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Column {
                        Text(
                            text = coffee.name,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = coffee.description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                }

            }

        }

    }

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionLayoutDetailScreen(
    onBack: () -> Unit,
    selectedCoffee: Coffee,
    transitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clickable(
                onClick = onBack
            ),
        contentAlignment = Alignment.Center
    ) {
        with(transitionScope) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
//                    .sharedBounds(
//                        rememberSharedContentState(key = selectedCoffee.id),
//                        animatedVisibilityScope = animatedVisibilityScope
//                    )
            ) {
                Image(
                    painter = painterResource(id = selectedCoffee.image),
                    contentDescription = null,
                    modifier = Modifier
                        .sharedElement(
                            rememberSharedContentState(key = selectedCoffee.id),
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                        .size(200.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = selectedCoffee.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = selectedCoffee.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

}

data class Coffee(
    val id: Int = Random.nextInt(),
    val name: String,
    val description: String,
    @DrawableRes val image: Int
)