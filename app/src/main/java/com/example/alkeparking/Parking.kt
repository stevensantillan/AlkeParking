package com.example.alkeparking

open class Parking {
    private val vehicles: MutableSet<Vehicle> = mutableSetOf()
    private val parkingSize = 20
    var vehicleExit: Pair<Int, Int> = Pair(0,0)

    fun addVehicle(vehicle: Vehicle): String {
        return with(vehicles) {
            when {
                this.size == parkingSize -> "Sorry, the check-in failed"
                this.add(vehicle) -> "Welcome to AlkeParking #${this.size}"
                else -> "Sorry, the check-in failed"
            }
        }
    }

    fun searchByPlate(plate: String): Vehicle? {
        return vehicles.find {it.plate == plate}
    }

    fun remove(vehicle: Vehicle){
        vehicles.remove(vehicle)
    }

    fun pairList(vehicleExit: Pair<Int, Int>){
        this.vehicleExit = this.vehicleExit.copy(first = vehicleExit.first, second = vehicleExit.second)
        println("${this.vehicleExit.first} vehicles have checked out and have earnings of $${this.vehicleExit.second}")
    }

    fun listVehicles(){
        vehicles.forEach{println(it.plate)}
    }

}