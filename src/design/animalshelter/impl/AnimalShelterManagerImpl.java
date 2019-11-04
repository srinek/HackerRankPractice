package design.animalshelter.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import design.animalshelter.Animal;
import design.animalshelter.AnimalShelter;
import design.animalshelter.AnimalShelterManager;
import design.animalshelter.AnimalType;

public class AnimalShelterManagerImpl implements AnimalShelterManager{

	Map<AnimalType, AnimalShelter> animalShelters = new HashMap<>();
	
	public AnimalShelterManagerImpl(){
		
	}
	



	@Override
	public Animal getAnimal() {
		
		Collection<AnimalShelter> allShelters = this.animalShelters.values();
		
		Animal oldestAnimal = null;
		AnimalShelter oldestShelter = null;
		int count = 1;
		for(AnimalShelter animalShelter : allShelters){
			
			Animal	tempAnimal = animalShelter.seeTopAnimal();
			if(oldestAnimal == null){
				oldestAnimal =  count == allShelters.size() ? animalShelter.getAnimal() : tempAnimal;
				oldestShelter = animalShelter;
			}
			else{
				if(oldestAnimal.getArrivalTime() <= tempAnimal.getArrivalTime()){
					oldestAnimal = oldestShelter.getAnimal();
				}
				else{
					oldestAnimal = animalShelter.getAnimal();
					oldestShelter = animalShelter;
				}
				
			}
			count++;
		}
		
		if(oldestAnimal == null){
			// throw AnimalNotAvailable Exception
		}
		return oldestAnimal;
	}

	@Override
	public Animal getAnimal(AnimalType animalType) {

		if(this.animalShelters.get(animalType) == null){
			// throw exception
		}
		
		return this.animalShelters.get(animalType).getAnimal();
	}




	@Override
	public void addAnimalShelter(AnimalShelter shelter) {
		this.animalShelters.put(shelter.getSupportedAnimalType(), shelter);
	}




	@Override
	public void addAnimal(Animal animal) {
		
		AnimalShelter animalShelter = this.animalShelters.get(animal.getAnimalType());
		if(animalShelter == null){
			//throw Exception AnimalShelterNotAvailable
		}
		animalShelter.addAnimal(animal);
		
	}

}
