import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClientThread implements Runnable{
		DataInputStream dis;
		// MyClient client;
		Sample client;

		ClientThread(DataInputStream dis,Sample client){
			this.dis=dis;
			this.client=client;
		}
	////////////////////////
		public void run(){
			String s2="";
			do{
				try{
					s2=dis.readUTF();
					if(s2.startsWith(MyServer.UPDATE_USERS))
						updateUsersList(s2);
					else if(s2.equals(MyServer.LOGOUT_MESSAGE))
						break;
					else if(s2.split(" ")[0].equals(MyServer.MITM_MESSAGE)){
						String[] s = s2.split(" ");
						String msg = "";
						for(int i=1;i<s.length;i++){
							msg += s[i];
							msg+=" ";
						}
						JOptionPane.showMessageDialog(null, "MAN IN THE MIDDLE MESSAGE: "+msg, "", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						client.txtBroadcast.append("\n"+s2);
					
					int lineOffset=client.txtBroadcast.getLineStartOffset(client.txtBroadcast.getLineCount()-1);
					client.txtBroadcast.setCaretPosition(lineOffset);
				}
				catch(Exception e){
					client.txtBroadcast.append("\nClientThread run : "+e);
				}
			}while(true);
		}
	//////////////////////////


	public void updateUsersList(String ul){
		Vector ulist=new Vector();

		ul=ul.replace("[","");
		ul=ul.replace("]","");
		ul=ul.replace(MyServer.UPDATE_USERS,"");
		StringTokenizer st=new StringTokenizer(ul,",");

		while(st.hasMoreTokens()){
			String temp=st.nextToken();
			ulist.add(temp);
		}
		client.usersList.setListData(ulist);
	}
		/////////////////////////
	
}