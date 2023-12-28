import java.util.Objects;

// Інтерфейс для послуг салону краси
interface BeautyService {
    void provideService();
}

// Абстрактний клас "Працівник салону краси"
abstract class SalonEmployee {
    private final String name;


    // Конструктор для ім'я працівника
    public SalonEmployee(String name) {
        this.name = name;
    }

    // Геттер для отримання імені працівника
    public String getName() {
        return name;
    }

    // Абстрактний метод, що представляє роботу працівника
    public abstract void work();
}

// Кінцевий клас "Перукар"
class Hairdresser extends SalonEmployee implements BeautyService {
    // Конструктор для ім'я перукаря
    public Hairdresser(String name) {
        super(name);
    }

    // Реалізація абстрактного методу з батьківського класу
    @Override
    public void work() {
        System.out.println(getName() + " is cutting hair.");
    }

    // Реалізація методу інтерфейсу BeautyService
    @Override
    public void provideService() {
        System.out.println(getName() + " is providing hairdressing service.");
    }

    // Перевизначення методу toString для зручного виведення об'єкта в рядок
    @Override
    public String toString() {
        return "Hairdresser{" +
                "name='" + getName() + '\'' +
                '}';
    }

    // Перевизначення методів equals() та hashCode() для коректного порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hairdresser that = (Hairdresser) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

// Кінцевий клас "Масажист"
class Masseur extends SalonEmployee implements BeautyService {
    // Конструктор для ім'я масажиста
    public Masseur(String name) {
        super(name);
    }

    // Реалізація абстрактного методу з батьківського класу
    @Override
    public void work() {
        System.out.println(getName() + " is giving a massage.");
    }

    // Реалізація методу інтерфейсу BeautyService
    @Override
    public void provideService() {
        System.out.println(getName() + " is providing massage service.");
    }

    // Перевизначення методу toString для зручного виведення об'єкта в рядок
    @Override
    public String toString() {
        return "Masseur{" +
                "name='" + getName() + '\'' +
                '}';
    }

    // Перевизначення методів equals() та hashCode() для коректного порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Masseur masseur = (Masseur) o;
        return Objects.equals(getName(), masseur.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

// Окремий клас "Адреса"
class Address {
    private final String street;


    // Конструктор для ініціалізації адреси
    public Address(String street) {
        this.street = street;
    }

    // Перевизначення методу toString для зручного виведення об'єкта в рядок
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                '}';
    }
}

// Головний клас програми
public class BeautySalonApp {
    public static void main(String[] args) {
        // Створення об'єктів
        Hairdresser hairdresser = new Hairdresser("John");
        Masseur masseur = new Masseur("Alice");
        Address salonAddress = new Address("123 Beauty Street");

        // Використання класу обгортки
        int numberOfClients = 10;
        
        // Логіка програми
        System.out.println("Welcome to our beauty salon!");
        System.out.println("Salon address: " + salonAddress);

        System.out.println("\nOur team:");
        System.out.println(hairdresser);
        System.out.println(masseur);

        System.out.println("\nSalon activities:");
        hairdresser.work();
        hairdresser.provideService();

        masseur.work();
        masseur.provideService();

        System.out.println("\nNumber of clients today: " + numberOfClients);

        // Використання методів equals() та toString()
        Hairdresser anotherHairdresser = new Hairdresser("John");
        System.out.println("\nComparing two hairdressers: " + hairdresser.equals(anotherHairdresser));

        System.out.println("\nDetails of the hairdresser: " + hairdresser);

    }
}
