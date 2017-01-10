package com.greenfox.rita.decoder;

import com.greenfox.rita.decoder.domain.Message;
import com.greenfox.rita.decoder.service.MessageService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rita on 2017-01-10.
 */
public class MessageServiceTest {

    MessageService service = new MessageService();

    @Test
    public void processMessageWithPositiveNumber() throws Exception {
        assertEquals("abc", service.processMessage(new Message(1, 3, "def")));
    }

    @Test
    public void processMessageWithNegativeNumber() throws Exception {
        assertEquals("xyz", service.processMessage(new Message(1, -3, "abc")));
    }
}
