import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSocketHandler {

	
	ServerSocket server;
	int portNumber;
	/**
	 * @param args
	 */
	public ServerSocketHandler() {
		portNumber = 7777;
		try {
			server = new ServerSocket(portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleConnection() {
        //System.out.println("Waiting for client message...");

        //
        // The server do a loop here to accept all connection initiated by the
        // client application.
        //
        while (true) {
            try {
                Socket socket = server.accept();
                new connectionReader(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
