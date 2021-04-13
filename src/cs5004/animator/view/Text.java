package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.MoveT;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Text extends AbstractTextView {

  private final JFrame frame;
  private final JPanel panel;
  private final JScrollPane scrollPane;
  private String text;

  public Text(ICanvas canvas) {
    this.text = canvas.toString();
    this.frame = new JFrame("Easy Animator Text");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.panel = new JPanel();

    JTextArea textArea = new JTextArea(this.text);
    textArea.setEditable(false);

    this.scrollPane = new JScrollPane(textArea);

    this.panel.add(this.scrollPane);

//    this.frame.getContentPane().add(this.scrollPane);

    this.frame.add(this.panel, BorderLayout.CENTER);
//    this.frame.getContentPane().add(textArea);

    this.frame.pack();
    this.frame.setVisible(true);
  }

  @Override
  public String generateText(ICanvas canvas) {
    this.text = canvas.toString();
    return this.text;
  }

  @Override
  public void createFile() {
    this.frame.add(this.panel);

    JTextArea textArea = new JTextArea(this.text);
    this.frame.getContentPane().add(textArea);
  }

  public static void main(String[] args) {
    ICanvas canvas = new ICanvasModel();
    Shape oval = new Oval("o", 50, 50,
        30, 60, 255, 0, 0);
    canvas.addShape(oval);
    canvas.addTransformation(oval.getIdentifier(),
        new MoveT(oval, 2, 6, 50, 50, 100, 100));

    Text textview = new Text(canvas);
  }
}
