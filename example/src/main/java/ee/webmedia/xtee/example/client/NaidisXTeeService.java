package ee.webmedia.xtee.example.client;

import javax.activation.DataHandler;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

public interface NaidisXTeeService {
  DataHandler sendAttachment(DataHandler handler) throws XTeeServiceConsumptionException;
}
