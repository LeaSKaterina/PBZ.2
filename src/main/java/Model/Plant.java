package Model;

import java.util.Date;

public class Plant {
    private Integer id;
    private Date plantingDate;
    private Short age;
    private String type;
    private Watering watering;

    public Plant(Integer id, Date plantingDate, Short age, String type, Watering watering) {
        this.id = id;
        this.plantingDate = plantingDate;
        this.age = age;
        this.type = type;
        this.watering = watering;
    }

    public void init(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public Short getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public Watering getWatering() {
        return watering;
    }

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWatering(Watering watering) {
        this.watering = watering;
    }
}
