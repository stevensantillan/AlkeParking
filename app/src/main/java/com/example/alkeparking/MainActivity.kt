package com.example.alkeparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {

    val car = Vehicle("AB123CY", VehicleType.AUTO.price, Calendar.getInstance(), "true");
    val moto = Vehicle("OYT533", VehicleType.MOTO.price, Calendar.getInstance(), );
    val minibus = Vehicle("CCC467", VehicleType.MINIBUS.price, Calendar.getInstance(), "true");
    val bus = Vehicle("AE456FA", VehicleType.BUS.price, Calendar.getInstance(), "true");
    val car2 = Vehicle("AB124CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car4 = Vehicle("AB126CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car3 = Vehicle("AB125CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car5 = Vehicle("AB127CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car6 = Vehicle("AB128CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car7 = Vehicle("AB129CY", VehicleType.AUTO.price, Calendar.getInstance(), "true");
    val car8 = Vehicle("AB133CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car9 = Vehicle("AB143CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car10 = Vehicle("AB153CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car11 = Vehicle("AB163CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car12 = Vehicle("AB173CY", VehicleType.AUTO.price, Calendar.getInstance(), "true");
    val car13 = Vehicle("AB183CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car14 = Vehicle("AB193CY", VehicleType.AUTO.price, Calendar.getInstance(), "true");
    val car15 = Vehicle("AB223CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car16 = Vehicle("AB323CY", VehicleType.AUTO.price, Calendar.getInstance(), "true");
    val car17 = Vehicle("AB423CY", VehicleType.AUTO.price, Calendar.getInstance(), );
    val car18 = Vehicle("AB523CY", VehicleType.AUTO.price, Calendar.getInstance(), "true");

    val parking = arrayOf(
        car,
        moto,
        minibus,
        bus,
        car2,
        car3,
        car4,
        car5,
        car6,
        car7,
        car8,
        car9,
        car10,
        car11,
        car12,
        car13,
        car14,
        car15,
        car16,
        car17,
        car18
    )

    var parkingSp = Parkable()

    parking.forEach { println(parkingSp.addVehicle(it)) }

    //Retirar vehiculo

    parkingSp.checkOutVehicle(car.plate)
    parkingSp.checkOutVehicle(bus.plate)

    //Lista Control Admin

    parkingSp.listVehicles()


}
