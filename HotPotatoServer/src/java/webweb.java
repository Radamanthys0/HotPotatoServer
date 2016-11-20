

import com.example.radamanthys.hotpoatosphero.Server.Host;
import com.example.radamanthys.hotpoatosphero.Server.Cliente;
import com.example.radamanthys.hotpoatosphero.Server.MessageTypes;
import java.io.IOException;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

/**
 * Classe webweb  lida com todas as peculiaridades do uso de websocket para fazer a comunicação
 * com os demais clientes
 * 
 * Cada ServerEndpoint é naturalmente executado em uma thread por conexão, então os
 * dados aqui, pertencem exclusivamente a um único cliente.
 * 
 *
 */

@ServerEndpoint("/server")

public class webweb
{
	private Session currentSession;
	private Cliente cli;
        private Cliente host;
        public int i =0;
        
        public Cliente [] clientes1;
        String []bla;
         ArrayList<Cliente> clientes = new ArrayList();
        
        
    @OnOpen
    public void onOpen(Session session) throws InterruptedException
    {
        this.currentSession = session;
    }
    
    @OnMessage
    public void onMessage(Session session, String message) throws IOException
    {
    	
        XStream xs = new XStream();
    	String oqEuSou;
    	System.out.println("Eu recebi:: " + message);
    	
    	cli = (Cliente)xs.fromXML(message);
        if (cli.getMessage_type() == MessageTypes.OPEN_CONNECTION){
            if (cli instanceof Host){
                	oqEuSou = "E um HOST";
                    host = cli;
                    //clientes [0] = cli;
                    clientes.add(host);
                }
    	
        	else if (cli instanceof Cliente){
                    oqEuSou = "E um CLIENT";
                    // clientes[i] = cli;
                    // i++;
                    clientes.add(cli);
            }
            else
    		oqEuSou = "Desconheco :/";
        
             System.out.println(oqEuSou);
             print();
            /* Envia uma msg para o cliente */
            session.getBasicRemote().sendText(oqEuSou);
        
        }
        else if (cli.getMessage_type() == MessageTypes.MOV_SPHERO){
            // enviar para o host este cli -> como fazer?
            session.getBasicRemote().sendText(message);
            //envia para o cliente onde cliente.getCor = cli.prox que a vez é dele -> como fazer?
            
        }
        
    }
    
    public void print(){
         int n = clientes.size();
        for (i=0; i<n; i++) {
            String bla1;
             Cliente bla = clientes.get(i);
             
            System.out.printf(bla.getNome());
        }
    }
    
    
    @OnClose
    public void onClose (Session session, CloseReason reason) throws IOException
    {
    	System.out.println ( cli.getNome() + ", saiu, motivo: " + reason.getReasonPhrase());

    	/* Broadcast. */
    	for (Session s : session.getOpenSessions() )
    		if (s.isOpen())
    			s.getBasicRemote().sendText( cli.getNome() + " / saiu");
    }
    
    @OnError
    public void onError (Session session, Throwable throwable)
    {
    	System.out.println("Algo de errado nao esta certo");
        throwable.printStackTrace();
    }

    public int searchColor(String name){
        // pesquisar no arrayList o nome e retornar a cor deste cliente
        int cor = 99;
        for (int i =0; i < clientes.size(); i++){
            if(clientes.get(i).getNome().equals(name)){
                cor = clientes.get(i).getCor();
                break;
            }
        }
        return cor;
    }
}
