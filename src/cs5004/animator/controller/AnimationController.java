package cs5004.animator.controller;

import cs5004.animator.view.GUIView;
import cs5004.animator.view.visual.InteractiveView;

/** Controller class for the interactive view. */
public class AnimationController implements Features {
  private final GUIView view;

  /**
   * Instantiate a controller object.
   *
   * @param v the interactive view object that this controller deals with.
   */
  public AnimationController(InteractiveView v) {
    this.view = v;
    this.view.addFeatures(this);
    this.view.reset();
  }

  @Override
  public void playPauseEvent() {
    view.playPause();
  }

  @Override
  public void resetEvent() {
    view.reset();
  }

  @Override
  public void loopEvent() {
    view.toggleLoop();
  }

  @Override
  public void showSpeedControls() {
    view.showSpeedControls();
  }

  @Override
  public void changeSpeed(int fps) {
    view.setSpeed(fps);
  }

  @Override
  public void showSaveControls() {
    view.showSaveControls();
  }

  @Override
  public void saveAsSVG() {
    view.saveFile(".svg");
  }

  @Override
  public void saveAsTxt() {
    view.saveFile(".txt");
  }
}
