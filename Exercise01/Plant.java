public class Plant {
    private String plantName;
    private String description;

    public Plant (String plantName, String description ) {
        this.plantName = plantName;
        this.description = description;
    };

    // setter
    public void setName () {
        this.plantName = plantName;
    }
    public void setDescription () {
        this.description = description;
    }
    // getter
    public String getName() {
        return plantName;
    }
    public String getDescription() {
        return description;
    }


}
