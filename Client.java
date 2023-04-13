package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public Client() throws Exception {
		int brojIndeksa=42;
		int x = brojIndeksa+2019;
		Socket socket = new Socket("192.168.17.40", x);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader tast = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(in.readLine());
		int k;
		String message;
		message = in.readLine();
		System.out.println(message);
		message = tast.readLine();
		message = Integer.parseInt(message)+brojIndeksa+"";
		out.println(message);
		while(true)
		{
			message = in.readLine();
			System.out.println(message);
			message = tast.readLine();
			out.println(message);
			if(message.equals("STOP"))
				break;
			out.println(brojIndeksa);
			message = in.readLine();
			System.out.println("S:"+message);
			System.out.println("Poruka je ispravno desifrovana");
		}
		socket.close();
		
	}
	
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
