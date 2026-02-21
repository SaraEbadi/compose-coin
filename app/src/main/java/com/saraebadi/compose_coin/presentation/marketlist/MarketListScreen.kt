package com.saraebadi.compose_coin.presentation.marketlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saraebadi.compose_coin.R
import com.saraebadi.compose_coin.domain.model.Market

@Composable
fun MarketListScreen(
    modifier: Modifier = Modifier,
    marketListState: MarketListState,
    onItemClicked: (Market) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(marketListState.markets, key = { it.id }) {
                Row(
                    modifier = modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(Color.Gray, RoundedCornerShape(8.dp))
                        .padding(16.dp),
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = it.name,
                        modifier = Modifier.size(24.dp),
                        )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = it.name)
                        Text(text = it.name)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MarketListScreenPreview() {
    val list = listOf(
        Market(id = "1", name = "zzzzzzzzzz"),
        Market(id = "2", name = "xxxxxxxxx"),
        Market(id = "3", name = "vvvvvvvvv"),
        Market(id = "4", name = "aaaaaaaa"),
        Market(id = "5", name = "wwwwwwww"),
        Market(id = "6", name = "eeeeee"),
    )
    MarketListScreen(
        marketListState = MarketListState(markets = list),
        onItemClicked = {}
    )
}