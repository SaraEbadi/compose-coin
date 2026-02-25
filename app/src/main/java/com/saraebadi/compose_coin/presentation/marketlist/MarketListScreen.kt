package com.saraebadi.compose_coin.presentation.marketlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.saraebadi.compose_coin.domain.model.Market

@Composable
fun MarketListScreen(
    modifier: Modifier = Modifier,
    marketListState: MarketListState,
    onItemClicked: (Market) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(marketListState.markets, key = { it.id }) { market ->
                Row(
                    modifier = modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray, RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = market.imageUrl,
                        contentDescription = market.name,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 8.dp),
                    ) {
                        Text(text = market.name)
                        Text(modifier = Modifier.padding(top = 4.dp), text = market.symbol)
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Column(
                        modifier = Modifier.wrapContentSize()
                            .padding(end = 4.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(text = "${market.currentPrice}")
                        Text(
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .background(Color.Red, RoundedCornerShape(20.dp))
                                .padding(vertical = 2.dp, horizontal = 12.dp),
                            text = market.priceChangePercentage24h.toString()
                        )
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
        Market(id = "1", name = "zzzzzzzzzz", symbol = "btd", imageUrl = ""),
        Market(id = "2", name = "xxxxxxxxx", symbol = "btd", imageUrl = ""),
        Market(id = "3", name = "vvvvvvvvv", symbol = "btd", imageUrl = ""),
        Market(id = "4", name = "aaaaaaaa", symbol = "btd", imageUrl = ""),
        Market(id = "5", name = "wwwwwwww", symbol = "btd", imageUrl = ""),
        Market(id = "6", name = "eeeeee", symbol = "btd", imageUrl = ""),
    )
    MarketListScreen(
        marketListState = MarketListState(markets = list),
        onItemClicked = {}
    )
}