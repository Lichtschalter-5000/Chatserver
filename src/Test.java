import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import ea.*;

public class Test extends Game {

    public static final int FENSTERHOEHE = 7*MeinClient.ZEILENHOEHE;
    Broadcast server;
    MeinClient c1;
    MeinClient c2;

    public Test() {
        super(800, Test.FENSTERHOEHE, "Client-Server-Test", false, false);

        server = new Broadcast(9876);
        c1 = new MeinClient("127.0.0.1",9876, super.eingabeFordern("Name eingeben:"), this);
        c2 = new MeinClient("localhost", 9876);
    }

    @Override
    public void tasteReagieren(int i) {
        if (i == 32) { //ESC
            c1.beendeVerbindung();
            c2.beendeVerbindung();
            server.beendeVerbindung();
            super.beenden();
        } else {
            c1.sendeNachrichtAnServer(super.eingabeFordern("Gib eine Nachricht ein: "));
        }
    }


    public static void main(String[] args) {
        new Test();
    }
}
