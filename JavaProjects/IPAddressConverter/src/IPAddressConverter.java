/**
 * ---------------------------------------------------------------------------
 * File name: IPAddressConverter.java
 * Project name: IPAddressConverter
 * ---------------------------------------------------------------------------
 * Creator's name and email: Allison Ivey, iveyas@goldmail.etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Feb 5, 2016
 * ---------------------------------------------------------------------------
 */

/**
 * This program will look at a given IP address and 
 * display the class, default subnet mask, number of 
 * network bits, number of host bits, size of network, 
 * network address and broadcast address.  
 *
 * <hr>
 * Date created: Feb 5, 2016
 * <hr>
 * @author Allison Ivey
 */
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class IPAddressConverter extends JFrame
{
	public void IPAddressConverterNoError()
	{
		char class1 = 'A';
		String strSubnetMask= "";
		int iNetworkBits= 0;
		int iHostBits = 0;
		int iNetworkSize= 0;
		String strNetworkAddress= "";
		String strBroadcastAddress= "";
		boolean validAnswer = false;
		getContentPane().setLayout(new FlowLayout());
		
		
		JTextField input1 = new JTextField(null, 3);
		JTextField input2 = new JTextField(null, 3);
		JTextField input3 = new JTextField(null, 3);
		JTextField input4 = new JTextField(null, 3);
		JPanel message = new JPanel();
		message.add(new JLabel("Enter the IP Address"));
		message.add (input1);
		message.add (new JLabel("."));
		message.add (input2);
		message.add (new JLabel("."));
		message.add (input3);
		message.add (new JLabel("."));
		message.add (input4);
		while(validAnswer==false)
		{
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int result = JOptionPane.showConfirmDialog (null, message, "Enter the IP Address", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.OK_OPTION)
		{
			String strInput1 = input1.getText ( );
			String strInput2 = input2.getText ( );
			String strInput3 = input3.getText ( );
			String strInput4 = input4.getText ( );
			int iInput1 = Integer.parseInt (strInput1);
			int iInput2 = Integer.parseInt (strInput2);
			int iInput3 = Integer.parseInt (strInput3);
			int iInput4 = Integer.parseInt (strInput4);
			
			if(iInput1>= 0 && iInput1<=223 && iInput2>=0 && iInput2<=255 &&
				iInput3>=0 && iInput3<=255 && iInput4>=0 && iInput4<=255)
			{
				if(iInput1>=0 && iInput1<=127)
				{
					class1= 'A';
					strSubnetMask= "255.0.0.0";
					iNetworkBits= 8;
					iHostBits = 24;
					iNetworkSize= 16777216;
					strNetworkAddress= strInput1+".0.0.0";
					strBroadcastAddress= strInput1+".255.255.255";
				}
					else 
					{
						if(iInput1>=128 && iInput1<=191)
						{
							class1= 'B';
							strSubnetMask= "255.255.0.0";
							iNetworkBits= 16;
							iHostBits = 16;
							iNetworkSize= 65536;
							strNetworkAddress= strInput1+"."+ strInput2 + ".0.0";
							strBroadcastAddress= strInput1+"."+strInput2+".255.255";
						}
						else 
						{	
							if(iInput1>=192 && iInput1<=223)
							{
								class1= 'C';
								strSubnetMask= "255.255.255.0";
								iNetworkBits= 24;
								iHostBits = 8;
								iNetworkSize= 256;
								strNetworkAddress= strInput1+"."+strInput2+ "." +strInput3+".0";
								strBroadcastAddress= strInput1+"."+strInput2+ "." +strInput3+".255";
							}
							
						}
					}
					
				
				JOptionPane.showMessageDialog(null,"Entered IP Address\t: " + strInput1+"."+ strInput2 + "."+ strInput3+ "." +
						strInput4 + "\nClass:\t" + class1 + "\nDefault Subnet Mask:\t"+ strSubnetMask+ "\nNetwork Bits:\t"+ iNetworkBits + "\nHost Bits:\t"+
						iHostBits + "\nNetwork Size:\t" + iNetworkSize + "\nNetwork Address:\t" + strNetworkAddress+
						"\nBroadcast Address:\t" + strBroadcastAddress);
				
			}
			else
			{
				if(iInput1< 0 || iInput1>223 || iInput2<0 || iInput2>255 ||
								iInput3<0 || iInput3>255 || iInput4<0 || iInput4>255)
				{
					ErrorMessage();
					validAnswer = false;
				}
			}
			
			}
		if(result != JOptionPane.OK_OPTION)
		{
			validAnswer=true;
		}
		}
	}
	
	public void ErrorMessage()
	{
		JOptionPane.showMessageDialog (this, "Sorry that was not a valid entery." +
		"\nPlease enter a number between 0 an 255", "Try Again", JOptionPane.ERROR_MESSAGE, null);
					
	}
}
