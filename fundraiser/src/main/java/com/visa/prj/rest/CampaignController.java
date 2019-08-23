package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;
import com.visa.prj.service.CampaignService;

@RestController
public class CampaignController {
@Autowired
private CampaignService cs;

@GetMapping("campaigns")
public @ResponseBody List<Campaign> getCampaigns(){
	return cs.getCampaigns();
}

@GetMapping("campaigns/{title}")
public @ResponseBody Campaign getCampaignById(@PathVariable("title") String title) {
	return cs.getCampaignById(title);
}

@GetMapping("donations")
public @ResponseBody List<Donation> getDonations(){
	return cs.getDonations();
}
@PostMapping("campaigns")
public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign p){
	//RequestBody Sees the content type and converts Representation into Java
	cs.saveCampaign(p);
	return new ResponseEntity<>(p,HttpStatus.CREATED);
}
@PostMapping("donations")
public ResponseEntity<Donation> addDonation(@RequestBody Donation p){
	//RequestBody Sees the content type and converts Representation into Java
	cs.saveDonation(p);
	return new ResponseEntity<>(p,HttpStatus.CREATED);
}

}
