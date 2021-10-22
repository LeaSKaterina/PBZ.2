package Model;

import java.sql.Date;

public class LabourerDate{

    private String lastName;
    private String firstName;
    private String patronymic;
    private final Date date;
    private String phone;

    public LabourerDate(String lastName, String firstName, String patronymic, String phone, Date date) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.date = date;
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDate(){
        return date;
    }

    public String getPhone() {
        return phone;
    }


}
