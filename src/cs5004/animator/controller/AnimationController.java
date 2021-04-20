package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.IView;
import cs5004.animator.view.visual.InteractiveView;

public class AnimationController implements IController, ActionListener {

  private final ICanvas canvas;
  private final IView view;

  public AnimationController(ICanvas c, InteractiveView v) throws OperationNotSupportedException {
    this.canvas = c;
    this.view = v;
    this.view.reset(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
  }
}
