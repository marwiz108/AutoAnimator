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
    this.view.setListener(this);
    this.view.reset();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    switch (e.getActionCommand()) {
      case ("Play/Pause"):
        playPauseEvent();
        break;
      case ("Reset"):
        resetEvent();
        break;
      case ("Loop"):
        loopEvent();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
    }
  }

  private void playPauseEvent() {
    try {
      view.playPause();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  private void resetEvent() {
    try {
      view.reset();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  private void loopEvent() {
    try {
      view.toggleLoop();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  //  private void increaseSpeedEvent() {
  //    increaseSpeed.addActionListener(new ActionListener() {
  //      @Override
  //      public void actionPerformed(ActionEvent e) {
  //        try {
  //          v.increaseSpeed();
  //        } catch (OperationNotSupportedException exception) {
  //          exception.printStackTrace();
  //        }
  //      }
  //    });
  //  }
  //
  //  private void decreaseSpeedEvent() {
  //    decreaseSpeed.addActionListener(new ActionListener() {
  //      @Override
  //      public void actionPerformed(ActionEvent e) {
  //        try {
  //          v.decreaseSpeed();
  //        } catch (OperationNotSupportedException exception) {
  //          exception.printStackTrace();
  //        }
  //      }
  //    });
}
