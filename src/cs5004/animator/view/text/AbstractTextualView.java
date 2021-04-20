package cs5004.animator.view.text;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.naming.OperationNotSupportedException;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.IView;

/** Abstract class for a text-based view that defines common methods for these classes. */
public abstract class AbstractTextualView implements IView {

  protected ICanvas canvas;
  protected JFrame frame;
  protected JScrollPane scrollPane;
  protected String text;
  protected float delay;

  /**
   * Super constructor for a TextView and SVGView.
   *
   * @param canvas the canvas object containing the shape and transformation data.
   * @param delay the delay (in ms) between each frame.
   */
  public AbstractTextualView(ICanvas canvas, String outFile, float delay) {
    this.canvas = canvas;
    this.delay = delay;
    this.text = this.generateText(delay);

    if (outFile != null) {
      this.createFile(outFile);
    } else {
      System.out.println(this.text);
    }

    this.frame = new JFrame("Easy Animator TextView");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextArea textArea = new JTextArea(this.text);
    textArea.setEditable(false);

    this.scrollPane = new JScrollPane(textArea);
    this.frame.add(this.scrollPane);

    this.frame.pack();
    this.frame.setVisible(true);
  }

  @Override
  public void createFile(String filename) {
    // creates .txt file for TextView and .xml file for SVGView
    try {
      FileWriter newFile = new FileWriter(filename);

      BufferedWriter writer = new BufferedWriter(newFile);
      writer.write(this.text);

      writer.close();
    } catch (IOException e) {
      System.out.println("Error occurred.");
      e.printStackTrace();
    }
  }

  @Override
  public void setSpeed(int fps) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void increaseSpeed() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void decreaseSpeed() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toSVGString(this.delay);
  }

  @Override
  public void createAndShow(int delay) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void reset(ActionListener listener) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void playPause() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void pause() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void playFromFrame(float frame) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
