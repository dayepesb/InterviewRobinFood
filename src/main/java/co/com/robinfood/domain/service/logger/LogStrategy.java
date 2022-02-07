package co.com.robinfood.domain.service.logger;

public interface LogStrategy {

    void logInfo(String logInfo);
    void logError(String logError);

}
