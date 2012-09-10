package ee.webmedia.xtee.client.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.callback.CustomCallback;
import ee.webmedia.xtee.client.service.configuration.DelegatingXTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.configuration.provider.XTeeServiceConfigurationProvider;
import ee.webmedia.xtee.client.service.consumer.XTeeConsumer;
import ee.webmedia.xtee.client.service.extractor.CustomExtractor;
import ee.webmedia.xtee.model.XTeeMessage;

/**
 * Base class for all standard X-tee services implementations. Database name will be determined automatically based on
 * the class name unless it is explicitly defined. The following naming convention is used for that:
 * <code>implementation class name = database name + XTeeServiceImpl</code>
 *
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public abstract class BaseXTeeDatabaseService {

  @Resource
  protected XTeeServiceConfigurationProvider xTeeServiceConfigurationProvider;

  private String database;
  private String wsdlDatabase;


  @PostConstruct
  public void init() {
    if (xTeeServiceConfigurationProvider == null) {
      throw new IllegalStateException("Service configuration provider must be set!");
    }

    // All services must follow the correct name convention, which is the name of the database in the WSDL...
    String className = getClass().getSimpleName();
    int suffixIndex = className.indexOf("XTeeDatabaseImpl");
    if (suffixIndex == -1) {
      suffixIndex = className.indexOf("XTeeServiceImpl");
      if (suffixIndex == -1) {
        throw new IllegalStateException("Can't automatically determine database name because the "
            + "X-tee database service implementation class doesn't follow the naming convention " +
            "('database' + XTeeDatabaseImpl or 'database' + XTeeServiceImpl)");
      }
    }

    // Camelcase support
    wsdlDatabase = className.substring(0, suffixIndex).replaceAll("(.)([A-Z])", "$1-$2").toLowerCase();

    if (database == null) {
      database = wsdlDatabase;
    }
  }

  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input, String method) throws XTeeServiceConsumptionException {
    return send(input, method, null);
  }

  @SuppressWarnings("unchecked")
  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input, String method, String version)
      throws XTeeServiceConsumptionException {
    return (XTeeMessage<O>) getXTeeConsumer().sendRequest(input,
                                                     xTeeServiceConfigurationProvider.createConfiguration(database,
                                                                                                          wsdlDatabase,
                                                                                                          method,
                                                                                                          version));
  }

  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input, String method, String version, final String idCode)
      throws XTeeServiceConsumptionException {
    final XTeeServiceConfiguration xteeConfiguration =
        xTeeServiceConfigurationProvider.createConfiguration(database, wsdlDatabase, method, version);

    DelegatingXTeeServiceConfiguration configuration = new DelegatingXTeeServiceConfiguration(xteeConfiguration) {
      @Override
      public String getIdCode() {
        return idCode != null ? idCode : super.getIdCode();
      }
    };

    XTeeMessage<O> result = getXTeeConsumer().sendRequest(input, configuration);
    return result;
  }

  @SuppressWarnings("unchecked")
  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input,
                                       String method,
                                       String version,
                                       CustomCallback callback,
                                       CustomExtractor extractor) throws XTeeServiceConsumptionException {
    return (XTeeMessage<O>) getXTeeConsumer().sendRequest(input,
                                                     xTeeServiceConfigurationProvider.createConfiguration(database,
                                                                                                          wsdlDatabase,
                                                                                                          method,
                                                                                                          version),
                                                     callback,
                                                     extractor);
  }

  @SuppressWarnings("unchecked")
  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input,
                                       String method,
                                       String version,
                                       CustomCallback callback,
                                       CustomExtractor extractor,
                                       boolean forceDatabaseNamespace) throws XTeeServiceConsumptionException {
    XTeeServiceConfiguration configuration =
        xTeeServiceConfigurationProvider.createConfiguration(database, wsdlDatabase, method, version);
    if (forceDatabaseNamespace) {
      configuration.forceDatabaseNamespace();
    }
    return (XTeeMessage<O>) getXTeeConsumer().sendRequest(input, configuration, callback, extractor);
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public void setxTeeServiceConfigurationProvider(XTeeServiceConfigurationProvider xTeeServiceConfigurationProvider) {
    this.xTeeServiceConfigurationProvider = xTeeServiceConfigurationProvider;
  }

  public String getDatabase() {
    return database;
  }

  protected abstract XTeeConsumer getXTeeConsumer();

}
