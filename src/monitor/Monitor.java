package monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Monitor {
	
	private Hilo hilo;
	
	public Monitor() {
		this.hilo= new Hilo(this);
		this.hilo.start();
	}

	public void pingServidorOriginal() {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2010);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
	        out.println("ok");
	        String mensaje= in.readLine();
	        if(mensaje.equals("ok")) { //anda el servidor original
	        	System.out.println("Correcto funcionamiento del servidor original");
	        }
	        else { //informa error a los componentes
	        	informaAServidorRedudante("activar"); //aviso al servidor redudante que active
	        	informaATotem("cambio"); //aviso a Totem que pase las cosas al serviodr redudante
	        	informaATelevisor("cambio"); //aviso a Televisor que cambie el puerto para recibir llamados desde Redudante
	        	informaAEmpleado("cambio"); //aviso a Empleado que pase las cosas al servidor redudante
	        }
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			informaAServidorRedudante("activar");
        	informaATotem("cambio"); 
        	informaATelevisor("cambio"); 
        	informaAEmpleado("cambio"); 
        	
		}
	}
	
	public void pingServidorRedudante() {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2020);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
	        out.println("ok");
	        String mensaje= in.readLine();
	        if(mensaje.equals("ok")) { 
	        	System.out.println("Correcto funcionamiento del servidor redudante");
	        }
	        else { 
	        	informaAServidorOriginal("fallaServidorR"); 
	        }
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			informaAServidorOriginal("fallaServidorR");
		}
	}
	

	private void informaAServidorOriginal(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2040);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void informaAEmpleado(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2030);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void informaATelevisor(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2070);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void informaATotem(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2060);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void informaAServidorRedudante(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2050);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
