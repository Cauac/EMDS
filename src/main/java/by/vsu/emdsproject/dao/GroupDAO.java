package by.vsu.emdsproject.dao;

public class GroupDAO extends MongoDAO {

    public static final String GROUP_COLLECTION_NAME = "group";

    @Override
    public String getCollectionName() {
        return GROUP_COLLECTION_NAME;
    }
}
