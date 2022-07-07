package com.amis.wordle.service.impl;

import com.amis.wordle.client.WordApiClient;
import com.amis.wordle.service.WordleService;
import org.springframework.stereotype.Service;

@Service
public class WordleServiceImpl implements WordleService {

    private final WordApiClient wordApiClient;

    public WordleServiceImpl(WordApiClient wordApiClient) {
        this.wordApiClient = wordApiClient;
    }

    @Override
    public String getRandomWord(int length) {
        return wordApiClient.getRandomByLength(length).getBody().getWord();
    }
}
