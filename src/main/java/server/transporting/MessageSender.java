package server.transporting;

import java.io.Serializable;

/**
 * Created by bakla410 on 08.10.17.
 */
public interface MessageSender {
    void send(Serializable message);
}

