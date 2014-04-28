package by.vsu.emdsproject.dao;

public class SpecialtyDAO extends MongoDAO {

    @Override
    public String getCollectionName() {
        return "specialty";
    }
}
