package com.nortal.jroad.example.client;

import jakarta.activation.DataHandler;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

public interface NaidisXTeeService {
  DataHandler sendAttachment(DataHandler handler) throws XTeeServiceConsumptionException;
}
