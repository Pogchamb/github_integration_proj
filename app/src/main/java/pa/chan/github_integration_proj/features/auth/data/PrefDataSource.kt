package pa.chan.github_integration_proj.features.auth.data

import android.content.SharedPreferences
import pa.chan.githubintagrationproj.R
import javax.inject.Inject

class PrefDataSource @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun setUserToken(token: String) {
        sharedPreferences.edit()
            .putString(R.string.userTokenPref.toString(), token)
            .apply()
    }

    fun getUserToken(): String? {
        return sharedPreferences.getString(R.string.userTokenPref.toString(), "")
    }

    fun setUserName(userName: String) {
        sharedPreferences.edit()
            .putString(R.string.userNamePref.toString(), userName)
            .apply()
    }

    fun getUserName(): String {
        return sharedPreferences.getString(R.string.userNamePref.toString(), "").toString()
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}