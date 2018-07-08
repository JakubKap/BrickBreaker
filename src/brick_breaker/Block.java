package brick_breaker;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Block reprezentuj�ca czworok�t (w kontek�cie gry bloczki, 
 * kt�re s� zbijane przez czerwon� pi�k�).
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */
public class Block {

	/**
	 * Prywatny atrybut x typu int (wsp�rz�dna x lewego g�rnego wierzcho�ka czworok�ta).
	 */
	private int x;
	
	/**
	 * Prywatny atrybut y typu int (wsp�rz�dna y lewego g�rnego wierzcho�ka czworok�ta).
	 */
	private int y; 
	
	/**
	 * Prywatny atrybut width typu int (szeroko�� czworok�ta).
	 */
	private int width;
	
	/**
	 * Prywatny atrybut height typu int (wysoko�� czworok�ta).
	 */
	private int height;
	
	/**
	 * Prywatny atrybut visible typu boolean (zmienna boolowska, kt�ra gdy posiada warto�� 
	 * false, m�wi o tym, �e bloczek zosta� zbity i nie powinien by� widoczny).
	 */
	private boolean visible;
	
	/**
	 * Publiczna, statyczna lista blocks, kt�ra przechowuje obiekty klasy Block.
	 * Lista jest publiczna, poniewa� korzystaj� z niej inne klasy.
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
	 * Publiczna metoda setX(int value), przypisuj�ca atrybutowi x, warto�� parametru metody.
	 * @param value warto��, kt�ra zostanie przypisana do atrybutu x
	 */
	public void setX(int value)
	{
		x = value;
	}
	
	/**
	 * Publiczna metoda setY(int value), przypisuj�ca atrybutowi y, warto�� parametru metody.
	 * @param value warto��, kt�ra zostanie przypisana do atrybutu y
	 */
	public void setY(int value)
	{
		y = value;
	}
	
	/**
	 * Publiczna metoda getVisible().
	 * @return warto�� atrybutu visible
	 */
	public boolean getVisible()
	{
		return visible;
	}
	
	/**
	 * Publiczna metoda setVisible(boolean value), przypisuj�ca atrybutowi visible,
	 * warto�� parametru metody.
	 * @param value warto��, kt�ra ma zosta� przypisana do atrybutu visible
	 */
	public void setVisible(boolean value)
	{
		visible = value;
	}
	
}
