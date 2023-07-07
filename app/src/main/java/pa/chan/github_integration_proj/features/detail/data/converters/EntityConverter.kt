package pa.chan.github_integration_proj.features.detail.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import pa.chan.github_integration_proj.features.detail.data.entity.LicenseEntity
import pa.chan.github_integration_proj.features.detail.data.entity.LicenseInfoEntity
import pa.chan.github_integration_proj.features.detail.data.entity.ReadmeEntity
import pa.chan.github_integration_proj.features.detail.data.entity.RepoDetailEntity

class EntityConverter {

    @TypeConverter
    fun fromLicenseInfoEntityToGson(licenseInfoEntity: LicenseInfoEntity): String {
        return Gson().toJson(licenseInfoEntity)
    }

    @TypeConverter
    fun fromGsonToLicenseInfoEntity(stringLicenseInfoEntity: String): LicenseInfoEntity {
        return Gson().fromJson(stringLicenseInfoEntity, LicenseInfoEntity::class.java)
    }

    @TypeConverter
    fun fromLicenseEntityToGson(licenseEntity: LicenseEntity?): String {
        return Gson().toJson(licenseEntity)
    }

    @TypeConverter
    fun fromGsonToLicenseEntity(stringLicenseEntity: String): LicenseEntity? {
        return Gson().fromJson(stringLicenseEntity, LicenseEntity::class.java)
    }

    @TypeConverter
    fun fromGsonToReadmeEntity(stringReadmeEntity: String): ReadmeEntity? {
        return Gson().fromJson(stringReadmeEntity, ReadmeEntity::class.java)
    }

    @TypeConverter
    fun fromReadmeEntityToGson(readmeEntity: ReadmeEntity?): String {
        return Gson().toJson(readmeEntity)
    }

    @TypeConverter
    fun fromGsonToRepoDetailEntity(stringRepoDetailEntity: String): RepoDetailEntity? {
        return Gson().fromJson(stringRepoDetailEntity, RepoDetailEntity::class.java)
    }

    @TypeConverter
    fun fromReadmeEntityToGson(repoDetailEntity: RepoDetailEntity?): String {
        return Gson().toJson(repoDetailEntity)
    }

}