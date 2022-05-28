package urfu.lesson8.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import urfu.lesson8.Data.ToDoList;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    ToDoList findByName(String name);

    @Query(value = "insert into \"ToDoList\" (id, name, events) values (:id, :name, :events)", nativeQuery = true)
    void insertToDoList(@Param("id") Long id, @Param("name") String name, @Param("events") List<String> events);
}
