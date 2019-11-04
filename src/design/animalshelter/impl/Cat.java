package design.animalshelter.impl;

import design.animalshelter.Animal;
import design.animalshelter.AnimalType;

public class Cat implements Animal {

	
	private long arrivalTime = 0;
	
	private AnimalType animalType;
	
	public Cat(long arrivalTime){
		this.arrivalTime = arrivalTime;
		this.animalType = AnimalType.CAT;
		
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
		
		return "Cat "+this.arrivalTime;
	}

}
