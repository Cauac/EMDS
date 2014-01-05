package by.vsu.emdsproject.dao;

public class ArchiveDAO extends MongoDAO {

    public static final String ARCHIVE_COLLECTION_NAME = "archive";

    @Override
    public String getCollectionName() {
        return ARCHIVE_COLLECTION_NAME;
    }
}
