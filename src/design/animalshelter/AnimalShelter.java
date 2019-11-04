package design.animalshelter;

public interface AnimalShelter {
	
	public void addAnimal(Animal animal);
	
	public Animal getAnimal();
	
	public boolean supports(AnimalType animalType);
	
	public AnimalType getSupportedAnimalType();
	
	public Animal seeTopAnimal();

}
