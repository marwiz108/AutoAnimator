package cs5004.animator.view.visual;

import java.awt.*;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;

import cs5004.animator.controller.Features;
import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.IView;

public class InteractiveView extends JFrame implements IView {

  private final ICanvas canvas;
  private AnimationPanel animationPanel;
  private GUIPanel guiPanel;
  private speedControls speedControls;

  public InteractiveView(ICanvas canvas, float delay) throws OperationNotSupportedException {
    this.canvas = canvas;
    createAndShow((int) delay);
  }

  @Override
  public void createAndShow(int delay) {
    this.speedControls = new speedControls(delay);
    this.animationPanel = new AnimationPanel(this.canvas, delay);
    this.animationPanel.setPreferredSize(
        new Dimension(this.canvas.getBorderWidth(), this.canvas.getBorderHeight()));
    JScrollPane scroll = new JScrollPane(this.animationPanel);
    this.guiPanel =
        new GUIPanel(
            this.canvas.getLeftMostX(),
            this.canvas.getTopMostY() - this.canvas.getBorderHeight() - 10,
            this.canvas.getBorderWidth());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(scroll, BorderLayout.CENTER);
    add(this.guiPanel, BorderLayout.PAGE_END);
    pack();
    setSize(new Dimension(this.canvas.getBorderWidth(), this.canvas.getBorderHeight() + 100));
    setVisible(true);
  }

  @Override
  public void reset() {
    this.animationPanel.stopTimer();
    this.canvas.resetDynamicShapes();
    this.animationPanel.setFrame(0);
    this.animationPanel.resetSpeed();
    this.animationPanel.startTimer();
  }

  @Override
  public void addFeatures(Features features) {
    this.guiPanel.addFeatures(features);
  }

  @Override
  public void toggleLoop() {
    this.animationPanel.toggleRepeat();
  }

  @Override
  public void playPause() {
    this.animationPanel.toggleTimer();
    if (this.animationPanel.isPaused()) {
      this.guiPanel.updatePlayPauseTitle("Play");
    } else {
      this.guiPanel.updatePlayPauseTitle("Pause");
    }
  }

  @Override
  public void showSpeedControls() {
    this.speedControls.showSpeedControls();
  }

  @Override
  public void setSpeed(int fps) {
    this.animationPanel.setSpeed(fps);
  }

  @Override
  public String generateText(float delay) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void createFile(String filename) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
