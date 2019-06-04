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
import com.repgen.inventorycloud.modal.CurrentStock;
import com.repgen.inventorycloud.modal.DraftDetails;
import com.repgen.inventorycloud.modal.DraftLog;

@Service
public class CriticalStockServiceImpl implements CriticalStockService{
	
	@Override
	public CriticalItem[] ctriticalItems(){
		
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



		//return responseEntity.getBody();



		 ////////////////////////////

		ResponseEntity<CurrentStock[]> responseEntity1=null;
		HttpEntity<String> httpEntity1=new HttpEntity<>("",httpHeaders);

		for(int i=0;i<responseEntity.getBody().length;i++){
			responseEntity1=restTemplate.exchange("http://localhost:8283/log/viewCurrentStock/"
							.concat(responseEntity.getBody()[i].getBrand().getId()+"/"+responseEntity.getBody()[i].getId()
									+"/"+responseEntity.getBody()[i].getuOm().getId())
					,HttpMethod.GET,httpEntity1, CurrentStock[].class);

			responseEntity.getBody()[0].setQuentity(responseEntity1.getBody()[0].getQuantity().intValue());

		}


		//////////////////////////////
				// CriticalItem[] criticalItems = responseEntity.getBody();
	//	String response = "response is " + responseEntity.getBody().toString();
//		return response + "/n" + " Quentity is /n" + getQuantity().;
		 //System.out.println(" xxxxxx "+getQuantity()[0].getDraftDetails().get(0).getQuantity() );
		 
		 return responseEntity.getBody();
	}















	////////////////////////////////////////////////////
	
	@Override
	public CurrentStock[] getQuantity(){
		
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
		 responseEntity=restTemplate.exchange("http://localhost:8283/log/viewCurrentStock/".concat(ctriticalItems()[0].getBrand().getId()+"/"+ctriticalItems()[0].getId()+"/"+ctriticalItems()[0].getuOm().getId())
				 ,HttpMethod.GET,httpEntity, CurrentStock[].class);


		String cls = responseEntity.getBody().getClass().getTypeName();
		System.out.println(cls);
		
		 String response =  cls  + "response is " + responseEntity.getBody().toString();
		 
		return responseEntity.getBody();
	}
}
