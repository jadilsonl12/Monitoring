package com.example.monitoring.ui.components.review

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.monitoring.domain.Reviews
import com.example.monitoring.ui.theme.Gray100
import com.example.monitoring.ui.theme.Gray200
import com.example.monitoring.ui.theme.Gray500
import com.example.monitoring.ui.theme.Typography


@Composable

fun NearbyReviewCard(modifier: Modifier = Modifier, r: Reviews) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Gray100)
            .border(width = 1.dp, color = Gray200, shape = RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray100)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = r.urlImage,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .height(
                        IntrinsicSize.Min
                    )
                    .aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true),
                contentScale = ContentScale.Crop,
                contentDescription = "Imagem do cliente"
                )
            Column {
                Text(
                    text = r.name, style = Typography.headlineSmall.copy(fontSize = 1
                        .sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = r.comment,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500,
                    style = Typography.bodyLarge.copy(fontSize = 12.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Icon(Icons.Outlined.Star, contentDescription = "Icon de estrela")
                    Text(
                        text = "${r.assessment} de 5",
                        color = Gray500,
                        style = Typography.bodyMedium.copy(fontSize = 12.sp)
                    )
                }
            }
        }
    }
}