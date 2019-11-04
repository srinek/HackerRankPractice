package design.animalshelter;

public interface AnimalShelterManager {
	
	
	public Animal getAnimal();
	
	public Animal getAnimal(AnimalType animalType);
	
	public void addAnimalShelter(AnimalShelter shelter);
	
	
	public void addAnimal(Animal animal);

}
