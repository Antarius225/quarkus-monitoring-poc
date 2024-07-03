package be.abalon.controllers;

import be.abalon.entities.Monitoring;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.websockets.next.*;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebSocket(path = "/dashboard/monitoring")
public class MonitoringWebSocket {

    private static final Logger log = LoggerFactory.getLogger(MonitoringWebSocket.class);
    @Inject
    WebSocketConnection connection;

    @Inject
    OpenConnections webSocketConnections;

    @OnOpen(broadcast = true)
    public void onOpen() {
        log.info("Monitoring dashboard connected");
    }

    @Scheduled(every = "5s")
    void sendDataToClient() {
        for (WebSocketConnection webSocketConnection : webSocketConnections) {
            webSocketConnection.sendTextAndAwait(Monitoring.listAll());
        }
    }

    @OnClose
    public void onClose() {
        log.info("Monitoring dashboard disconnected");
        connection.broadcast().sendTextAndAwait("Bye to the monitoring dashboard");
    }
}
