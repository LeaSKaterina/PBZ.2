package Model;

public class Decorator{
    private Integer id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String phone;
    private String address;
    private String education;
    private String nameOfInstitution;
    private String category;

    public Decorator(Integer id, String lastName, String firstName, String patronymic, String phone, String address, String education, String nameOfInstitution, String category) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.nameOfInstitution = nameOfInstitution;
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setNameOfInstitution(String nameOfInstitution) {
        this.nameOfInstitution = nameOfInstitution;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEducation() {
        return education;
    }

    public String getNameOfInstitution() {
        return nameOfInstitution;
    }

    public String getCategory() {
        return category;
    }
}
