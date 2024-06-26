package com.example.superherois

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superherois.model.Hero
import com.example.superherois.model.HeroesRepository
import com.example.superherois.ui.theme.SuperheroisTheme

@Composable
fun HeroApp(heroes: List<Hero>, modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
                 TopAppBar()
        },
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .statusBarsPadding()
    ) { it ->
        LazyColumn (
            modifier = modifier
                .padding(it)

        ) {
            items(HeroesRepository.heroes.size) {
                HeroCard(
                    hero = heroes[it],
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
fun HeroCard(hero: Hero, modifier : Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .clip(shape = MaterialTheme.shapes.medium)
            .padding(bottom = 8.dp)

    ) {
        Row (
            modifier = modifier
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring (
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
        ) {
            Column (
                modifier = modifier
                    .height(72.dp)
                    .weight(1f)

            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            Box (
                modifier = modifier
                    .height(72.dp)
                    .clip(shape = MaterialTheme.shapes.small)

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightThemePreview() {
    SuperheroisTheme {
        HeroApp(heroes = HeroesRepository.heroes)
    }
}