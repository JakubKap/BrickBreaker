package brick_breaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Klasa Panel, rozszerzaj¹ca klasê JPanel odpowiedzialna za interfejs graficzny aplikacji.
 * 
 * @author Jakub Kapusta I6X4S1
 * @version 1.0
 */
public class Panel extends JPanel{
	
	/**
	 * Prywatny atrybut serialVersionUID okreœlaj¹cy wersjê (id) klasy rozszerzaj¹cej JPanel. 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Prywatny statyczny atrybut d_green typu Color, przechowuj¹cy informacjê
	 * o kolorze bloczków.
	 */
	private static Color d_green =  new Color(4081976);
	
	/**
	 * Prywatny atrybut image_disk_start typu BufferedImage, przechowuj¹cy 
	 * grafikê ustawian¹ przy uruchomieniu aplikacji.
	 */
	private BufferedImage image_disk_start;
	
	/**
	 * Prywatny atrybut image_disk_go typu BufferedImage,
	 * przechowuj¹cy grafikê ustawian¹ przy przegranej.
	 */
	private BufferedImage image_disk_go;
	
	/**
	 * Prywatny atrybut image_disk_vi typu BufferedImage, 
	 * przechowuj¹cy grafikê ustawian¹ przy wygranej.
	 */
	private BufferedImage image_disk_vi;
	
	/**
	 * Prywatny atrybut score typu String, przechowuj¹cy aktualny wynik.
	 */
	private String score;
	
	/**
	 * Prywatny atrybut time typu String, przechowuj¹cy czas trwania rozgrywki.
	 */
	private String time;
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * Metoda paintComponent(Graphics g) s³u¿¹ca do rysowania po panelu np.:
	 * ustawienie grafiki, zmianê kolorów, wyœwietlanie tekstu.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		try {
			
			File imageFile1 = new File("BRICK-BREAKER.png");
			image_disk_start = ImageIO.read(imageFile1);
			
			File imageFile2 = new File("GAMEOVER.png");
			image_disk_go= ImageIO.read(imageFile2);
			
			File imageFile3 = new File("VICTORY.png");
			image_disk_vi = ImageIO.read(imageFile3);
			
		} catch(IOException e) {
			System.err.println("Blad odczytu obrazka z dysku.");
			e.printStackTrace();
		}
		
		Dimension dimension1 = new Dimension (image_disk_start.getWidth() , image_disk_start.getHeight());
		setPreferredSize(dimension1);
	
		Graphics2D g2d = (Graphics2D) g;
	
		BrickBreaker brickbreaker = BrickBreaker.brickbreaker;
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 700);
		int i_width = (1000 - image_disk_start.getWidth())/2;
		int i_height= (700 - image_disk_start.getHeight())/2;;
		g2d.drawImage(image_disk_start, i_width,i_height, this);
		
		
		if (!brickbreaker.getBegin())
		{
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 700);
			g.setColor(Color.RED);
			g.fillOval(brickbreaker.ball.getX(), brickbreaker.ball.getY(), brickbreaker.ball.getHeight(), brickbreaker.ball.getHeight());
			g.setColor(Color.CYAN);
			g.fillRect(brickbreaker.paddle.getX(), brickbreaker.paddle.getY(), brickbreaker.paddle.getWidth(), brickbreaker.paddle.getHeight());
			g.setColor(d_green);
			for (Block b : Block.blocks)
			{
				if(b.getVisible() == true)
				g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
				
			}
			
			score = "Score: " + brickbreaker.getScore();
			time = "Time: " + brickbreaker.getTicks()/70 + "s";
			g.setColor(Color.WHITE);
			g.setFont(new Font("serif",Font.BOLD,15));
			g.drawString(score, (int) (getWidth() / 2 - score.length() * 2.5f) - 75, 20);
			g.drawString(time, (int) (getWidth() / 2 - score.length() * 2.5f) + 75, 20);
		
		}
		
		if(brickbreaker.getGameover())
		{
			Dimension dimension2 = new Dimension (image_disk_go.getWidth() , image_disk_go.getHeight());
			setPreferredSize(dimension2);
			
			i_width = (1000 - image_disk_go.getWidth())/2;
			i_height= (700 - image_disk_go.getHeight())/2;
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 700);
			g2d.drawImage(image_disk_go, i_width,i_height, this);
			
			score = "Score: " + brickbreaker.getScore();  
			time = "Time: " + brickbreaker.getTicks()/70 + "s";
			g.setColor(Color.WHITE);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString(score, i_width, i_height + image_disk_go.getHeight() + 15);
			g.drawString(time, i_width + image_disk_go.getWidth() - 100, i_height + image_disk_go.getHeight() + 15);
		}
		
		if(brickbreaker.getWinner())
		{
			Dimension dimension3 = new Dimension (image_disk_vi.getWidth() , image_disk_vi.getHeight());
			setPreferredSize(dimension3);
			
			i_width = (1000 - image_disk_vi.getWidth())/2;
			i_height= (700 - image_disk_vi.getHeight())/2;
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1000, 700);
			g2d.drawImage(image_disk_vi, i_width,i_height, this);
			
			score = "Score: " + brickbreaker.getScore();  
			time = "Time: " + brickbreaker.getTicks()/70 + "s";
			g.setColor(Color.WHITE);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString(score, i_width, i_height + image_disk_vi.getHeight() + 15);
			g.drawString(time, i_width + image_disk_vi.getWidth() - 100, i_height + image_disk_vi.getHeight() + 15);
		}
	}

}
