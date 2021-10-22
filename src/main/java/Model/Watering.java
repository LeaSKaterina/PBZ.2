package Model;

import java.sql.Time;

public class Watering {
    private final Integer id;
    private FrequencyEnum frequency;
    private Time time;
    private Float amountOfWater;

    public Watering(Integer id, FrequencyEnum frequency, Time time, Float amountOfWater) {
        this.id = id;
        this.frequency = frequency;
        this.time = time;
        this.amountOfWater = amountOfWater;
    }

    public Integer getId() {
        return id;
    }

    public FrequencyEnum getFrequency() {
        return frequency;
    }

    public Time getTime() {
        return time;
    }

    public Float getAmountOfWater() {
        return amountOfWater;
    }

    public void setFrequency(FrequencyEnum frequency) {
        this.frequency = frequency;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setAmountOfWater(Float amountOfWater) {
        this.amountOfWater = amountOfWater;
    }

    public String toString(){
        return frequency.toString() + " в " + time.toString() + " по " + amountOfWater.toString();
    }
}
