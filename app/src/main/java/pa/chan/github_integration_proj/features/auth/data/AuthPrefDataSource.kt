package pa.chan.github_integration_proj.features.auth.data

import androidx.security.crypto.EncryptedSharedPreferences

class AuthPrefDataSource(private val sharedPreferences: EncryptedSharedPreferences) {

    fun setUserToken(token: String) {
        sharedPreferences.edit()
            .putString("UserToken", token)
            .apply()
    }

    fun getUserToken(): String?  {
        return sharedPreferences.getString("UserToken", "")
    }

}