package com.example.monitoring.database

import com.example.monitoring.domain.Establishments
import com.example.monitoring.domain.Reviews

val sampleDataEstablishments = listOf(
    Establishments(
        categoryId = "12",
        name = "Supermercado Central",
        description = "O melhor supermercado da região.",
        coupons = 10,
        address = "Av. Paulista, 1234 - São Paulo, SP",
        phone = "(11) 98765-4321",
        urlImage = "https://www.nutrimixassessoria.com.br/wp-content/uploads/2021/08/BOAS-PRATICAS-EM-SUPERMERCADOS.jpg"
    ),
    Establishments(
        categoryId = "102",
        name = "Mercadinho da Esquina",
        description = "Uma experiência única de compras.",
        coupons = 15,
        address = "Rua das Flores, 567 - Rio de Janeiro, RJ",
        phone = "(21) 91234-5678",
        urlImage = "https://blog.ciss.com.br/wp-content/uploads/2021/09/blog-ciss-sortimento-de-produtos.jpg"
    ),
    Establishments(
        categoryId = "103",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carnes.",
        coupons = 5,
        address = "Rua das Flores, 567 - Rio de Janeiro, RJ",
        phone = "(21) 91234-5678",
        urlImage = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    )
)

val sampleDataReview = listOf(
    Reviews(
        name = "Jadilson",
        comment = "Muito bom",
        assessment = 2,
        urlImage = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    )
)