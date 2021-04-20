package cs5004.animator.controller;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.IView;
import cs5004.animator.view.visual.InteractiveView;

public class AnimationController implements Features {
  // TODO implement the change speed - popout that has increase/decrease and a text entry? (Marwa)
  private final ICanvas canvas;
  private final IView view;

  public AnimationController(ICanvas c, InteractiveView v) throws OperationNotSupportedException {
    this.canvas = c;
    this.view = v;
    //    this.view.setListener(this);
    this.view.addFeatures(this);
    this.view.reset();
  }

  @Override
  public void playPauseEvent() {
    try {
      view.playPause();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void resetEvent() {
    try {
      view.reset();
    } catch (OperationNotSupportedException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void loopEvent() {
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
