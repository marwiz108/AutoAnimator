package cs5004.animator.view.visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Features;
import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.GUIView;
import cs5004.animator.view.IView;
import cs5004.animator.view.controls.GUIPanel;
import cs5004.animator.view.controls.SaveControls;
import cs5004.animator.view.controls.SpeedControls;
import cs5004.animator.view.text.SVGView;
import cs5004.animator.view.text.TextView;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/** View that allows for user interaction. */
public class InteractiveView extends JFrame implements IView, GUIView {

  private final ICanvas canvas;
  private final int fps;
  private int dynamicFps;
  private AnimationPanel animationPanel;
  private GUIPanel guiPanel;
  private SpeedControls speedControls;
  private SaveControls saveControls;

  /**
   * Create an instance of InteractiveView.
   *
   * @param canvas reference to the model that contains information on Shape objects.
   * @param delay the delay (in ms) between frames of the animation.
   */
  public InteractiveView(ICanvas canvas, float delay) {
    this.canvas = canvas;
    createAndShow((int) delay);
    fps = 1000 / (int) delay;
    dynamicFps = this.fps;
  }

  @Override
  public void createAndShow(int delay) {
    this.speedControls = new SpeedControls(1000 / delay);
    this.saveControls = new SaveControls();
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
  public AnimationPanel getAnimationPanel() {
    return this.animationPanel;
  }

  @Override
  public void reset() {
    this.speedControls.setFps(this.fps);
    this.guiPanel.updatePlayPauseTitle("Pause");
    this.animationPanel.stopTimer();
    this.canvas.resetDynamicShapes();
    this.animationPanel.setFrame(0);
    this.animationPanel.resetSpeed();
    this.animationPanel.setPaused(false);
    this.animationPanel.startTimer();
  }

  @Override
  public void addFeatures(Features features) {
    this.speedControls.addFeatures(features);
    this.guiPanel.addFeatures(features);
    this.saveControls.addFeatures(features);
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
    this.dynamicFps = fps;
    this.speedControls.setFps(fps);
    this.animationPanel.setSpeed(fps);
  }

  @Override
  public void showSaveControls() {
    this.saveControls.setVisible(true);
  }

  @Override
  public void saveFile(String ext) {
    String outFile = "output/" + saveControls.getFilename() + ext;
    float delay = 1000 / (float) this.dynamicFps;
    IView saveAs;
    ICanvas newCanvas = this.canvas;
    newCanvas.resetDynamicShapes();
    if (ext.equals(".svg")) {
      saveAs = new SVGView(newCanvas, outFile, delay);
    } else {
      saveAs = new TextView(newCanvas, outFile);
    }
    saveControls.setVisible(false);
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
