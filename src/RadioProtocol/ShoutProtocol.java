package RadioProtocol;

import java.io.IOException;

public interface ShoutProtocol {
    void sendHeader(boolean meta);
    default void sendStream() throws IOException {};
}
