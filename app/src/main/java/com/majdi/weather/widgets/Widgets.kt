package com.majdi.weather.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.majdi.weather.R
import com.majdi.weather.model.Weather
import com.majdi.weather.model.WeatherItem
import com.majdi.weather.utils.formatDate
import com.majdi.weather.utils.formatDecimals
import com.majdi.weather.utils.formatTime


@Composable
fun WeeklyWeatherList(weather: Weather) {
    Surface(
        modifier = Modifier.padding(4.dp),
        color = Color.White,
        shape = RoundedCornerShape(20.dp)
    ) {
        LazyColumn {
            items(weather.list) { item ->
                DailyWeatherItem(item = item)
            }
        }
    }
}

@Composable
fun DailyWeatherItem(item: WeatherItem) {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(
            topStart = 50.dp,
            topEnd = 0.dp,
            bottomEnd = 50.dp,
            bottomStart = 50.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = formatDate(item.dt).split(",")[0])
            WeatherStateImage(item.weather[0].icon)

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFC400))
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = item.weather[0].description,
                    color = Color.Blue
                )
            }

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue.copy(alpha = 0.7f),
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append(text = "${formatDecimals(item.temp.max)}°")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Black.copy(alpha = 0.7f),
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append(text = "${formatDecimals(item.temp.min)}°")
                }
            })
        }
    }
}

@Composable
fun HumidityWindPressure(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "pressure icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${weather.humidity}%", style = MaterialTheme.typography.labelLarge)

        }
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = "pressure icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${weather.pressure} psi", style = MaterialTheme.typography.labelLarge)

        }
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "wind icon",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "${formatDecimals(weather.speed)} mph",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }

}

@Composable
fun SunsetSunriseRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "pressure icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = formatTime(weather.sunrise), style = MaterialTheme.typography.labelLarge)

        }
        Row(modifier = Modifier.padding(4.dp)) {
            Text(text = formatTime(weather.sunset), style = MaterialTheme.typography.labelLarge)
            Icon(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "pressure icon",
                modifier = Modifier.size(20.dp)
            )

        }
    }
}


@Composable
fun WeatherStateImage(imageUrl: String) {
    val imageUrl = "https://openweathermap.org/img/wn/${imageUrl}.png"
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "Image Icon",
        modifier = Modifier.size(80.dp)
    )
}
