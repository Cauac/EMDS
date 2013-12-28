package by.vsu.emdsproject.dao;

public class SpecialtyDAO extends MongoDAO {

    public static final String SPECIALTY_COLLECTION_NAME = "specialty";

    @Override
    public String getCollectionName() {
        return SPECIALTY_COLLECTION_NAME;
    }
}
