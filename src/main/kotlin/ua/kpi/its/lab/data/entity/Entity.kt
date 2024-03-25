package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "trains")
class Train(
    @Column
    var model: String,

    @Column
    var manufacturer: String,

    @Column
    var type: String,

    @Column
    var commissioningDate: Date,

    @Column
    var seatCount: Int,

    @Column
    var weight: Double,

    @Column
    var hasAirConditioning: Boolean,

    @OneToMany(mappedBy = "train", cascade = [CascadeType.ALL])
    var routes: MutableList<Route> = mutableListOf()
) : Comparable<Train> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    override fun compareTo(other: Train): Int {
        val equal = this.model == other.model && this.commissioningDate.time == other.commissioningDate.time
        return if (equal) 0 else 1
    }

    override fun toString(): String {
        return "Train(model=$model, commissioningDate=$commissioningDate)"
    }
}

@Entity
@Table(name = "routes")
class Route(
    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    var train: Train,

    @Column
    var departurePoint: String,

    @Column
    var destination: String,

    @Column
    var departureDate: Date,

    @Column
    var distance: Double,

    @Column
    var ticketPrice: BigDecimal,

    @Column
    var isCircular: Boolean
) : Comparable<Route> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    override fun compareTo(other: Route): Int {
        val equal = this.departurePoint == other.departurePoint && this.destination == other.destination && this.departureDate.time == other.departureDate.time
        return if (equal) 0 else 1
    }

    override fun toString(): String {
        return "Route(departurePoint=$departurePoint, destination=$destination, departureDate=$departureDate)"
    }
}