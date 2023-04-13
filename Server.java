package main;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private int count = 1;
	
	public Server() throws Exception {
		int x=42+2019;
		ServerSocket ss = new ServerSocket(x);
		System.out.println(x+" connected");
		
		while(true)
		{
			Socket socket = ss.accept();
			ServerThread sThread = new ServerThread(socket, this);
			Thread myThread = new Thread(sThread);
			myThread.start();
		}
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}
