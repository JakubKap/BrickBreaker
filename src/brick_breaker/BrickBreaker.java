package brick_breaker;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;
/**
 * Klasa BrickBreaker reprezentuj�ca logik� gry oraz obs�ug� zdarze�
 * (implementuje interfejsy KeyListener oraz Action Listener).
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */

public class BrickBreaker implements KeyListener, ActionListener{

	
	/**
	 * Prywatny atrybut jframe, b�d�cy obiektem klasy JFrame (ramka).
	 */
	private JFrame jframe;
	
	/**
	 * Prywatny atrybut panel, b�d�cy obiektem klasy Panel, kt�ry zostanie dodany do ramki.
	 */
	private Panel panel;
	
	/**
	 * Prywatny atrybut toolkit, b�d�cy obiektem klasy Toolkit, 
	 * kt�ry zostanie wykorzystany do ustawienia w�a�ciwo�ci ramki.
	 */
	private Toolkit toolkit;
	
	/**
	 * Prywatny atrybut img, b�d�cy obiektem klasy Image, 
	 * w kt�rym zostanie przechowana ikona aplikacji.
	 */
	private Image img;
	
	/**
	 * Publiczny statyczny atrybut brickreaker typu BrickBreaker, 
	 * kt�ry b�dzie si� odwo�ywa� do nowoutworzonego obiektu typu Brickbreaker
	 * w funkcji main(). Atrybut ten jest publiczny i prywatny, po to aby
	 *  klasa Panel mia�a dost�p do atrybut�w i metod klasy BrickBreaker (b�dzie mog�a si� 
	 *  odwo�ywa� do tego atrybutu). 
	 */
	public static BrickBreaker brickbreaker;
	
	/**
	 * Prywatny atrybut dim typu Dimension przechowuj�cy rozdzielczo�� obrazu.
	 */
	private Dimension dim;
	
	/**
	 * Prywatny atrybut b�d�cy timerem.
	 */
	private Timer timer = new Timer(10, this);
	
	/**
	 * Publiczny atrybut reprezentuj�cy obiekt klasy Ball.
	 */
	public Ball ball;
	
	/**
	 * Publiczny atrybut reprezentuj�cy obiekt klasy Paddle.
	 */
	public Paddle paddle;
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut LEFT_UP reprezentuj�cy kierunek, 
	 * w kt�rym pod��a pi�ka - p�nocny - zach�d.
	 */
	private static final int LEFT_UP = 0;
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut RIGHT_UP reprezentuj�cy kierunek, 
	 * w kt�rym pod��a pi�ka - p�nocny - wsch�d.
	 */
	private static final int RIGHT_UP = 1;
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut LEFT_DOWN reprezentuj�cy kierunek, 
	 * w kt�rym pod��a pi�ka - po�udniowy - zach�d.
	 */
	private static final int LEFT_DOWN = 2; 
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut RIGHT_DOWN reprezentuj�cy kierunek, 
	 * w kt�rym pod��a pi�ka - po�udniowy - wsch�d.
	 */
	private static final int RIGHT_DOWN = 3;
	
	/**
	 * Prywatny atrybut ticks typu int (reprezentuje liczb� inkrementacji warto�ci timera).
	 */
	private int ticks;
	
	/**
	 * Prywatny atrybut direction typu int (kierunek lotu pi�ki).
	 */
	private int direction;
	
	/**
	 * Prywatny atrybut score typu int (wynik gry).
	 */
	private int score;
	
	/**
	 * Prywatny atrybut paused typu boolean (informacja o tym, czy gra zosta�a zatrzymana - 
	 * wtedy atrybut przyjmuje warto�� true).
	 */
	private boolean paused; 
	
	/**
	 * Prywatny atrybut gameover typu boolean (informacja o tym, czy gracz przegra� rozgrywk� -
	 * wtedy atrybut przyjmuje warto�� true).
	 */
	private boolean gameover;
	
