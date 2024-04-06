package com.example.lab_2.model
import com.google.gson.annotations.SerializedName

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


data class Celebrity(
    val name: String,
    @SerializedName("net_worth") val netWorth: Long,
    val gender: String? = null,
    val nationality: String? = null,
    val occupation: List<String>? = null,
    val height: Double? = null,
    val birthday: String? = null,
    val age: Int? = null,
    @SerializedName("is_alive") val isAlive: Boolean? = null,
    val death: String? = null
) : Serializable
//) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString() ?: "",
//        parcel.readLong(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.createStringArrayList(),
//        parcel.readValue(Double::class.java.classLoader) as? Double,
//        parcel.readString(),
//        parcel.readValue(Int::class.java.classLoader) as? Int,
//        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
//        parcel.readString()
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeLong(netWorth)
//        parcel.writeString(gender)
//        parcel.writeString(nationality)
//        parcel.writeStringList(occupation)
//        parcel.writeValue(height)
//        parcel.writeString(birthday)
//        parcel.writeValue(age)
//        parcel.writeValue(isAlive)
//        parcel.writeString(death)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Celebrity> {
//        override fun createFromParcel(parcel: Parcel): Celebrity {
//            return Celebrity(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Celebrity?> {
//            return arrayOfNulls(size)
//        }
//    }
