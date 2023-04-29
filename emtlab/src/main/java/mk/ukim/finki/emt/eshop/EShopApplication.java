package mk.ukim.finki.emt.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class EShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EShopApplication.class, args);
    }


}
