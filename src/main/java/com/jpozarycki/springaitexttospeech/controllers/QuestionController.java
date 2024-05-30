package com.jpozarycki.springaitexttospeech.controllers;

import com.jpozarycki.springaitexttospeech.services.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final OpenAiService openAiService;

}
