package com.repgen.inventorycloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.repgen.inventorycloud.modal.CriticalItem;
import com.repgen.inventorycloud.modal.CriticalItemsList;
import com.repgen.inventorycloud.modal.CurrentStock;
import com.repgen.inventorycloud.service.CriticalStockService;

@RestController
@RequestMapping(value = "/reportinservice/criticalitems")
public class CriticalStockController {

	
	@Autowired
	CriticalStockService criticalStockService;
	
	@RequestMapping(method = RequestMethod.GET ,value = "{date}")
	public List<CriticalItemsList> ctriticalItems(@PathVariable String date) {
		return criticalStockService.ctriticalItems(date);
	}

}
