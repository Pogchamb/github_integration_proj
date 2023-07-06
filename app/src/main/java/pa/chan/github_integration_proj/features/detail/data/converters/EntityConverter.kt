package pa.chan.github_integration_proj.features.detail.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import pa.chan.github_integration_proj.features.detail.data.entity.LicenseInfoEntity

class EntityConverter {

    @TypeConverter
    fun fromLicenseInfoEntityToGson(licenseInfoEntity: LicenseInfoEntity): String {
        return Gson().toJson(licenseInfoEntity)
    }

    @TypeConverter
    fun fromGsonToLicenseInfoEntity(stringLicenseInfoEntity: String): LicenseInfoEntity {
        return Gson().fromJson(stringLicenseInfoEntity, LicenseInfoEntity::class.java)
    }
}