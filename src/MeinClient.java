import ea.*;


public class MeinClient
extends Client 
{

    public static final int ZEILENHOEHE = 30;
    private String name;
    private int anzahlNachrichten;
    private boolean anzeige;
    private Game game;

    public MeinClient(String ipAdresse, int port, String name, Game game)
    {
        super(ipAdresse, port);
        this.name = name;
        this.anzeige = game!=null;
        if(anzeige) {
            this.game = game;
        }
    }

    public MeinClient(String ipAdresse, int port, String name) {
        this(ipAdresse, port, name, null);
    }

    public MeinClient(String ipAdresse, int port) {
        this(ipAdresse, port, "Ein Client");
    }
    
    public void sendeNachrichtAnServer(String nachricht) 
    {
        super.sendeString("["+this.name+"]: "+nachricht);
    }

    
    @Override
    public void empfangeString(String string) 
    {
        if(this.anzeige) {
            Text text = new ea.Text(string, 10, anzahlNachrichten * MeinClient.ZEILENHOEHE + 10, MeinClient.ZEILENHOEHE*2/3);
            text.farbeSetzen(new Farbe(255, 255, 255));
            this.game.wurzel.add(text);
            if (Test.FENSTERHOEHE < anzahlNachrichten * MeinClient.ZEILENHOEHE + 50) {
                this.game.cam.verschieben(0, MeinClient.ZEILENHOEHE);
            }
        }
        System.out.println(this.name + " empfängt: " + string);
        this.anzahlNachrichten++;
    }
}



