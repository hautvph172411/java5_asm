 package com.lab.crud.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lab.crud.entities.Lamp;
import com.lab.crud.entities.LampOrigin;
@Repository
public interface ILampRepository extends JpaRepository<Lamp, Integer> {
	List<Lamp> findByOrigin(LampOrigin origin);
	@Query("SELECT l FROM Lamp l WHERE l.name like ?1")
	List<Lamp> findByNameLike(String name);
	@Query("SELECT l FROM Lamp l WHERE l.name like ?1 and l.origin=?2")
	List<Lamp> findByNameLikeAndOrigin(String name,LampOrigin origin);
	Page<Lamp> findByOrigin(LampOrigin origin, Pageable pageable);
	
}
