package com.amis.wordle.client;

import com.amis.wordle.client.domain.WordResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "words", url = "${amis.wordle.word-api-url}")
public interface WordApiClient {

    @GetMapping(path="/random-by-length")
    WordResponse getRandomByLength(@RequestParam(name = "length") int length);

}
