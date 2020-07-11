package arnab.evol.Entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "mt_unit")
@Access(value=AccessType.FIELD)
public class UnitInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="unit_id")
    private long unit_id;

    @Column(name="unit_name")
    private String unit_name;

    public long getunit_id() {
        return unit_id;
    }

    public void setunit_id(long unit_id) {
        this.unit_id = unit_id;
    }

    public String getunit_name() {
        return unit_name;
    }

    public void setunit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public UnitInfo() {}
    public UnitInfo(long unit_id, String unit_name) {
        this.unit_id = unit_id;
        this.unit_name = unit_name;
    }

    @Override
    public String toString() {
        return "UnitInfo [unit_id=" + unit_id + ", unit_name=" + unit_name + "]";
    }

}
