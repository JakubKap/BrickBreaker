package brick_breaker;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Block reprezentuj¹ca czworok¹t (w kontekœcie gry bloczki, 
 * które s¹ zbijane przez czerwon¹ pi³kê).
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */
public class Block {

	/**
	 * Prywatny atrybut x typu int (wspó³rzêdna x lewego górnego wierzcho³ka czworok¹ta).
	 */
	private int x;
	
	/**
	 * Prywatny atrybut y typu int (wspó³rzêdna y lewego górnego wierzcho³ka czworok¹ta).
	 */
	private int y; 
	
	/**
	 * Prywatny atrybut width typu int (szerokoœæ czworok¹ta).
	 */
	private int width;
	
	/**
	 * Prywatny atrybut height typu int (wysokoœæ czworok¹ta).
	 */
	private int height;
	
	/**
	 * Prywatny atrybut visible typu boolean (zmienna boolowska, która gdy posiada wartoœæ 
	 * false, mówi o tym, ¿e bloczek zosta³ zbity i nie powinien byæ widoczny).
	 */
	private boolean visible;
	
	/**
	 * Publiczna, statyczna lista blocks, która przechowuje obiekty klasy Block.
	 * Lista jest publiczna, poniewa¿ korzystaj¹ z niej inne klasy.
	 */
	public static List <Block> blocks = new ArrayList<Block>(); 
	
	/**
	 * Konstruktor klasy Block.
	 */
	public Block()
	{
		x=0;
		y=0;
		width = 140;
		height = 75;
		visible=true;
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
	 * Publiczna metoda setX(int value), przypisuj¹ca atrybutowi x, wartoœæ parametru metody.
	 * @param value wartoœæ, która zostanie przypisana do atrybutu x
	 */
	public void setX(int value)
	{
		x = value;
	}
	
	/**
	 * Publiczna metoda setY(int value), przypisuj¹ca atrybutowi y, wartoœæ parametru metody.
	 * @param value wartoœæ, która zostanie przypisana do atrybutu y
	 */
	public void setY(int value)
	{
		y = value;
	}
	
	/**
	 * Publiczna metoda getVisible().
	 * @return wartoœæ atrybutu visible
	 */
	public boolean getVisible()
	{
		return visible;
	}
	
	/**
	 * Publiczna metoda setVisible(boolean value), przypisuj¹ca atrybutowi visible,
	 * wartoœæ parametru metody.
	 * @param value wartoœæ, która ma zostaæ przypisana do atrybutu visible
	 */
	public void setVisible(boolean value)
	{
		visible = value;
	}
	
}
