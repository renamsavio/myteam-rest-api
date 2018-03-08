package br.edu.myteam_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.myteam_api.model.Campaign;

/**
 * Created by renamsavio on 07/03/2018.
 */
public interface CampaignRepository extends MongoRepository<Campaign, String> {

    public List<Campaign> findByName(String name);
}
