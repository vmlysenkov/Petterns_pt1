import lombok.Value;

@Value
public class RegistrationData {
    String name;
    String phone;
    String city;

    @Override
    public String toString() {
        return "RegistrationData{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}