package lk.kasun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.kasun.model.Allocation;
import lk.kasun.service.AllocationService;


@RestController
@RequestMapping(value = "/allocation")
public class AllocationController {

	@Autowired
	AllocationService allocationService;

	@RequestMapping(value = "/setAllocation", method = RequestMethod.POST)
	public Allocation save(@RequestBody Allocation employee) {
		return allocationService.save(employee);
	}

	@RequestMapping(value = "/getAllocation", method = RequestMethod.GET)
	public List<Allocation> fetchAllAllocation() {
		return allocationService.fetchAllAllocation();
	}
	
	@RequestMapping(value = "/getAllocation/{id}", method = RequestMethod.GET)
	public ResponseEntity<Allocation> fetchAllocation(@PathVariable Integer id) {
		Allocation allocation = new Allocation();
		allocation.setId(id);
		Allocation allocation1 = allocationService.fetchAllocation(allocation);
		if (allocation1 == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(allocation1);
		}
	}
	
	@RequestMapping(value = "/employee/{empid}", method = RequestMethod.GET)
	public ResponseEntity<List<Allocation>> fetchEmployee(@PathVariable Integer empid) {
		
		
		return ResponseEntity.ok(allocationService.findAllocationByEmpId(empid));
	}
	
}
