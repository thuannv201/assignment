package repositories;

public class NSXRepository extends BaseRepository {
    @Override
    public <T> T save(String className, T obj) {
        return super.save(className, obj);
    }

}
