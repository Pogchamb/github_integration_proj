package pa.chan.github_integration_proj.features.auth.data

import okio.ByteString.Companion.encode
import pa.chan.github_integration_proj.features.auth.data.dto.AuthUserDetailsDto
import java.nio.charset.Charset
import javax.inject.Inject
import kotlin.text.Charsets.ISO_8859_1

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) {
    suspend fun getUserDetails(token: String): AuthUserDetailsDto {
        val charset: Charset = ISO_8859_1
        val credential = "Basic ${token.encode(charset).base64()}"
        return authApi.getUserDetails(credential)
    }
}