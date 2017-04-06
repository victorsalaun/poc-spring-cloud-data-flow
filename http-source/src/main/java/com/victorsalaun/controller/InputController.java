package com.victorsalaun.controller;

import com.victorsalaun.output.ChannelOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InputController {

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
        channelOutput.sendMessage(message);
    }

}
