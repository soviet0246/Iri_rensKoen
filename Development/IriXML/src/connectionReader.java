import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class connectionReader implements Runnable {

	private Socket socket;
	
	public connectionReader(Socket socket) {
		this.socket = socket;
		Thread t = new Thread(this);
        t.start();
	}

	@Override
	public void run() {
		try
        {
            //
            // Read a message sent by client application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);

            ois.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }	
	}
}
