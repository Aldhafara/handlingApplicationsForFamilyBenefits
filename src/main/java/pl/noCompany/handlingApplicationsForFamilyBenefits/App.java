package pl.noCompany.handlingApplicationsForFamilyBenefits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello!");
        SpringApplication.run(App.class, args);
    }

    public void run(String... strings) throws Exception {
        System.out.println("Hello Spring");
    }
}
