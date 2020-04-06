package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> listAllCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Nissan", "X-Trail", 2));
        cars.add(new Car("Peugeot", "307", 111));
        cars.add(new Car("KIA", "Sportage", 1));
        cars.add(new Car("Renault", "Logan", 3));
        return cars;
        }
}
