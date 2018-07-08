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
 * Klasa BrickBreaker reprezentuj¹ca logikê gry oraz obs³ugê zdarzeñ
 * (implementuje interfejsy KeyListener oraz Action Listener).
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */

public class BrickBreaker implements KeyListener, ActionListener{

	
	/**
	 * Prywatny atrybut jframe, bêd¹cy obiektem klasy JFrame (ramka).
	 */
	private JFrame jframe;
	
	/**
	 * Prywatny atrybut panel, bêd¹cy obiektem klasy Panel, który zostanie dodany do ramki.
	 */
	private Panel panel;
	
	/**
	 * Prywatny atrybut toolkit, bêd¹cy obiektem klasy Toolkit, 
	 * który zostanie wykorzystany do ustawienia w³aœciwoœci ramki.
	 */
	private Toolkit toolkit;
	
	/**
	 * Prywatny atrybut img, bêd¹cy obiektem klasy Image, 
	 * w którym zostanie przechowana ikona aplikacji.
	 */
	private Image img;
	
	/**
	 * Publiczny statyczny atrybut brickreaker typu BrickBreaker, 
	 * który bêdzie siê odwo³ywa³ do nowoutworzonego obiektu typu Brickbreaker
	 * w funkcji main(). Atrybut ten jest publiczny i prywatny, po to aby
	 *  klasa Panel mia³a dostêp do atrybutów i metod klasy BrickBreaker (bêdzie mog³a siê 
	 *  odwo³ywaæ do tego atrybutu). 
	 */
	public static BrickBreaker brickbreaker;
	
	/**
	 * Prywatny atrybut dim typu Dimension przechowuj¹cy rozdzielczoœæ obrazu.
	 */
	private Dimension dim;
	
	/**
	 * Prywatny atrybut bêd¹cy timerem.
	 */
	private Timer timer = new Timer(10, this);
	
	/**
	 * Publiczny atrybut reprezentuj¹cy obiekt klasy Ball.
	 */
	public Ball ball;
	
	/**
	 * Publiczny atrybut reprezentuj¹cy obiekt klasy Paddle.
	 */
	public Paddle paddle;
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut LEFT_UP reprezentuj¹cy kierunek, 
	 * w którym pod¹¿a pi³ka - pó³nocny - zachód.
	 */
	private static final int LEFT_UP = 0;
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut RIGHT_UP reprezentuj¹cy kierunek, 
	 * w którym pod¹¿a pi³ka - pó³nocny - wschód.
	 */
	private static final int RIGHT_UP = 1;
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut LEFT_DOWN reprezentuj¹cy kierunek, 
	 * w którym pod¹¿a pi³ka - po³udniowy - zachód.
	 */
	private static final int LEFT_DOWN = 2; 
	
	/**
	 * Prywatny statyczny oraz niezmienny atrybut RIGHT_DOWN reprezentuj¹cy kierunek, 
	 * w którym pod¹¿a pi³ka - po³udniowy - wschód.
	 */
	private static final int RIGHT_DOWN = 3;
	
	/**
	 * Prywatny atrybut ticks typu int (reprezentuje liczbê inkrementacji wartoœci timera).
	 */
	private int ticks;
	
	/**
	 * Prywatny atrybut direction typu int (kierunek lotu pi³ki).
	 */
	private int direction;
	
	/**
	 * Prywatny atrybut score typu int (wynik gry).
	 */
	private int score;
	
	/**
	 * Prywatny atrybut paused typu boolean (informacja o tym, czy gra zosta³a zatrzymana - 
	 * wtedy atrybut przyjmuje wartoœæ true).
	 */
	private boolean paused; 
	
	/**
	 * Prywatny atrybut gameover typu boolean (informacja o tym, czy gracz przegra³ rozgrywkê -
	 * wtedy atrybut przyjmuje wartoœæ true).
	 */
	private boolean gameover;
	
	/**
	 * Prywatny atrybut winner typu boolean (informacja o tym, czy gracz wygra³ rozgrywkê - 
	 * wtedy atrybut przyjmuje wartoœæ true).
	 */
	private boolean winner;
	
