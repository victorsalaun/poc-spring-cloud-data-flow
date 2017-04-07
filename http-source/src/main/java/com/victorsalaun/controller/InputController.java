package com.victorsalaun.controller;

import com.victorsalaun.output.ChannelOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InputController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputController.class.getCanonicalName());

    private final ChannelOutput channelOutput;

    @Autowired
    public InputController(ChannelOutput channelOutput) {
        this.channelOutput = channelOutput;
    }

    @RequestMapping(
            path = "/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void handleRequest(@RequestParam String message) {
        LOGGER.info("Input message: " + message);
        channelOutput.sendMessage(message);
    }

}
