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
	        		//informaAServidorRedudante("activar"); //aviso al servidor redudante que active
	        		System.out.println("Avisando a los componentes para que cambien del puerto");
		        	informaATotem0("cambio"); //aviso a Totem que pase las cosas al serviodr redudante
		        	informaATotem1("cambio");
		        	informaATotem2("cambio");
		        	informaATelevisor("cambio"); //aviso a Televisor que cambie el puerto para recibir llamados desde Redudante
		        	informaAEmpleado0("cambio"); //aviso a Empleado que pase las cosas al servidor redudante
		        	informaAEmpleado1("cambio");
		        	informaAEmpleado2("cambio");
		        	informaAEmpleado3("cambio");
		        	informaAEmpleado4("cambio");
	     
	        	
	        }
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			//informaAServidorRedudante("activar"); //aviso al servidor redudante que active
    		System.out.println("Avisando a los componentes para que cambien del puerto");
        	informaATotem0("cambio"); //aviso a Totem que pase las cosas al serviodr redudante
        	informaATotem1("cambio");
        	informaATotem2("cambio");
        	informaATelevisor("cambio"); //aviso a Televisor que cambie el puerto para recibir llamados desde Redudante
        	informaAEmpleado0("cambio"); //aviso a Empleado que pase las cosas al servidor redudante
        	informaAEmpleado1("cambio");
        	informaAEmpleado2("cambio");
        	informaAEmpleado3("cambio");
        	informaAEmpleado4("cambio");
        	
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

	private void informaAEmpleado0(String aviso) {
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
	
	private void informaAEmpleado1(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2031);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void informaAEmpleado2(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2032);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void informaAEmpleado3(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2033);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void informaAEmpleado4(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2034);
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

	private void informaATotem0(String aviso) {
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
	
	private void informaATotem1(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2061);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
	        out.println(aviso);
	        out.close();
	        socket.close();
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void informaATotem2(String aviso) {
		try {
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),2062);
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
			Socket socket=new Socket (InetAddress.getLocalHost().getHostAddress(),5000);
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
