package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Train
import ua.kpi.its.lab.data.entity.Route

interface TrainService {
    /**
     * Creates a new Train record.
     *
     * @param train: The Train instance to be inserted
     * @return: The recently created Train instance
     */
    fun create(train: Train): Train

    /**
     * Reads all created Train records.
     *
     * @return: List of created Train records
     */
    fun read(): List<Train>

    /**
     * Reads a Train record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Train record
     * @return: The Train instance at index
     */
    fun readByIndex(index: Int): Train

    /**
     * Updates a Train record data.
     *
     * @param train: The Train instance to be updated (valid id is required)
     * @return: The updated Train record
     */
    fun update(train: Train): Train

    /**
     * Deletes a Train record data.
     *
     * @param train: The Train instance to be deleted (valid `id` is required)
     */
    fun delete(train: Train)

    /**
     * Deletes a Train record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Train record to delete
     * @return: The deleted Train instance at index
     */
    fun deleteByIndex(index: Int): Train
}

interface RouteService {
    /**
     * Creates a new Route record.
     *
     * @param route: The Route instance to be inserted
     * @return: The recently created Route instance
     */
    fun create(route: Route): Route

    /**
     * Reads all created Route records.
     *
     * @return: List of created Route records
     */
    fun read(): List<Route>

    /**
     * Reads a Route record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Route record
     * @return: The Route instance at index
     */
    fun readByIndex(index: Int): Route

    /**
     * Updates a Route record data.
     *
     * @param route: The Route instance to be updated (valid id is required)
     * @return: The updated Route record
     */
    fun update(route: Route): Route

    /**
     * Deletes a Route record data.
     *
     * @param route: The Route instance to be deleted (valid `id` is required)
     */
    fun delete(route: Route)

    /**
     * Deletes a Route record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of Route record to delete
     * @return: The deleted Route instance at index
     */
    fun deleteByIndex(index: Int): Route
}