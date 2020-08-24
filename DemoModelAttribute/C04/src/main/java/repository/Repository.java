package repository;

import java.util.List;

public interface Repository<T> {
   List<T> findAll();
   void save(T t);
   void delete(int id);
   T findById(int id);
}
