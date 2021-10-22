package Model;

public enum FrequencyEnum {
    UNKNOWN("С неуказанной частотой"),
    EVERY_DAY("Каждый день"),
    ONCE_A_WEEK("Каждую неделю"),
    ONCE_A_MONTH("Каждый месяц");

    private final String value;

    FrequencyEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static FrequencyEnum initFrequency(String str){
        switch (str){
            case "Каждый день":{
                return EVERY_DAY;
            }
            case "Каждую неделю":{
                return ONCE_A_WEEK;
            }
            case "Каждый месяц":{
                return ONCE_A_MONTH;
            }
            default:{
                return UNKNOWN;
            }
        }
    }


}
