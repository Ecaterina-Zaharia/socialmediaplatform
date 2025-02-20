package repository;

import entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(String eventName);
    List<Event> findByLocation(String location);
}