	/**
	 * Prywatny atrybut winner typu boolean (informacja o tym, czy gracz wygra� rozgrywk� - 
	 * wtedy atrybut przyjmuje warto�� true).
	 */
	private boolean winner;
	
	/**
	 * Prywatny atrybut start typu boolean (informacja o tym, czy gracz rozpocz�� rozgrywk� 
	 * (wprawi� w ruch pi�k� za pomoc� klawisza strza�ki w g�r�) - 
	 * wtedy atrybut przyjmuje warto�� true).
	 */
	private boolean start;
	
	/**
	 * Prywatny atrybut begin typu boolean (informacja o tym, czy gracz po ujrzeniu ekranu 
	 * powitalnego, wcisn�� Enter - wtedy atrybut przyjmuje warto�� false).
	 */
	private boolean begin;
	
	/**
	 * Prywatny atrybut border typu boolean (informacja o tym, czy pi�ka odbi�a si� od 
	 * pionowej �ciany platformy (paddle) - wtedy border przyjmuje warto�� true 
	 * oraz pi�ka nie odbija si� od platformy, co skutkuje przegraniem rozgrywki).
	 */
	private boolean border;
	
	/**
	 * Prywatny atrybut tablicowy, przechowuj�cy 15 obiekt�w typu Block.
	 */
	private Block tab[] = new Block [15];
	  
	/**
	 * Publiczna metoda inicjuj�ca gr� w przypadku pora�ki lub sukcesu. 
	 * Jest r�wnie� wywo�ywana w konstruktorze.
	 */
	public void startGame()
	{
		Block.blocks.clear();
		int row = 50, collumn = 50;
		
		for(int i=0; i<tab.length; i++)
		{
			if ((i % 5 == 0) && (i>0)) row+=95;
			if ((i % 5 == 0) && (i>0)) collumn=50;
			tab[i] = new Block();
			tab[i].setX(collumn);
			tab[i].setY(row);
			collumn+=190;
			Block.blocks.add(tab[i]);
		}
		
		direction = LEFT_UP;
		ticks = 0;
		score=0;
		ball = new Ball();
		begin = false;
		paddle = new Paddle();
		paused=false;
		gameover = false;
		winner=false;
		start=false;
		border = false;
		timer.start(); 
		panel.repaint();
		
	}
	
	/**
	 * Publiczna metoda getTicks().
	 * @return warto�� prywatnego atrybutu ticks
	 */
	public int getTicks()
	{
		return ticks;
	}
	
	/**
	 * Publiczna metoda getScore().
	 * @return warto�� prywatnego atrybutu score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Publiczna metoda getBegin().
	 * @return warto�� prywatnego atrybutu begin
	 */
	public boolean getBegin()
	{
		return begin;
	}
	
	/**
	 * Publiczna metoda getGameover().
	 * @return warto�� prywatnego atrybutu gameover
	 */
	public boolean getGameover()
	{
		return gameover;
	}
	
	/**
	 * Publiczna metoda getWinner().
	 * @return warto�� prywatnego atrybutu winner
	 */
	public boolean getWinner()
	{
		return winner;
	}
	
