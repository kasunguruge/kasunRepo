package lk.kasun.service;

import java.util.List;

import lk.kasun.model.Allocation;

public interface AllocationService {

	Allocation save(Allocation allocation);

	List<Allocation> fetchAllAllocation();

	Allocation fetchAllocation(Allocation allocation);

	List<Allocation> findAllocationByEmpId(Integer empId);

}