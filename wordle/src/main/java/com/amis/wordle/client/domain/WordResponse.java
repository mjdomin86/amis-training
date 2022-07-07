package com.amis.wordle.client.domain;

import lombok.Data;

@Data
public class WordResponse {
    private ApiOwner api_owner;
    private Donations donations;
    private Body body;

    public ApiOwner getApi_owner() {
        return api_owner;
    }

    public void setApi_owner(ApiOwner api_owner) {
        this.api_owner = api_owner;
    }

    public Donations getDonations() {
        return donations;
    }

    public void setDonations(Donations donations) {
        this.donations = donations;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
