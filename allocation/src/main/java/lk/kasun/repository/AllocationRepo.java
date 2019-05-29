package lk.kasun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.kasun.model.Allocation;

public interface AllocationRepo extends JpaRepository<Allocation, Integer> {

	
	
	public List<Allocation> findByempId(Integer empId);
}
