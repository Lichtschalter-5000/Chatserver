public class Test {

    public Test() {
        Broadcast server = new Broadcast(9876);
        MeinClient c1 = new MeinClient("localhost",9876);
        MeinClient c2 = new MeinClient("localhost", 9876);

        c1.sendeNachrichtAnServer("Hallo sagt c1.");
        c2.sendeNachrichtAnServer("Hallo sagt auch c2.");

        c1.beendeVerbindung();
        c2.beendeVerbindung();
        //server.beendeVerbindung();
    }


    public static void main(String[] args) {
        new Test();
    }
}
