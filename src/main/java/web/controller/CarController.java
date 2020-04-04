package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CarController {
    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String allCars(ModelMap model) {
        List<Car> cars = carService.listAllCars();
        String locale = "en";
        //locale = (String) model.getAttribute("locale");
        //String title = (locale.equals("en")) ? "CARS" : "МАШИНЫ";
        //model.addAttribute("title", title);
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("cars", cars);
        return "cars";
    }
}
