package pa.chan.github_integration_proj.features.auth.data

import android.content.SharedPreferences
import javax.inject.Inject

class AuthPrefDataSource @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setUserToken(token: String) {
        sharedPreferences.edit()
            .putString("UserToken", token)
            .apply()
    }

    fun setUserName(username: String){
        sharedPreferences.edit()
            .putString("UserName", username)
            .apply()
    }

    fun getUserToken(): String?  {
        return sharedPreferences.getString("UserToken", "")
    }

    fun getUserName(): String? {
        return sharedPreferences.getString("UserName", "")
    }
}