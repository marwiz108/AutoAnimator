package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.MoveT;

public class AnimationFrame extends JFrame implements AnimationView, ActionListener {

//  private final JPanel panel;
//  private final JFrame f;
//  private final JScrollPane scrollPane;
  private final ICanvas canvas;

  public AnimationFrame(ICanvas c) {
    this.canvas = c;
    JPanel panel = new AnimationPanel();
    panel.setPreferredSize(new Dimension(c.getBorderWidth(), c.getBorderHeight()));
    JScrollPane scroll = new JScrollPane(panel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(scroll, BorderLayout.CENTER);
    setSize(new Dimension(c.getBorderWidth(), c.getBorderHeight()));
    setVisible(true);
  }

  public static void main(String[] args) {
    ICanvas c = new ICanvasModel();
    c.setCanvasBounds(0,0, 1000, 700);
    Shape oval = new Oval("o", 50, 50,
            30, 60, 255, 0, 0);
    c.addShape(oval);
    c.addTransformation(oval.getIdentifier(),
            new MoveT(oval, 2, 6, 50, 50, 100, 100));

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        AnimationFrame animationFrame = new AnimationFrame(c);
      }
    });
  }

  @Override
  public void renderAtFrame(float frame) {
    return;
  }

  @Override
  public void reset() {
    return;
  }

  @Override
  public void play() {
    return;
  }

  @Override
  public void pause() {
    return;
  }

  @Override
  public void playFromFrame(float frame, float speed, boolean reverse) {
    return;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  }
}
