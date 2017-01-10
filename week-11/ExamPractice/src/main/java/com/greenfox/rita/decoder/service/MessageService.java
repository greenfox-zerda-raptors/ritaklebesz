package com.greenfox.rita.decoder.service;

import com.greenfox.rita.decoder.domain.Message;
import com.greenfox.rita.decoder.repository.MessageRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Rita on 2017-01-10.
 */
@Component
@NoArgsConstructor
public class MessageService {
    private MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public String processMessage(Message msg) {
        String s = "";
        String text = msg.getText().toLowerCase();
        int shift = msg.getShift();
        int len = msg.getText().length();
        if (shift >= 0) {
            return decode(len, text, shift, s);
        } else {
            return encode(len, text, shift, s);
        }

    }

    private String decode(int len, String text, int shift, String s) {
        for (int x = 0; x < len; x++) {
            char c = (char) (text.charAt(x) - shift);
            if (c == ' ') {
                s += " ";
            } else if (c < 'a') {
                s += (char) (text.charAt(x) + (26 - shift));
            } else {
                s += c;
            }
        }
        return s;
    }

    private String encode(int len, String text, int shift, String s) {
        for (int x = 0; x < len; x++) {
            char c = (char) (text.charAt(x) + shift);
            if (c == ' ') {
                s += " ";
            } else if (c < 'a') {
                s += (char) (text.charAt(x) + (26 + shift));
            } else {
                s += c;
            }
        }
        return s;
    }

    public void saveNewMessage(Message msg) {
        repository.save(msg);
    }

    public Message getMessage(long id) {
        return repository.findOne(id);
    }
}
