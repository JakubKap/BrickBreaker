package brick_breaker;

/**
 *  Klasa Paddle reprezentuj�ca czworok�t 
 * (w kontek�cie gry, platform� za pomoc� kt�rej odbija si� pi�k�).
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */
public class Paddle {
	
	/**
	 * Prywatny atrybut x typu int (wsp�rz�dna x lewego g�rnego wierzcho�ka platformy).
	 */
	private int x;
	
	/**
	 * Prywatny atrybut y typu int (wsp�rz�dna y lewego g�rnego wierzcho�ka platformy).
	 */
	private int y;
	
	/**
	 * Prywatny atrybut width typu int (szeroko�� platformy).
	 */
	private int width;
	
	/**
	 * Prywatny atrybut height typu int (wysoko�� platformy).
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
	 * @return warto�� prywatnego atrybutu x
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Publiczna metoda getY().
	 * @return warto�� prywatnego atrybutu y
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Publiczna metoda getWidth().
	 * @return warto�� prywatnego atrybutu width
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Publiczna metoda getHeight().
	 * @return warto�� prywatnego atrybutu height
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Publiczna metoda incX() dodaj�ca do atrybutu x, parametr value.
	 * @param value warto�� dodana do atrybutu x
	 */
	public void incX(int value)
	{
		x+=value;
	}
	
	/**
	 * Publiczna metoda decX() odejmuj�ca od atrybutu x, parametr value.
	 * @param value warto�� odj�ta od atrybutu x
	 */
	public void decX(int value)
	{
		x-=value;
	}

}
