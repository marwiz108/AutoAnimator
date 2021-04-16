package cs5004.animator.view;

public interface ViewFactory {

  IView create(String viewType);

  IView create(String viewType, int delay);
}
