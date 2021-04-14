package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class AbstractTextView implements TextView {

  protected ICanvas canvas;
  protected JFrame frame;
  protected JPanel panel;
  protected JScrollPane scrollPane;
  protected String text;

  public AbstractTextView(ICanvas canvas) {
    this.canvas = canvas;
    this.text = this.generateText();

    this.frame = new JFrame("Easy Animator Text");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//    this.panel = new JPanel();
//    this.panel.setBackground(Color.BLUE);

    JTextArea textArea = new JTextArea(this.text);
    textArea.setEditable(false);

    this.scrollPane = new JScrollPane(textArea);
    this.frame.add(this.scrollPane);

    this.frame.pack();
    this.frame.setVisible(true);
  }

  @Override
  public void render() {
    return;
  }
}
