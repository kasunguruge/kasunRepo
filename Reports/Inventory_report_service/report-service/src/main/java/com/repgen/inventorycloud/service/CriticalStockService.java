package com.repgen.inventorycloud.service;

import java.util.List;

import com.repgen.inventorycloud.modal.CriticalItem;
import com.repgen.inventorycloud.modal.CurrentStock;
import com.repgen.inventorycloud.modal.DraftDetails;
import com.repgen.inventorycloud.modal.DraftLog;

public interface CriticalStockService {
	CriticalItem[] ctriticalItems();
	CurrentStock[] getQuantity();
}
