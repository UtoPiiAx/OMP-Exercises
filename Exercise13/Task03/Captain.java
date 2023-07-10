public abstract class Captain {
	
	protected Ship ship;
	
	public Captain(Ship ship) {
		super();
		this.ship = ship;
	}

	/**
	 * Gibt ein Kommando an das Schiff.
	 * Dieses Kommando wird erst auf der Konsole ausgegeben
	 * und anschliessend wird die entsprechende Methode des
	 * Schiffs aufgerufen.
	 */
	public abstract void commandShip();

}
