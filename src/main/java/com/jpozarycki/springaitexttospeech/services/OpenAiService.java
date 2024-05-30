package com.jpozarycki.springaitexttospeech.services;

import com.jpozarycki.springaitexttospeech.model.Question;

public interface OpenAiService {
    byte[] getSpeech(Question question);
}
