package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CampaignDao;
import com.visa.prj.dao.DonationDao;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;


@Service
public class CampaignService {
	@Autowired
	private CampaignDao cd;

	public Campaign getCampaignById(String title) {
		return cd.findById(title).get();
	}
	public List<Campaign> getCampaigns(){
		return cd.findAll();
	}
	
	@Transactional
	public String saveCampaign(Campaign c) {
		cd.save(c);
		return c.getTitle();
	}
	
	@Autowired
	private DonationDao dd;
	
	public List<Donation> getDonations(){
		return dd.findAll();
	}
	@Transactional
	public int saveDonation(Donation d) {
		dd.save(d);
		Campaign c = getCampaignById(d.getCampaign().getTitle());
		double amt = c.getAmount();
		double donate = d.getAmount();
		c.setAmount(amt-donate);
		System.out.println("Donation Done");
		return d.getdId();
	}
	
	
	
}
