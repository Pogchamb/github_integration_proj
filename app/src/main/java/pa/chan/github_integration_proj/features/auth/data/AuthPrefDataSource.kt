package pa.chan.github_integration_proj.features.auth.data

import android.content.SharedPreferences
import pa.chan.githubintagrationproj.R
import javax.inject.Inject

class AuthPrefDataSource @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setUserToken(token: String) {
        sharedPreferences.edit()
            .putString(R.string.userTokenPref.toString(), token)
            .apply()
    }

    fun setUserName(username: String){
        sharedPreferences.edit()
            .putString(R.string.userNamePref.toString(), username)
            .apply()
    }

    fun getUserToken(): String?  {
        return sharedPreferences.getString(R.string.userTokenPref.toString(), "")
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(R.string.userNamePref.toString(), "")
    }
}