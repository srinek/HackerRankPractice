package design.animalshelter.test;

import design.animalshelter.AnimalShelterManager;
import design.animalshelter.AnimalType;
import design.animalshelter.impl.AnimalShelterManagerImpl;
import design.animalshelter.impl.Cat;
import design.animalshelter.impl.CatShelter;
import design.animalshelter.impl.Dog;
import design.animalshelter.impl.DogShelter;

public class AnimalShelterManagerTest {
	
	static AnimalShelterManager manager;
	
	public static void main(String[] args) {
		
		
		
		setup();
		//testGetSpecificAnimal();
		setup();
		//testGetAnyAnimal();
		setup();
		testGetAnyAnimalOrder();
	}

	private static void testGetAnyAnimalOrder() {
		manager.getAnimal(AnimalType.DOG);
		manager.getAnimal(AnimalType.CAT);
		int i = 0;
		while(i++ < 12){
			System.out.println(manager.getAnimal());
		}
		
		
	}

	private static void testGetAnyAnimal() {
		System.out.println(manager.getAnimal());
		
	}

	private static void testGetSpecificAnimal() {
		System.out.println(manager.getAnimal(AnimalType.DOG));
		System.out.println(manager.getAnimal(AnimalType.CAT));
	}

	private static void setup() {
		manager = new AnimalShelterManagerImpl();
		manager.addAnimalShelter(new DogShelter());
		manager.addAnimalShelter(new CatShelter());
		manager.addAnimal(new Dog(1));
		manager.addAnimal(new Dog(2));
		manager.addAnimal(new Dog(5));
		manager.addAnimal(new Dog(8));
		
		manager.addAnimal(new Cat(1));
		manager.addAnimal(new Cat(2));
		manager.addAnimal(new Cat(3));
		manager.addAnimal(new Cat(4));
		manager.addAnimal(new Cat(6));
		manager.addAnimal(new Cat(8));
		manager.addAnimal(new Cat(9));
	}

}
