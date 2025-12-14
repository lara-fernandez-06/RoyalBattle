package battleRoyale_v1;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import battleRoyale_v1.SettingsActionPerformed.BotonNextListener;
import battleRoyale_v1.SettingsActionPerformed.BoxAnchoListener;


public class InterfazRB {
	public static void inicializarInterfaz() {	
		//Al comenzar te va a salir los settings
		Settings.settingsInicio();
		//Una vez acabes con settings, lo siguiente es el menú de inicio
	}
	
}
