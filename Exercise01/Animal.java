public class Animal {
    private String name;
    private String nutritionType;
    private Plant [] plantFood = new Plant[10];
    private Animal [] animalFood = new Animal [10];

    public  Animal (String name) {
        this.name = name;
    };

    public void setName () {
        this.name = name;
    }

    public String getName () {
        return name;
    }
    public String getNutritionType () {
        if (isOmnivore()) {
            nutritionType = "omnivore";
        } else if (isHerbivore()) {
            nutritionType = "herbivore";
        } else if (isCarnivore()) {
            nutritionType = "carnivore";
        } else {
            nutritionType = "unknown";
        }
        return nutritionType;
    }
    public Plant [] getPlantFood () {
        return plantFood;
    }
    public Animal [] getAnimalFood () {
        return animalFood;
    }

    // Methoden zum Hinzufügen von Nahrung
    public void addAnimalFood (Animal animal) {
        for (int i = 0; i < animalFood.length; i++) {
            if (animalFood[i] == null) {
                animalFood[i] = animal;
                break;
            }
        }
    }
    public void addPlantFood(Plant plant) {
        for (int i = 0; i < plantFood.length; i++) {
            if (plantFood[i] == null) {
                plantFood[i] = plant;
                break;
            }
        }
    }

  
    public boolean isOmnivore () {
        return (eatsAnimal() && eatsPlant());
    }
    public boolean isCarnivore () {
        return (eatsAnimal() && !eatsPlant());
    }
    public boolean isHerbivore () {
        return (eatsPlant() && !eatsAnimal());
    }

    // Hilfsmethoden
    private boolean eatsPlant () {
        for (int i = 0; i < plantFood.length; i++) {
            if (getPlantFood()[i] != null) {
                return true;
            }
        }
        return false;
    }

    private boolean eatsAnimal () {
        for (int i = 0; i < animalFood.length; i++) {
            if (getAnimalFood()[i] != null) {
                return true;
            }
        }
        return false;
    }
}
