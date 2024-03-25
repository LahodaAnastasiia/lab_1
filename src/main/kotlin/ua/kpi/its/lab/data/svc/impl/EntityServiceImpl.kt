package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Train
import ua.kpi.its.lab.data.entity.Route
import ua.kpi.its.lab.data.repo.TrainRepository
import ua.kpi.its.lab.data.repo.RouteRepository
import ua.kpi.its.lab.data.svc.TrainService
import ua.kpi.its.lab.data.svc.RouteService

@Service
class TrainServiceImpl @Autowired constructor(
    private val repository: TrainRepository
) : TrainService {

    override fun create(train: Train): Train {
        if (train.id != -1L && repository.existsById(train.id)) {
            throw IllegalArgumentException("Train with ID = ${train.id} already exists")
        }
        return repository.save(train)
    }

    override fun read(): List<Train> {
        return repository.findAll()
    }

    override fun readByIndex(index: Int): Train {
        val trains = this.read()
        if (index < 0 || index >= trains.size) {
            throw IndexOutOfBoundsException("Index $index is out of bounds for trains list")
        }
        return trains[index]
    }

    override fun update(train: Train): Train {
        if (!repository.existsById(train.id)) {
            throw IllegalArgumentException("Train with ID = ${train.id} not found")
        }
        return repository.save(train)
    }

    override fun delete(train: Train) {
        if (!repository.existsById(train.id)) {
            throw IllegalArgumentException("Train with ID = ${train.id} not found")
        }
        repository.deleteById(train.id)
    }

    override fun deleteByIndex(index: Int): Train {
        val target = this.readByIndex(index)
        this.delete(target)
        return target
    }
}

@Service
class RouteServiceImpl @Autowired constructor(
    private val repository: RouteRepository
) : RouteService {

    override fun create(route: Route): Route {
        if (route.id != -1L && repository.existsById(route.id)) {
            throw IllegalArgumentException("Route with ID = ${route.id} already exists")
        }
        return repository.save(route)
    }

    override fun read(): List<Route> {
        return repository.findAll()
    }

    override fun readByIndex(index: Int): Route {
        val routes = this.read()
        if (index < 0 || index >= routes.size) {
            throw IndexOutOfBoundsException("Index $index is out of bounds for routes list")
        }
        return routes[index]
    }

    override fun update(route: Route): Route {
        if (!repository.existsById(route.id)) {
            throw IllegalArgumentException("Route with ID = ${route.id} not found")
        }
        return repository.save(route)
    }

    override fun delete(route: Route) {
        if (!repository.existsById(route.id)) {
            throw IllegalArgumentException("Route with ID = ${route.id} not found")
        }
        repository.deleteById(route.id)
    }

    override fun deleteByIndex(index: Int): Route {
        val target = this.readByIndex(index)
        this.delete(target)
        return target
    }
}