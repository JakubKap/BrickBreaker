package brick_breaker;

/**
 *  Klasa Paddle reprezentuj¹ca czworok¹t 
 * (w kontekœcie gry, platformê za pomoc¹ której odbija siê pi³kê).
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */
public class Paddle {
	
	/**
	 * Prywatny atrybut x typu int (wspó³rzêdna x lewego górnego wierzcho³ka platformy).
	 */
	private int x;
	
	/**
	 * Prywatny atrybut y typu int (wspó³rzêdna y lewego górnego wierzcho³ka platformy).
	 */
	private int y;
	
	/**
	 * Prywatny atrybut width typu int (szerokoœæ platformy).
	 */
	private int width;
	
	/**
	 * Prywatny atrybut height typu int (wysokoœæ platformy).
	 */
	private int height;
	
	/**
	 * Konstruktor klasy Paddle.
	 */
	public Paddle() {
		this.x = 440;
		this.y = 660;
		this.width = 120;
		this.height = 40;
	}
	
	/**
	 * Publiczna metoda getX().
	 * @return wartoœæ prywatnego atrybutu x
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Publiczna metoda getY().
	 * @return wartoœæ prywatnego atrybutu y
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Publiczna metoda getWidth().
	 * @return wartoœæ prywatnego atrybutu width
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Publiczna metoda getHeight().
	 * @return wartoœæ prywatnego atrybutu height
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Publiczna metoda incX() dodaj¹ca do atrybutu x, parametr value.
	 * @param value wartoœæ dodana do atrybutu x
	 */
	public void incX(int value)
	{
		x+=value;
	}
	
	/**
	 * Publiczna metoda decX() odejmuj¹ca od atrybutu x, parametr value.
	 * @param value wartoœæ odjêta od atrybutu x
	 */
	public void decX(int value)
	{
		x-=value;
	}

}
