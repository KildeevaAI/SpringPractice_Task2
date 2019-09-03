package SGU.Kildeeva.SpringPractice;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "BUS")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NUMBER", nullable = false)
    private int number;

    @Column(name = "CAPACITY")
    private int capacity;

    @ManyToMany
    @JoinTable(name = "BUSSTOPDETAILS",
            joinColumns = @JoinColumn(name = "BUS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "BUSSTOP_ID", referencedColumnName = "ID")
    )
    private Set<BusStop> busStops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(Set<BusStop> busStops) {
        this.busStops = busStops;
    }
}
