package com.example.alkeparking

import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

class Parkable: Parking(){

    var checkInTime = Calendar.getInstance()
    var exitPark = Calendar.getInstance()
    var feeTwoHours = 120
    var costTotal = 0
    var subTotal = 0L
    var parkedTime = 0L
    var vehicleCounter = 0
    var saveCostList = 0


    //Calcular Tiempo en Garage

    fun parkedTime(checkInTime: Calendar) =
        (exitPark.timeInMillis - checkInTime.timeInMillis) / TimeUnit.MINUTES.toMillis(1)

    //Calcular Precio a pagar

    fun calculateFee (VehicleType: Int,
                      parkedTime: Long,
                      discountCard: String?,): Int
    {
        val totalPrice = when {
            parkedTime <= feeTwoHours -> VehicleType
            parkedTime > feeTwoHours -> {
                (VehicleType + with(parkedTime - feeTwoHours){
                    subTotal = this
                    var additionalFee = 0
                    while (subTotal > 0){
                        additionalFee +=5
                        subTotal -=15
                    }
                    additionalFee
                })
            }
            else -> 0
        }
        return discountCard?.let{ (totalPrice*0.75).roundToInt()}?: totalPrice
    }

    //Salir del Garage

    fun checkOutVehicle(plate: String){
        searchByPlate(plate)?.let{
            parkedTime = parkedTime(it.checkInTime)
            costTotal = calculateFee(it.vehicleType, parkedTime, it.discountCard)
            onSuccess(costTotal)
            remove(it)
            vehicleCounter ++
            saveCostList += costTotal
            pairList(Pair(vehicleCounter,saveCostList))
        }?: onError()}

    fun onSuccess(totalPrice: Int){
        println( "Your fee is $${totalPrice}. Come back soon.")
    }

    fun onError(){
        println("Sorry, the check-in failed")
    }
}