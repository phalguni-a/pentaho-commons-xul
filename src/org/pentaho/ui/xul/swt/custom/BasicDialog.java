package org.pentaho.ui.xul.swt.custom;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.pentaho.ui.xul.swt.DialogButton;

public class BasicDialog extends TitleAreaDialog {

  private Composite dialogArea = null;
  private Composite contentArea = null;
  private Composite buttonArea = null;
  
  private int height = -999;
  private int width = -999; 
  
  public BasicDialog(Shell shell) {
    super(shell);
    create();
  }

  /**
   * For test purposes only
   * @param args params to main
   */
  public static void main(String[] args) {
    new BasicDialog(new Shell()).open();
  }

  @Override
  protected Control createContents(Composite parent) {
    
    contentArea = (Composite)super.createContents(parent);
    // TODO This should be dependent on whether we want to set up the header or not...
    getTitleImageLabel().dispose();
    return contentArea;
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    
    dialogArea = (Composite) super.createDialogArea(parent);
    return dialogArea;
  }
  
  public Composite getMainArea(){
    return dialogArea;
  }
  
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    buttonArea = parent;
  }
  
  public Button createButton(DialogButton dialogButton, boolean defaultButton){
    Button button = createButton(buttonArea, dialogButton.getId(), dialogButton.getLabel(), defaultButton);
    return button;
  }

  public Composite getButtonArea(){
    return buttonArea;
  }
  
  
  public void resizeBounds(){
    initializeBounds();
  }

  /**
   *  The dialog does a fine job of sizing appropriately, 
   *  but we must support fixed size as well.. 
   *  Don't set the height and width and the default initial 
   *  size should be reasonable. 
   */
  @Override
  protected Point getInitialSize() {
    
    if ((height > 0) && (width > 0)){
      return new Point(width, height);
    }
    return super.getInitialSize();
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  protected void buttonPressed(int buttonId) {
    // Empty on purpose
  }
  
}
