package Practice.classSample;

public enum DogBreed {
    GERMAN_SHEPHERD("German shepherds can be very gentle companions and family protectors with proper training and socialization."),
    BULLDOG("the Bulldog is a thick-set, low-slung, well-muscled bruiser whose 'sourmug' face is the universal symbol of courage and tenacity."),
    LABRADOR_RETRIEVER("The Labrador is a loyal companion, babysitter and best friend, so could well be the perfect family dog."),
    SIBERIAN_HUSKY("The Siberian Husky is a medium-sized working sled dog breed.");

    private final String description;

    DogBreed(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
