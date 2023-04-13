package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
	
	Server server;
	Socket socket;
	
	public ServerThread(Socket socket,Server server) {
		this.server = server;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String recenica;
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out.println(server.getCount());
			int count = server.getCount();
			int kljuc,brojIndeksa,k;
			out.println("Kljuc:");
			k=Integer.parseInt(in.readLine());
			server.setCount(server.getCount()+1);
			while(true)
			{
				
				out.println("korisnik unosi:");
				recenica = in.readLine();
				
				int y;
				System.out.print("Korisnik br. " + count+": ");
				if(!recenica.equals("STOP")) {
					brojIndeksa = Integer.parseInt(in.readLine());
					kljuc = k-brojIndeksa;
					for(int i = 0;i<recenica.length();i++)
					{
						if(recenica.charAt(i) >= 'a' && recenica.charAt(i) <= 'z' || recenica.charAt(i) >= 'A' && recenica.charAt(i) <= 'Z')
						{
							System.out.print((char)(recenica.charAt(i)+kljuc));
						}
						else
							System.out.print((char)(recenica.charAt(i)));
					}
						System.out.println(","+brojIndeksa+","+k);
						out.println(recenica);
						System.out.println("Korisnik br. " + count+": "+recenica);
				}
				else
					System.out.println(recenica);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
