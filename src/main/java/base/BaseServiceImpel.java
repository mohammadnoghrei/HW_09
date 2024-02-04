package base;

import java.io.Serializable;
import java.sql.SQLException;

public class BaseServiceImpel<ID extends Serializable, TYPE extends Model<ID>, R extends BaseRepository<ID, TYPE>>
        implements BaseService<ID, TYPE> {

    protected final R repository;

    public BaseServiceImpel(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(TYPE entity) throws SQLException {
        repository.save(entity);
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return repository.findBYId(id);
    }

    @Override
    public TYPE findByName(String name) throws SQLException {
        return repository.findBYName(name);
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        repository.update(entity);
    }

    @Override
    public boolean delete(ID id) throws SQLException {

        return repository.delete(id);
    }
}
