package com.repgen.inventorycloud.service;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.repgen.inventorycloud.modal.CriticalItem;
import com.repgen.inventorycloud.modal.CriticalItemsList;
import com.repgen.inventorycloud.modal.CurrentStock;
import com.repgen.inventorycloud.modal.DraftDetails;
import com.repgen.inventorycloud.modal.DraftLog;

@Service
public class CriticalStockServiceImpl implements CriticalStockService{
	
	CriticalItem[] c;
	
	@Override
	public List<CriticalItemsList> ctriticalItems(String date){
		
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders httpHeaders=new HttpHeaders();

//		//extract token from context
//		OAuth2AuthenticationDetails oAuth2AuthenticationDetails =(OAuth2AuthenticationDetails)
//				SecurityContextHolder.getContext().getAuthentication().getDetails();

//		System.out.println(">>>>"+oAuth2AuthenticationDetails.getTokenValue());
//		httpHeaders.add("Authorization","bearer".concat(oAuth2AuthenticationDetails.getTokenValue()));

		//
		ResponseEntity<CriticalItem[]> responseEntity;
		HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);
		 responseEntity=restTemplate.exchange("http://localhost:8080/item/"
				 ,HttpMethod.GET,httpEntity, CriticalItem[].class);

		 List<CriticalItemsList> criticalItems = new ArrayList<>();
		 for(int i = 0 ; i< getQuantity(date).length -1; i++) {
			 
			 for(int j =0 ; j<responseEntity.getBody().length - 1 ;j++) {
				 if((getQuantity(date)[i].getItemId().longValue()==responseEntity.getBody()[j].getId()) &&
						 (getQuantity(date)[i].getBrandId()==responseEntity.getBody()[j].getBrand().getId())
						 && (getQuantity(date)[i].getUomId()==responseEntity.getBody()[j].getBrand().getId()))
				 {
					 if((getQuantity(date)[i].getQuantity(date))<responseEntity.getBody()[j].getCriticalLevel()) {
						 
						 CriticalItemsList critical = new CriticalItemsList();
						 critical.setbName(responseEntity.getBody()[j].getBrand().getName());
						 critical.setItemName(responseEntity.getBody()[j].getName());
						 critical.setCriticalValue(responseEntity.getBody()[j].getCriticalLevel());
						 critical.setQue(getQuantity(date)[i].getQuantity(date));
						 criticalItems.add(critical);
					 }
					
				 }
			 }
		 }
	
		 
		
		
		return criticalItems;
	}
	
	
	@Override
	public CurrentStock[] getQuantity(String date){
		
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders httpHeaders=new HttpHeaders();

//		//extract token from context
//		OAuth2AuthenticationDetails oAuth2AuthenticationDetails =(OAuth2AuthenticationDetails)
//				SecurityContextHolder.getContext().getAuthentication().getDetails();

//		System.out.println(">>>>"+oAuth2AuthenticationDetails.getTokenValue());
//		httpHeaders.add("Authorization","bearer".concat(oAuth2AuthenticationDetails.getTokenValue()));

		//
		ResponseEntity<CurrentStock[]> responseEntity;
		HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

			responseEntity=restTemplate.exchange("http://localhost:8283/log/viewCurrentStockByDate/".concat(date)
					
					 ,HttpMethod.GET,httpEntity, CurrentStock[].class);	
			
		//}
		 


		String cls = responseEntity.getBody().getClass().getTypeName();
		System.out.println(cls);
		
	
		 
		return responseEntity.getBody();
	}
}
