package org.lxy.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class MyErrorAppender extends AppenderBase<ILoggingEvent> {

    @PostConstruct
    public void init(){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        this.name = "MyErrorAppender";
        this.setContext(loggerContext);
        loggerContext.getLogger("ROOT").addAppender(this);
        this.start();
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        String formattedMessage = iLoggingEvent.getFormattedMessage();
        if (Level.ERROR == iLoggingEvent.getLevel()){
            if (null != iLoggingEvent.getThrowableProxy()){
                IThrowableProxy throwableProxy = iLoggingEvent.getThrowableProxy();
                String className = throwableProxy.getClassName();
                String message = throwableProxy.getMessage();
            }
            // do whatever you want
        }
    }
}
