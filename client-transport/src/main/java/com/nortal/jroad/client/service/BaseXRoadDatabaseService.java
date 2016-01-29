package com.nortal.jroad.client.service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.DelegatingXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XTeeMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Base class for all standard X-Road services implementations. Database name will be determined automatically based on
 * the class name unless it is explicitly defined. The following naming convention is used for that:
 * <code>implementation class name = database name + XTeeServiceImpl/XRoadServiceImpl</code>
 *
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public abstract class BaseXRoadDatabaseService {

  private static final String DATABASE_SERVICE_PATTERN = "(.+?)X(Tee|Road)(Database|Service)Impl";

  @Resource
  protected XRoadServiceConfigurationProvider xRoadServiceConfigurationProvider;

  private String database;
  private String wsdlDatabase;


  @PostConstruct
  public void init() {
    if (xRoadServiceConfigurationProvider == null) {
      throw new IllegalStateException("Service configuration provider must be set!");
    }

    // All services must follow the correct name convention, which is the name of the database in the WSDL...
    String className = getClass().getSimpleName();
    Pattern p = Pattern.compile(DATABASE_SERVICE_PATTERN);
    Matcher m = p.matcher(className);
    if (!m.matches()) {
      throw new IllegalStateException("Can't automatically determine database name because the " + className
          + " X-road database service implementation class doesn't follow the naming convention "
          + "('database' + XTeeDatabaseImpl or 'database' + XRoadDatabaseImpl "
          + "or 'database' + XTeeServiceImpl or 'database' + XRoadServiceImpl)");
    }

    // Camelcase support
    wsdlDatabase = m.group(1).replaceAll("(.)([A-Z])", "$1-$2").toLowerCase();

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
    return (XTeeMessage<O>) getXRoadConsumer().sendRequest(input,
                                                     xRoadServiceConfigurationProvider.createConfiguration(database,
                                                                                                          wsdlDatabase,
                                                                                                          method,
                                                                                                          version));
  }

  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input, String method, String version, final String idCode)
      throws XTeeServiceConsumptionException {
    final BaseXRoadServiceConfiguration xteeConfiguration =
        xRoadServiceConfigurationProvider.createConfiguration(database, wsdlDatabase, method, version);

    DelegatingXRoadServiceConfiguration configuration = new DelegatingXRoadServiceConfiguration(xteeConfiguration) {
      @Override
      public String getIdCode() {
        return idCode != null ? idCode : super.getIdCode();
      }
    };

    XTeeMessage<O> result = getXRoadConsumer().sendRequest(input, configuration);
    return result;
  }

  @SuppressWarnings("unchecked")
  protected <I, O> XTeeMessage<O> send(XTeeMessage<I> input,
                                       String method,
                                       String version,
                                       CustomCallback callback,
                                       CustomExtractor extractor) throws XTeeServiceConsumptionException {
    return (XTeeMessage<O>) getXRoadConsumer().sendRequest(input,
                                                           xRoadServiceConfigurationProvider.createConfiguration(database,
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
    BaseXRoadServiceConfiguration configuration =
        xRoadServiceConfigurationProvider.createConfiguration(database, wsdlDatabase, method, version);
    if (forceDatabaseNamespace) {
      configuration.forceDatabaseNamespace();
    }
    return (XTeeMessage<O>) getXRoadConsumer().sendRequest(input, configuration, callback, extractor);
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public void setRoadServiceConfigurationProvider(XRoadServiceConfigurationProvider xRoadServiceConfigurationProvider) {
    this.xRoadServiceConfigurationProvider = xRoadServiceConfigurationProvider;
  }

  public String getDatabase() {
    return database;
  }

  protected abstract XRoadConsumer getXRoadConsumer();

}
