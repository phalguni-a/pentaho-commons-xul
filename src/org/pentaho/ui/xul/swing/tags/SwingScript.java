/**
 * 
 */
package org.pentaho.ui.xul.swing.tags;

import org.pentaho.ui.xul.XulDomContainer;
import org.pentaho.ui.xul.XulElement;
import org.pentaho.ui.xul.components.XulScript;
import org.pentaho.ui.xul.swing.SwingElement;

/**
 * @author OEM
 *
 */
public class SwingScript extends SwingElement implements XulScript{
  private String id;
  private String src;

  public SwingScript(XulElement parent, XulDomContainer domContainer, String tagName) {
    super("script");
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getSrc() {
    return src;
  }
  
  public void setSrc(String className) {
    this.src = className;
  }

  public void layout(){
  }

}