	/**
	 * Prywatny atrybut start typu boolean (informacja o tym, czy gracz rozpocz¹³ rozgrywkê 
	 * (wprawi³ w ruch pi³kê za pomoc¹ klawisza strza³ki w górê) - 
	 * wtedy atrybut przyjmuje wartoœæ true).
	 */
	private boolean start;
	
	/**
	 * Prywatny atrybut begin typu boolean (informacja o tym, czy gracz po ujrzeniu ekranu 
	 * powitalnego, wcisn¹³ Enter - wtedy atrybut przyjmuje wartoœæ false).
	 */
	private boolean begin;
	
	/**
	 * Prywatny atrybut border typu boolean (informacja o tym, czy pi³ka odbi³a siê od 
	 * pionowej œciany platformy (paddle) - wtedy border przyjmuje wartoœæ true 
	 * oraz pi³ka nie odbija siê od platformy, co skutkuje przegraniem rozgrywki).
	 */
	private boolean border;
	
	/**
	 * Prywatny atrybut tablicowy, przechowuj¹cy 15 obiektów typu Block.
	 */
	private Block tab[] = new Block [15];
	  
	/**
	 * Publiczna metoda inicjuj¹ca grê w przypadku pora¿ki lub sukcesu. 
	 * Jest równie¿ wywo³ywana w konstruktorze.
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
	 * @return wartoœæ prywatnego atrybutu ticks
	 */
	public int getTicks()
	{
		return ticks;
	}
	
	/**
	 * Publiczna metoda getScore().
	 * @return wartoœæ prywatnego atrybutu score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Publiczna metoda getBegin().
	 * @return wartoœæ prywatnego atrybutu begin
	 */
	public boolean getBegin()
	{
		return begin;
	}
	
	/**
	 * Publiczna metoda getGameover().
	 * @return wartoœæ prywatnego atrybutu gameover
	 */
	public boolean getGameover()
	{
		return gameover;
	}
	
	/**
	 * Publiczna metoda getWinner().
	 * @return wartoœæ prywatnego atrybutu winner
	 */
	public boolean getWinner()
	{
		return winner;
	}
	
	/**
	 * Konstruktor klasy BrickBreaker.
	 */
	public BrickBreaker() {
		
		dim = Toolkit.getDefaultToolkit().getScreenSize(); //dopasowanie do rozdzielczoœci
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
	 * @param x badana wspó³rzêdna
	 * @param min ograniczenie dolne przedia³u (min, max)
	 * @param max ograniczenie górne przedia³u (min, max)
	 * @return jeœli x jest mniejsze od min, to zwracan¹ wartoœci¹ jest min;
	 * jeœli x jest wiêksze od max, zwracan¹ wartoœci¹ jest max;
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
	 * Publiczna metoda intersects_blocks() sprawdzaj¹ca, 
	 * czy czerwona pi³ka trafi³a w bloczek oraz w razie potrzeby, 
	 * zmieniaj¹ca kierunek jej lotu.
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
	 * Publiczna metoda intersects_paddle() sprawdzaj¹ca, czy czerwona pi³ka uderzy³a 
	 * w platformê.
	 * @return zmienna boolowska, która jeœli przyjmuje wartoœc true, 
	 * to oznacza, ¿e pi³ka uderzy³a w platformê lub false w przeciwnym wypadku
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
	 * interfejsu ActionListner) odpowiedzialna za logikê gry - wykrywanie zderzenia 
	 * ze œcianami, platform¹ oraz zmianê kierunku lotu pi³ki.
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
			 * spotkanie z paddle  praw¹ œcian¹
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
			 * spotkanie z paddle i lew¹ œcian¹
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
	 *odpowiedzialna za obs³ugê wciœniêtych klawiszy potrzebnych do rozgrywki.
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
	 * (jej nag³ówek jest niezbêdny, poniewa¿ klasa BrickBreaker implementuje 
	 * interfejs KeyListener).
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Publiczna niezaimplementowana metoda keyTyped(KeyEvent e)
	 * (jej nag³ówek jest niezbêdny, poniewa¿ klasa BrickBreaker implementuje 
	 * interfejs KeyListener).
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Publiczna statyczna metoda main klasy BrickBreaker.
	 * @param args parametr metody, który mo¿e byæ wprowadzony za pomoc¹ wiersza poleceñ
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		brickbreaker = new BrickBreaker();
	}

}
