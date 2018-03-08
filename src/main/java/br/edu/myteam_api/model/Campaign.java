package br.edu.myteam_api.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by renamsavio on 07/03/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campaign {

    private String name;
    

    public Campaign(String name) {
        this.name = name;
    }
    
    public Campaign() {}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return "Campaign{" +
                ", name='" + name + '\'';
    }

}
