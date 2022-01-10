package models;

import java.util.ArrayList;
import java.util.List;


import play.libs.Akka;
import play.mvc.WebSocket;
import play.mvc.WebSocket.Out;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Represent a tv with viewers.
 * @author tse
 *
 */
public class TvActor extends UntypedActor {
	    
	// Websocket for the broadcaster
    public WebSocket.In<String> broadcast;

    // Websockets of the viewers
    public List<WebSocket.Out<String>> viewers;
	
    /**
     * Constructor
     * @param in the websocket for the broadcaster
     */
    public TvActor(WebSocket.In<String> in) {
        this.broadcast = in;
        this.viewers = new ArrayList<WebSocket.Out<String>>();
    }
    
    @Override
    public void onReceive(Object message) {
    	if(message.getClass().equals(ConnectViewer.class)) {
    		viewers.add(((ConnectViewer)message).viewer);
    	} else {
            for(Out<String> viewer: viewers) {
                viewer.write((String)message);
            }
    	}
    }
    
    /**
     * Create an actor for a tv
     * @param in websocket of the broadcaster
     * @param name the tv name
     * @return the ActorRef
     */
    public static ActorRef createTv(WebSocket.In<String> in, String name) {
    	return Akka.system().actorOf(Props.create(TvActor.class, in), name);
    }
    
    /**
     * Connect a viewer to a tv
     * @param viewer the websocket of the viewer
     * @param name the tv name
     */
    // TODO : use actor selection instead
    public static void connect(WebSocket.Out<String> viewer, String name) {
    	ActorRef tv = Akka.system().actorFor("/user/"+name);
    	tv.tell(new ConnectViewer(viewer), tv);
    }
    
    /**
     * Message represent a viewer connection
     * @author tsensebe
     *
     */
    public static class ConnectViewer {
        final public WebSocket.Out<String> viewer;
        
        public ConnectViewer(WebSocket.Out<String> viewer) {
            this.viewer = viewer;
        }
    }
    
}
