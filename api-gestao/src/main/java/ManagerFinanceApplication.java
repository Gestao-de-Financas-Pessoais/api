import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
public class ManagerFinanceApplication {
    //                                    Método que pode lançar exceções
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        SpringApplication.run(ManagerFinanceApplication.class, args);
    }

}