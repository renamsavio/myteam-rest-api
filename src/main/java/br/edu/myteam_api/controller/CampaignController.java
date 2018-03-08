package br.edu.myteam_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.myteam_api.model.Campaign;
import br.edu.myteam_api.repository.CampaignRepository;

@RestController
@RequestMapping("campaign")
public class CampaignController {

	@Autowired
	private CampaignRepository repository;

	@RequestMapping("{name}")
	public List<Campaign> getCampaignsByName(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

	@RequestMapping
	public List<Campaign> getCampaigns() {
		return repository.findAll();
	}

	@PostMapping("add")
	public ResponseEntity<String> addCampaign(@RequestBody Campaign campaign) {
		repository.save(campaign);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteCampaign(@PathVariable String name) {
		List<Campaign> campaigns = repository.findByName(name);
		if (campaigns.size() == 1) {
			Campaign campaign = campaigns.get(0);
			repository.delete(campaign);

			new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
