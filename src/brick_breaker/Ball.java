package brick_breaker;

	/**
	 * Klasa Ball reprezentuj�ca okr�g 
	 * (w kontek�cie gry czerwon� pi�k� za pomoc� kt�rej zbija si� bloczki). 
	 * Ze wzgl�du na to, �e obiekt ten jest rysowany za pomoc� funkcji 
	 * fillOval(x,y,width, height),
	 * okr�g jest okre�lony za pomoc� czworok�ta, w kt�ry mo�na go wpisa�.
	 * 
	 * @author Jakub Kapusta I6X4S1
	 * @version 1.0
	 * */
public class Ball {
	/**
	* Prywatny atrybut x typu int (wsp�rz�dna x lewego g�rnego wierzcho�ka czworok�ta,
	* w kt�ry zostanie wpisany okr�g reprezentuj�cy pi�k�).
	*/
	private int x;
	
	/**
	 * Prywatny atrybut y typu int (wsp�rz�dna y lewego g�rnego wierzcho�ka czworok�ta, 
	 * w kt�ry zostanie wpisany okr�g reprezentuj�cy pi�k�).
	 */
	private int y;
	
	/**
	 * Prywatny atrybut r typu int (promie� okr�gu).
	 */
	private int r;
	
	/**
	 * Prywatny atrybut height typu int (wysoko�� oraz szeroko�� czworok�ta).
	 */
	private int height;
	
	/**
	 * Konstruktor klasy Ball.
	 */
	public Ball() {
		this.x = 490;
		this.y = 640;
		this.r=10;
		this.height = 20;
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
	 * Publiczna metoda incX() dodaj�ca do atrybutu x, parametr value.
	 * @param value warto�� dodana do atrybutu x
	 */
	public void incX(int value)	
	{
		x += value;
	}
	
	/**
	 * Publiczna metoda incY() dodaj�ca do atrybutu y, parametr value.
	 * @param value warto�� dodana do atrybutu y
	 */
	public void incY(int value)	
	{
		y += value;
	}
	
	/**
	 * Publiczna metoda decX() odejmuj�ca od atrybutu x, parametr value.
	 * @param value warto�� odj�ta od atrybutu x
	 */
	public void decX(int value)	
	{
		x -= value;
	}
	
	/**
	 * Publiczna metoda decY() odejmuj�ca od atrybutu y, parametr value.
	 * @param value warto�� odj�ta od atrybutu y
	 */
	public void decY(int value)	
	{
		y -= value;
	}
	
	/**
	 * Publiczna metoda getR().
	 * @return warto�� prywatnego atrybutu r
	 */
	public int getR()
	{
		return r;
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
	 * Publiczna metoda getX_r().
	 * @return obliczona warto�� wsp�rz�dnej x �rodka okr�gu
	 */
	public int getX_r()
	{
		return  x + 10;
	}
	
	/**
	 * Publiczna metoda getY_r().
	 * @return obliczona warto�� wsp�rz�dnej y �rodka okr�gu
	 */
	public int getY_r()
	{
		return  y + 10;
	}

}
