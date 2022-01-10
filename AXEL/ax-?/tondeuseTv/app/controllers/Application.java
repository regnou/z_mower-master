package controllers;

import models.TvActor;
import play.libs.F.Callback;
import play.mvc.Controller;
import play.mvc.WebSocket;
import akka.actor.ActorRef;

/**
 * Application controller
 * @author tsensebe
 *
 */
public class Application extends Controller {
	
	/**
	 * Create a tv.
	 * @param name the tv name
	 * @return the websocket for the broadcast
	 */
	public static WebSocket<String> create(final String name) {
	    return new WebSocket<String>() {
	        public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
	        	try {
					final ActorRef actorRef = TvActor.createTv(in,name);
					in.onMessage(new Callback<String>() {
					   public void invoke(String msg) {
						   actorRef.tell(msg,actorRef);   
					   }
					});
				// Error or actor name not unique
				} catch (Exception e) {
					e.printStackTrace();
					out.close();
				}

	        }
	    };
	}
	
	/**
	 * Connect to a tv.
	 * @param tvName the tv name
	 * @return the websocket for the viewer
	 */
	public static WebSocket<String> connect(final String tvName) {
		return new WebSocket<String>() {
	        public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
	        	TvActor.connect(out, tvName);
	        };
	    };
	}
}
