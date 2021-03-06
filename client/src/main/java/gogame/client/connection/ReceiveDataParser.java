package gogame.client.connection;

/**
 * Interface implementujące metody obslugujace
 * otrzymywanie oraz interpretowanie informacji
 * wysłanych z serwera
 * @author wojciech
 *
 */
public interface ReceiveDataParser {
	public void receiveYouMoved(String s);
	public void receiveOponentMoved(String s);
	public void receiveGameStarted(String s);
	public void receiveYourTurn();
	public void receiveNotYourTurn();
	public void receiveDelete(String s);
	public void receiveOtherPlayerLeft();
	public void receiveVictory(String s);
	public void receivePrisoners(String s);
	public void receiveDefeat(String s);
	public void receiveTie(String s);
	public void receiveConnected();

}
