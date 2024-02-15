package com.cleo.shop.config;

import com.cleo.shop.domain.Battery;
import com.cleo.shop.domain.Car;
import com.cleo.shop.domain.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cleo.shop")
public class ShopConfig {

    @Bean
    public Product duracell(){
        Battery duracell = new Battery(true,2);
        duracell.setName("Duracell");
        duracell.setPrice(10.2);
        return duracell;
    }
    @Bean
    public Product mercedes(){
        Car car = new Car(1000);
        car.setName("Mercedes Benz");
        car.setPrice(10000.0);
        return car;
    }


}
