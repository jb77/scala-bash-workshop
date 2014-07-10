import javax.swing.JDialog
import javax.swing.JLabel

object javainterop {
  
  
  val dlg=new JDialog                             //> dlg  : javax.swing.JDialog = javax.swing.JDialog[dialog0,0,0,0x0,invalid,hid
                                                  //| den,layout=java.awt.BorderLayout,MODELESS,title=,defaultCloseOperation=HIDE_
                                                  //| ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.
                                                  //| JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,ma
                                                  //| ximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]
  dlg.setTitle("test dialog")
	dlg.getContentPane.add(new JLabel("Hello World"))
                                                  //> res0: java.awt.Component = javax.swing.JLabel[,0,0,0x0,invalid,alignmentX=0.
                                                  //| 0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSi
                                                  //| ze=,defaultIcon=,disabledIcon=,horizontalAlignment=LEADING,horizontalTextPos
                                                  //| ition=TRAILING,iconTextGap=4,labelFor=,text=Hello World,verticalAlignment=CE
                                                  //| NTER,verticalTextPosition=CENTER]
	dlg.pack//setSize(100, 100)
	dlg.setVisible(true)
}