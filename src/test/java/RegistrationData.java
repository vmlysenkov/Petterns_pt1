public class RegistrationData {
    private String name;
    private String phone;
    private String city;

    public RegistrationData(String fullName, String phoneNumber, String cityName) {
        this.name = fullName;
        this.phone = phoneNumber;
        this.city = cityName;
    }

    @Override
    public String toString() {
        return "RegistrationData{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}