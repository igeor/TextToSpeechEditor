package view;

import java.awt.Font;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.text.Element;

public class EditorPane extends JEditorPane {

	public EditorPane() {
		super();
		super.setEditable(false);
		super.setEnabled(true);
	}
	
	public int getSelectedLine() {
		int caretPosition = super.getCaretPosition();
        Element root = super.getDocument().getDefaultRootElement();
		return root.getElementIndex( caretPosition ) ;
	}

	public void setPage(String contents) {	super.setText(contents);	}
	
}
