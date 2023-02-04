package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Server s = new Server(9999, 64);
        s.addHandler("GET", "/messages", ((request, responseStream) -> {
            try {
                s.responseWithoutContent(responseStream, "404", "Not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));

        s.addHandler("POST", "/messages", (request, responseStream) ->
                s.responseWithoutContent(responseStream, "404", "Not found"));
        s.addHandler("GET", "/", ((request, responseStream) -> s.defaultHandler(responseStream, "spring.png")));
        s.start();
    }
}

