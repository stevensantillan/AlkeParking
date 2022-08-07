package com.example.alkeparking

import java.util.*

data class Vehicle(
    val plate: String,
    val vehicleType: Int,
    var checkInTime: Calendar,
    var discountCard: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }

}
