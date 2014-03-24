/**
 * 
 */
package com.boroborome.finance.web.applet;

import java.applet.Applet;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

/**
 * @author boroborome
 *
 */
public class SayHello extends Applet
{
	private JLabel lblMessage = new JLabel();
	
	public SayHello()
	{
		this.setLayout(new GridBagLayout());
		lblMessage.setText("Hello");
		this.add(lblMessage, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	public void hello(String name)
	{
		lblMessage.setText("Hello " + name);
	}
}
