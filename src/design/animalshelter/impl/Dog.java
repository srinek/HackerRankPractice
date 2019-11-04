package design.animalshelter.impl;

import design.animalshelter.Animal;
import design.animalshelter.AnimalType;

public class Dog implements Animal {

	
	private long arrivalTime = 0;
	private AnimalType animalType;
	
	public Dog(long arrivalTime){
		this.arrivalTime = arrivalTime;
		this.animalType = AnimalType.DOG;
	}
	
	@Override
	public long getArrivalTime() {
		
		return arrivalTime;
	}
	
	
	@Override
	public AnimalType getAnimalType() {
		return this.animalType;
	}
	
	@Override
	public String toString() {
		
		return "Dog "+this.arrivalTime;
	}

}
