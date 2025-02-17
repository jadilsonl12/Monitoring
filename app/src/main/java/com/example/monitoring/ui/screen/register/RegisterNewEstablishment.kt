package com.example.monitoring.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monitoring.R
import com.example.monitoring.database.DatabaseHelper
import com.example.monitoring.domain.Establishments
import com.example.monitoring.service.AddressService
import com.example.monitoring.ui.components.button.NearbyButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun RegisterNewEstablishmentScreen(onNavigateBack: () -> Unit) {
    val context = LocalContext.current

    var categoryId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var coupons by remember { mutableStateOf(0) }
    var cep by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var urlImage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

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
                value = categoryId,
                maxLines = 1,
                onValueChange = { categoryId = it },
                label = { Text("Id") },
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = name,
                maxLines = 1,
                onValueChange = { name = it },
                label = { Text("Nome do estabelecimento") },
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = description,
                maxLines = 1,
                onValueChange = { description = it },
                label = { Text("Descrição") },
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = coupons.toString(),
                maxLines = 1,
                onValueChange = {
                    coupons = it.toIntOrNull() ?: 0
                },
                label = { Text("Quantidade de cupons disponíveis") },
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .weight(0.65f)
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black),
                    value = cep,
                    maxLines = 1,
                    onValueChange = { cep = it },
                    label = { Text("CEP") },
                )

                Button(
                    onClick = {
                        scope.launch {
                            isLoading = true
                            val endereco = AddressService().findByCep(cep)
                            address = endereco?.city ?: "Endereço não encontrado"
                            isLoading = false
                        }
                    },
                    modifier = Modifier
                        .weight(0.35f)
                        .fillMaxWidth(),
                    enabled = cep.length == 8,
                ) {
                    Text(if (isLoading) "Buscando" else "Buscar")
                }
            }

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = address,
                maxLines = 1,
                onValueChange = { address = it },
                label = { Text("Endereço") },
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = phone,
                maxLines = 1,
                onValueChange = { phone = it },
                label = { Text("Telefone") },
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                value = urlImage,
                maxLines = 1,
                onValueChange = { urlImage = it },
                label = { Text("Url da imagem do estabelecimento") },
            )

            Button(onClick = {
                val establishment = Establishments(
                    categoryId = categoryId,
                    name = name,
                    description = description,
                    coupons = coupons,
                    address = address,
                    phone = phone,
                    urlImage = urlImage
                )

                scope.launch {
                    withContext(Dispatchers.IO) {
                        // Insere no banco de dados
                        DatabaseHelper.getInstance(context)
                            .establishmentsDao().insert(establishment)
                    }
                }

            }) {
                Text("Cadastrar")
            }
        }
    }
}


@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_3A,
)
@Composable
private fun PreviewRegisterNewEstablishmentScreen() {
    Surface(Modifier.padding(top = 64.dp)) {
        RegisterNewEstablishmentScreen(onNavigateBack = {})
    }
}