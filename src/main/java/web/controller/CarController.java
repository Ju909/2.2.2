package web.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping()
	public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
		if (count == null) {
			model.addAttribute("cars", carService.getCars());
		} else {
			model.addAttribute("cars", carService.getCountCars(count));
		}
		return "cars";
	}
	
}