	/**
	 * Konstruktor klasy BrickBreaker.
	 */
	public BrickBreaker() {
		
		dim = Toolkit.getDefaultToolkit().getScreenSize(); //dopasowanie do rozdzielczo�ci
		toolkit = Toolkit.getDefaultToolkit();
		jframe = new JFrame("Brick Breaker");
		img = toolkit.getImage("icon.png");
		jframe.setIconImage(img);
		jframe.setVisible(true);
		jframe.setSize(1000,700);
		jframe.setLocation(dim.width/2 - jframe.getWidth() / 2, dim.height/2 - jframe.getHeight() / 2);
		jframe.add(panel = new Panel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.addKeyListener(this);
		startGame();
		begin = true;
	}
	
	/**
	 * Publiczna metoda clamp().
	 * @param x badana wsp�rz�dna
	 * @param min ograniczenie dolne przedia�u (min, max)
	 * @param max ograniczenie g�rne przedia�u (min, max)
	 * @return je�li x jest mniejsze od min, to zwracan� warto�ci� jest min;
	 * je�li x jest wi�ksze od max, zwracan� warto�ci� jest max;
	 * w przeciwnym wypadku, zwracany jest parametr metody x
	 */
	public int clamp(int x, int min, int max)
	{
		 if (x < min) x = min;
		 
	    else if (x > max) 
	        x = max;
	    
	    return x;
	}
	
	/**
	 * Publiczna metoda intersects_blocks() sprawdzaj�ca, 
	 * czy czerwona pi�ka trafi�a w bloczek oraz w razie potrzeby, 
	 * zmieniaj�ca kierunek jej lotu.
	 */
	public void intersects_blocks()
	{
		float closestX=0;
		float closestY=0;
		float distanceX=0;
		float distanceY=0;
		float distanceSquared=0;
		
		
		for (Block b : Block.blocks)
		{
			closestX = clamp(ball.getX_r(), b.getX(), b.getX() + b.getWidth());
			closestY = clamp(ball.getY_r(), b.getY(), b.getY() + b.getHeight());
		
			distanceX = ball.getX_r() - closestX;
			distanceY = ball.getY_r() - closestY;
			
			
			distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
			if (distanceSquared < (ball.getR() * ball.getR()) && (b.getVisible() == true))
			{
				b.setVisible(false);
				score++;
				switch(direction)
				{
					case LEFT_UP:
						if ((closestX == b.getX() + b.getWidth()) && (closestY == ball.getY_r()))
						direction = RIGHT_UP;
							else direction = LEFT_DOWN;
						break;
						
					case RIGHT_UP:
						if((closestX == b.getX()) && (closestY == ball.getY_r()))
						direction = LEFT_UP;
							else direction = RIGHT_DOWN;
						break;
						
					case LEFT_DOWN:
						if((closestX == b.getX() + b.getWidth()) && (closestY == ball.getY_r()))
						direction = RIGHT_DOWN;
							else direction = LEFT_UP; 
						break;
						
					case RIGHT_DOWN:
						if((closestX == b.getX()) && (closestY == ball.getY_r()))
						direction = LEFT_DOWN;
							else direction = RIGHT_UP; 
						break;
				}
			}
			
		
	}
		
}

	/**
	 * Publiczna metoda intersects_paddle() sprawdzaj�ca, czy czerwona pi�ka uderzy�a 
	 * w platform�.
	 * @return zmienna boolowska, kt�ra je�li przyjmuje warto�c true, 
	 * to oznacza, �e pi�ka uderzy�a w platform� lub false w przeciwnym wypadku
	 */
	public boolean intersects_paddle()
	{
		float closestX=0;
		float closestY=0;
		float distanceX=0;
		float distanceY=0;
		float distanceSquared=0;
		
			closestX = clamp(ball.getX_r(), paddle.getX(), paddle.getX() + paddle.getWidth());
			closestY = clamp(ball.getY_r(), paddle.getY(), paddle.getY() + paddle.getHeight());
		
			distanceX = ball.getX_r() - closestX;
			distanceY = ball.getY_r() - closestY;
		
			distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
			
			if ((closestX == paddle.getX() + paddle.getWidth() && closestY == ball.getY_r()) || (closestX == paddle.getX() && closestY == ball.getY_r()))
			border=true;
				return (distanceSquared < (ball.getR() * ball.getR()));
	
	}
	/**
	 * Publiczna metoda actionPerformed(ActionEvent arg0) (zaimplementowana metoda 
	 * interfejsu ActionListner) odpowiedzialna za logik� gry - wykrywanie zderzenia 
	 * ze �cianami, platform� oraz zmian� kierunku lotu pi�ki.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (!paused && !gameover && !winner && start && !begin)
		{
			ticks++;
			panel.repaint();
			intersects_blocks();
			
			/**
			 * spotkanie z paddle  praw� �cian�
			 */
			if(direction == RIGHT_DOWN)
			{
				ball.incX(2);
				ball.incY(2);
				
				if(intersects_paddle() && !border) //spotkanie z paddle
				{
					if(ball.getX() < paddle.getX() + (paddle.getWidth()/2))
					direction=LEFT_UP;
					
					else direction = RIGHT_UP;
				}
				
				if(ball.getX() + ball.getHeight() == jframe.getWidth())
					direction = LEFT_DOWN;
				
				
				if(ball.getY() + ball.getHeight() > jframe.getHeight()) 
					gameover=true;
				
			}
			
			/**
			 * spotkanie z paddle i lew� �cian�
			 */
			if(direction == LEFT_DOWN)
			{
				ball.decX(2);
				ball.incY(2);
				
				if(intersects_paddle() && !border) //spotkanie z paddle
				{	
					if(ball.getX() < paddle.getX() + (paddle.getWidth()/2))
						direction=LEFT_UP;
					
					else direction = RIGHT_UP;
					
				}
				
				if(ball.getX() == 0) direction=RIGHT_DOWN;
				
				if(ball.getY() + ball.getHeight() > jframe.getHeight()) 
					gameover=true;
			}
			
			if(direction == LEFT_UP)
			{
				ball.decX(2);
				ball.decY(2);
				
				if(ball.getX() == 0) 
					direction = RIGHT_UP;
				if(ball.getY() == 0) 
					direction = LEFT_DOWN;
				
			}
			
			if(direction == RIGHT_UP)
			{
				ball.incX(2);
				ball.decY(2);
				
				if(ball.getX() + ball.getHeight() == jframe.getWidth())
					direction = LEFT_UP;
				if(ball.getY() == 0) 
					direction = RIGHT_DOWN;
			}
			
			if (score == 15)
				winner=true;

		}
	}
	/**
	 *Publiczna metoda keyPressed(KeyEvent e) (zaimplementowana metoda interfejsu KeyListener) 
	 *odpowiedzialna za obs�ug� wci�ni�tych klawiszy potrzebnych do rozgrywki.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int i = e.getKeyCode();
		if (i == KeyEvent.VK_LEFT && paddle.getX() > 0 && !paused)
		{
			paddle.decX(8);
			if(!start) 
			{
				ball.decX(8);
				panel.repaint();
			}
		}
		
		if (i == KeyEvent.VK_RIGHT && paddle.getX() + paddle.getWidth() < jframe.getWidth() - 4 && !paused)
		{
			paddle.incX(8);
			if(!start) 
			{
				ball.incX(8);
				panel.repaint();
			}
		}
		
		if(i == KeyEvent.VK_UP && start == false)
			start = true;
		
		if (i == KeyEvent.VK_SPACE)
		{
			paused = !paused;
		}
		
		if (i == KeyEvent.VK_ENTER)
		{
			if(gameover || winner)
				startGame();
			else if (begin)
			{
				begin=false;
				panel.repaint();
			}
				
		}
		
		if (i == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}	
		
	}

	/**
	 * Publiczna niezaimplementowana metoda keyReleased(KeyEvent e) 
	 * (jej nag��wek jest niezb�dny, poniewa� klasa BrickBreaker implementuje 
	 * interfejs KeyListener).
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Publiczna niezaimplementowana metoda keyTyped(KeyEvent e)
	 * (jej nag��wek jest niezb�dny, poniewa� klasa BrickBreaker implementuje 
	 * interfejs KeyListener).
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Publiczna statyczna metoda main klasy BrickBreaker.
	 * @param args parametr metody, kt�ry mo�e by� wprowadzony za pomoc� wiersza polece�
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		brickbreaker = new BrickBreaker();
	}

}
