package test.twobyte.app.domain.model

data class NewsApi(
    val status: String? = null,
    val totalResults: Int? = null,
    val articles: List<Articles>? = null,
)

data class SourceApi(
    val id: String?,
    val name: String
)

data class Articles(
    val source: SourceApi,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
)