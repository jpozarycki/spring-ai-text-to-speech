package com.jpozarycki.springaitexttospeech.controllers;

import com.jpozarycki.springaitexttospeech.model.Question;
import com.jpozarycki.springaitexttospeech.services.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final OpenAiService openAiService;

    @PostMapping(value = "/talk", produces = "audio/mpeg")
    public byte[] talkTalk(@RequestBody Question question) {
        return openAiService.getSpeech(question);
    }
}
