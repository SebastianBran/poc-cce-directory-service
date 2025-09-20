package com.cce.transaction.application.ports;

public interface MessageQueue {
    void sendMessage(String message);
}
