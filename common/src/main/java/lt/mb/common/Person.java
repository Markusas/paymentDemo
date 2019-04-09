package lt.mb.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String officialId;
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setOfficialId(String officialId) {
        this.officialId = officialId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getOfficialId() {
        return officialId;
    }

    public String getName() {
        return name;
    }
}
