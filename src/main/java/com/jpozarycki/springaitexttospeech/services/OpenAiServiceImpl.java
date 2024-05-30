package com.jpozarycki.springaitexttospeech.services;

import com.jpozarycki.springaitexttospeech.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpenAiServiceImpl implements OpenAiService {
    private final OpenAiAudioSpeechModel openAiAudioSpeechModel;

    @Override
    public byte[] getSpeech(Question question) {
        OpenAiAudioSpeechOptions options = OpenAiAudioSpeechOptions.builder()
                .withVoice(OpenAiAudioApi.SpeechRequest.Voice.ONYX)
                .withSpeed(1f)
                .withResponseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                .withModel(OpenAiAudioApi.TtsModel.TTS_1.getValue())
                .build();

        SpeechPrompt speechPrompt = new SpeechPrompt(question.question(), options);

        SpeechResponse response = openAiAudioSpeechModel.call(speechPrompt);
        return response.getResult().getOutput();
    }
}
