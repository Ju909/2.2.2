package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImp implements CarService {
	private final List<Car> cars;

	{
		cars = new ArrayList<>();
		cars.add(new Car("red", "BMW", 123));
		cars.add(new Car("black", "LADA", 456));
		cars.add(new Car("white", "Skoda", 789));
		cars.add(new Car("green", "Toyota", 101));
		cars.add(new Car("rose", "Mazda", 199));
	}

	@Override
	public List<Car> getCars(){
		return cars;
	}

	@Override
	public List<Car> getCountCars(int count) {
		return cars.stream().limit(count).collect(Collectors.toList());
	}
}
