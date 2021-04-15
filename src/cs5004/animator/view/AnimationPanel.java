package cs5004.animator.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.Transformation;

public class AnimationPanel extends JPanel {
  private final ArrayList<Shape> shapes;

  public AnimationPanel(ArrayList<Shape> shapes) {
    this.shapes = shapes;
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    for (Shape s : this.shapes) {
      g.setColor(s.getColor());
      s.fill(g2);
    }
  }
}
