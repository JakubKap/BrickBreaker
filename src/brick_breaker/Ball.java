package brick_breaker;

	/**
	 * Klasa Ball reprezentuj¹ca okr¹g 
	 * (w kontekœcie gry czerwon¹ pi³kê za pomoc¹ której zbija siê bloczki). 
	 * Ze wzglêdu na to, ¿e obiekt ten jest rysowany za pomoc¹ funkcji 
	 * fillOval(x,y,width, height),
	 * okr¹g jest okreœlony za pomoc¹ czworok¹ta, w który mo¿na go wpisaæ.
	 * 
	 * @author Jakub Kapusta I6X4S1
	 * @version 1.0
	 * */
public class Ball {
	/**
	* Prywatny atrybut x typu int (wspó³rzêdna x lewego górnego wierzcho³ka czworok¹ta,
	* w który zostanie wpisany okr¹g reprezentuj¹cy pi³kê).
	*/
	private int x;
	
	/**
	 * Prywatny atrybut y typu int (wspó³rzêdna y lewego górnego wierzcho³ka czworok¹ta, 
	 * w który zostanie wpisany okr¹g reprezentuj¹cy pi³kê).
	 */
	private int y;
	
	/**
	 * Prywatny atrybut r typu int (promieñ okrêgu).
	 */
	private int r;
	
	/**
	 * Prywatny atrybut height typu int (wysokoœæ oraz szerokoœæ czworok¹ta).
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
	 * Publiczna metoda incX() dodaj¹ca do atrybutu x, parametr value.
	 * @param value wartoœæ dodana do atrybutu x
	 */
	public void incX(int value)	
	{
		x += value;
	}
	
	/**
	 * Publiczna metoda incY() dodaj¹ca do atrybutu y, parametr value.
	 * @param value wartoœæ dodana do atrybutu y
	 */
	public void incY(int value)	
	{
		y += value;
	}
	
	/**
	 * Publiczna metoda decX() odejmuj¹ca od atrybutu x, parametr value.
	 * @param value wartoœæ odjêta od atrybutu x
	 */
	public void decX(int value)	
	{
		x -= value;
	}
	
	/**
	 * Publiczna metoda decY() odejmuj¹ca od atrybutu y, parametr value.
	 * @param value wartoœæ odjêta od atrybutu y
	 */
	public void decY(int value)	
	{
		y -= value;
	}
	
	/**
	 * Publiczna metoda getR().
	 * @return wartoœæ prywatnego atrybutu r
	 */
	public int getR()
	{
		return r;
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
	 * Publiczna metoda getX_r().
	 * @return obliczona wartoœæ wspó³rzêdnej x œrodka okrêgu
	 */
	public int getX_r()
	{
		return  x + 10;
	}
	
	/**
	 * Publiczna metoda getY_r().
	 * @return obliczona wartoœæ wspó³rzêdnej y œrodka okrêgu
	 */
	public int getY_r()
	{
		return  y + 10;
	}

}
