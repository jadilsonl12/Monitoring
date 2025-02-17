package com.example.monitoring.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.monitoring.R
import com.example.monitoring.database.DatabaseHelper
import com.example.monitoring.domain.Reviews
import com.example.monitoring.ui.components.button.NearbyButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun RegisterNewReviewScreen(onNavigateBack: () -> Unit) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }
    var assessment by remember { mutableStateOf(0) }
    var urlImage by remember { mutableStateOf("") }


    val scope = rememberCoroutineScope()


    Scaffold {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = it.calculateTopPadding(), horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NearbyButton(
                modifier = Modifier,
                iconRes = R.drawable.ic_arrow_left,
                onClick = onNavigateBack
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = name,
                maxLines = 1,
                onValueChange = { name = it },
                label = { Text("Nome") },
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = assessment.toString(),
                maxLines = 1,
                onValueChange = { assessment = it.toIntOrNull() ?: 0 },
                label = { Text("Avaliação de 1 a 5") },
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = comment,
                maxLines = 1,
                onValueChange = { comment = it },
                label = { Text("Comentário sobre o estabelecimento") },
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = urlImage,
                maxLines = 1,
                onValueChange = { urlImage = it },
                label = { Text("Imagem do cliente") },
            )
            Button(
                onClick = {
                    val review = Reviews(
                        name = name,
                        comment = comment,
                        assessment = assessment,
                        urlImage = urlImage
                    )

                    scope.launch {
                        withContext(Dispatchers.IO) {
                            //  Insere no banco de dados

                            DatabaseHelper.getInstance(context).reviewsDao().insert(review)
                        }
                    }

                }
            ) {
                Text("Registrar avaliação")
            }
        }
    }
}

