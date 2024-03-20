package com.example.movies.ui.theme

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.safe.args.generator.models.Destination
import com.example.pf2ebestiary.R

@Composable
fun TopNav(navController: NavController, modifier: Modifier = Modifier) {
    TopNavigation (elevation = 7.dp) {
        val navBackStackEntry = navController.currentBackStackEntry
        val currentDestination = navBackStackEntry?.destination

        TopNavigationItem(
            selected = currentDestination?.route == Destination.FullTable.route,
            onClick = {
                navController.navigate(Destination.FullTable.route) {
                    popUpTo(Destination.FullTable.route)
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.film),
                    contentDescription = "All Creatures",
                    modifier = Modifier.size(16.dp)
                )
            },
            label = { Text(text = Destination.Creature.route.replaceFirstChar {it.uppercase()})}
        )


        TopNavigationItem(
            selected = currentDestination?.route == Destination.Families.route,
            onClick = {
                navController.navigate(Destination.Families.route) {
                    popUpTo(Destination.Families.route)
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Families",
                    modifier = Modifier.size(16.dp)
                )
            },
            label = { Text(text = Destination.Watch.route.replaceFirstChar {it.uppercase() })}
        )

        TopNavigationItem(
            selected = currentDestination?.route == Destination.Level.route,
            onClick = {
                navController.navigate(Destination.Level.route) {
                    popUpTo(Destination.Level.route)
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Levels",
                    modifier = Modifier.size(16.dp)
                )
            },
            label = { Text(text = Destination.Watch.route.replaceFirstChar {it.uppercase() })}
        )

        TopNavigationItem(
            selected = currentDestination?.route == Destination.Type.route,
            onClick = {
                navController.navigate(Destination.Type.route) {
                    popUpTo(Destination.Type.route)
                }
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Types",
                    modifier = Modifier.size(16.dp)
                )
            },
            label = { Text(text = Destination.Watch.route.replaceFirstChar {it.uppercase() })}
        )
    }
}