import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*フォントの変更方法 参考
https://www.javadrive.jp/tutorial/jlabel/index3.html*/
/**
 *
 */

/**
 * @author g1620520
 *
 */
public class Display extends JFrame implements MouseListener, MouseMotionListener,ActionListener {
	private static final long serialVersionUID = 42L;

	JPanel map=new JPanel();
	Board thisworld;
	JLayeredPane layerPane=new JLayeredPane();

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int windoww = screenSize.width;
	int windowh = screenSize.height;

	JLabel label[];

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/*if(currenttoolnum==3){currentcolor=new Color(panel.getRGB(newx,newy));
			currentpanel.setPenColor(currentcolor);
			toolcolor.setForeground(currentcolor);
			currenttoolnum=0;
			toollabel.setText("tool:pen");}*/
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/*if(currenttoolnum==3){currentcolor=new Color(panel.getRGB(newx,newy));
			currentpanel.setPenColor(currentcolor);
			toolcolor.setForeground(currentcolor);
			currenttoolnum=0;
			toollabel.setText("tool:pen");}*/
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/*if(currenttoolnum==3){currentcolor=new Color(panel.getRGB(newx,newy));
			currentpanel.setPenColor(currentcolor);
			toolcolor.setForeground(currentcolor);
			currenttoolnum=0;
			toollabel.setText("tool:pen");}*/

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void init(Board world){
		thisworld=world;
		this.setTitle("Lifegame");
		this.setSize(windoww,windowh);


		//panel.setpaperSize(new Dimension(2480, 3508));


		Font f = new Font("Serif", Font.PLAIN, 50);
		label = new JLabel[thisworld.tate*thisworld.yoko];
		int target;
		String status;
		//make background --レベルの背景を作成
		for (int tate = 0; tate < thisworld.tate; tate++) {
			for(int yoko=0;yoko<thisworld.yoko;yoko++) {
				target=tate*thisworld.yoko+yoko;
				if (thisworld.status(target+1)==thisworld.dead){
					status="■";
				}else{
					status="□";
				}
				label[target] = new JLabel();
				label[target].setBounds(20+30 * yoko,30*tate,windoww/thisworld.tate,windoww/thisworld.tate);
				label[target].setText(status);
				label[target].setFont(f);
				layerPane.add(label[target]);

			}
		}

		layerPane.add(map);

		setContentPane(layerPane);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void change(Board world){
		String status;
		thisworld=world;
		for(int target=1;target<=thisworld.size();target++){
			if (thisworld.status(target)==thisworld.dead){
				status="■";
			}else{
				status="□";
			}
			label[target-1].setText(status);
		}

	}

	public void actionPerformed(ActionEvent e){

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board newworld= new Board(6,6);
		Display frame=new Display();
		frame.init(newworld);
	}

}

