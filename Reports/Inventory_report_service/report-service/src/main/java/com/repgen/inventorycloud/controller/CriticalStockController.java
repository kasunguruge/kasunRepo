package com.repgen.inventorycloud.controller;

import java.util.List;

import com.repgen.inventorycloud.modal.CurrentStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.repgen.inventorycloud.modal.CriticalItem;
import com.repgen.inventorycloud.service.CriticalStockService;

@RestController
@RequestMapping(value = "/reportinservice/criticalitems")
public class CriticalStockController {

	
	@Autowired
	CriticalStockService criticalStockService;
	
	@RequestMapping(method = RequestMethod.GET)
	public CriticalItem[] ctriticalItems() {
		return criticalStockService.ctriticalItems();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getquant")
	public CurrentStock[] getQuantity() {
		return criticalStockService.getQuantity();
	}
	
}
