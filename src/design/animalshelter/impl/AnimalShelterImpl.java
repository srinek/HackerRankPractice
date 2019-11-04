package design.animalshelter.impl;

import java.util.LinkedList;
import java.util.Queue;

import design.animalshelter.Animal;
import design.animalshelter.AnimalShelter;
import design.animalshelter.AnimalType;

public abstract class AnimalShelterImpl implements AnimalShelter{
	
	
	private AnimalType supportedAnimalType;
	
	private Queue<Animal> animalQueue = new LinkedList<>();
	
	@Override
	public void addAnimal(Animal animal) {
		this.animalQueue.add(animal);
		
	}
	
	public AnimalShelterImpl(AnimalType supportedAnimalType){
		this.supportedAnimalType = supportedAnimalType;
	}
	
	@Override
	public Animal getAnimal() {
		return animalQueue.poll();
	}

	@Override
	public boolean supports(AnimalType animalType) {
		return animalType == supportedAnimalType;
	}

	@Override
	public AnimalType getSupportedAnimalType() {
		return supportedAnimalType;
	}

	@Override
	public Animal seeTopAnimal() {
		return animalQueue.peek();
	}

}
