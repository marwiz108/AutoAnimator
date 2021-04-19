package cs5004.animator.view.visual;

import javax.naming.OperationNotSupportedException;
import javax.swing.JFrame;

import cs5004.animator.view.IView;

public class InteractiveView extends JFrame implements IView {

  @Override
  public void createAndShow(int delay) throws OperationNotSupportedException {}

  @Override
  public void reset() throws OperationNotSupportedException {}

  @Override
  public void pause() throws OperationNotSupportedException {}

  @Override
  public void playFromFrame(float frame) throws OperationNotSupportedException {}

  @Override
  public String generateText(float delay) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void createFile(String filename) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
