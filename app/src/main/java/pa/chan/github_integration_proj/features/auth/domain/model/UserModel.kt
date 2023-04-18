package pa.chan.github_integration_proj.features.auth.domain.model

import android.os.Parcel
import android.os.Parcelable

data class UserModel(
    val login: String?,
    val id: String?,
    val avatarUrl: String?,
    val reposUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeString(id)
        parcel.writeString(avatarUrl)
        parcel.writeString(reposUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }
}
