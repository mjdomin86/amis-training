package com.amis.wordle.service.impl;

import com.amis.wordle.service.WordleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class WordleServiceLocalImpl implements WordleService {
    @Override
    public String getRandomWord(int length) {
        return "Holis";
    }
}
