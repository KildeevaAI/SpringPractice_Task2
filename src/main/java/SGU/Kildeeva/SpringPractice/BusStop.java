package SGU.Kildeeva.SpringPractice;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "BUSSTOP")
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAMESTOP", nullable = false)
    private String nameStop;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "busStops")
    private Set<Bus> buses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStop() {
        return nameStop;
    }

    public void setNameStop(String nameStop) {
        this.nameStop = nameStop;
    }

    public Set<Bus> getBuses() {
        return buses;
    }

    public void setBuses(Set<Bus> buses) {
        this.buses = buses;
    }
}
