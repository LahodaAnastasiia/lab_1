package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.config.Config
import ua.kpi.its.lab.data.entity.Train
import ua.kpi.its.lab.data.entity.Route
import ua.kpi.its.lab.data.svc.impl.RouteServiceImpl
import ua.kpi.its.lab.data.svc.impl.TrainServiceImpl
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab.data")
    val trainService = context.getBean(TrainServiceImpl::class.java)
    val routeService = context.getBean(RouteServiceImpl::class.java)

    // Створюємо потяги
    val train1 = Train(
        model = "Train Model 1",
        manufacturer = "Manufacturer 1",
        type = "Type 1",
        commissioningDate = Date(),
        seatCount = 110,
        weight = 220.0,
        hasAirConditioning = true
    )
    val train2 = Train(
        model = "Train Model 2",
        manufacturer = "Manufacturer 2",
        type = "Type 2",
        commissioningDate = Date(),
        seatCount = 120,
        weight = 240.0,
        hasAirConditioning = false
    )
    val train3 = Train(
        model = "Train Model 3",
        manufacturer = "Manufacturer 3",
        type = "Type 3",
        commissioningDate = Date(),
        seatCount = 130,
        weight = 260.0,
        hasAirConditioning = true
    )
    val train4 = Train(
        model = "Train Model 4",
        manufacturer = "Manufacturer 4",
        type = "Type 4",
        commissioningDate = Date(),
        seatCount = 140,
        weight = 280.0,
        hasAirConditioning = false
    )
    val train5 = Train(
        model = "Train Model 5",
        manufacturer = "Manufacturer 5",
        type = "Type 5",
        commissioningDate = Date(),
        seatCount = 150,
        weight = 300.0,
        hasAirConditioning = true
    )

    trainService.create(train1)
    trainService.create(train2)
    trainService.create(train3)
    trainService.create(train4)
    trainService.create(train5)

    // Отримуємо потяг з індексом 3
    val selectedTrain = trainService.readByIndex(3)
    println("Selected Train: $selectedTrain")
    // Видаляємо потяг з індексом 4
    val deletedTrain = trainService.readByIndex(4)
    println("Deleted Train: $deletedTrain")
}