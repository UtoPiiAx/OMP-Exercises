public class BioTest {
    public static void main (String [] args) {
        Plant gras = new Plant ("Gras", "grün");
        Plant berries = new Plant ("Beeren", "rot");
        Animal zebra = new Animal ("Zebra");
        Animal bear = new Animal ("Bär");
        Animal lion = new Animal ("Löwe");
        Animal fish = new Animal ("Fisch");

        zebra.addPlantFood(gras);
        lion.addAnimalFood(zebra);
        bear.addPlantFood(berries);
        bear.addAnimalFood(fish);

        System.out.println(gras.getName() + " ist " + gras.getDescription() + ".");
        System.out.println(berries.getName() + " sind " + berries.getDescription() + ".");

        Plant [] zebraFood = zebra.getPlantFood();
        Animal [] lionFood = lion.getAnimalFood();
        Plant [] bearFood = bear.getPlantFood();
        Animal [] bearFood2 = bear.getAnimalFood();

        System.out.println(zebra.getName() + "s fressen " + zebraFood[0].getName() + ".");
        System.out.println(lion.getName() + "n fressen " + lionFood[0].getName() + "s. ");
        System.out.println(bear.getName() + "en fressen " + bearFood[0].getName() + ".");
        System.out.println(bear.getName() + "en fressen " + bearFood2[0].getName() + "e.");

        System.out.println(zebra.getName() + " is a " + zebra.getNutritionType() + ".");
        System.out.println(lion.getName() + " is a " + lion.getNutritionType() + ".");
        System.out.println(bear.getName() + " is an " + bear.getNutritionType() + ".");
    }
}