package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

/**
 * @author wsj
 * @date 2010-5-27, 下午09:10:10
 */
public class JTextAreaTest extends JFrame implements ActionListener{
 JTextArea area=new JTextArea(20, 50);
 private JButton btn=new JButton("读取文件到JTextArea...");

 public JTextAreaTest(String title) throws HeadlessException {
  super(title);
  setBounds(100,100,900,500);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  area.setFont(new Font("宋体", Font.PLAIN,16));
  area.setForeground(Color.red);
  add(new JScrollPane(area),BorderLayout.CENTER);
  JPanel panel=new JPanel();
  panel.add(btn);
  btn.addActionListener(this);
  add(panel,BorderLayout.SOUTH);
  validate();
 }
 
 public static void main(String[] args) {
  new JTextAreaTest("JTextArea测试");
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btn){
   new FileReadThread(this).start();//开启文件读取线程
  }
 }
}










/**
 * 文件读取线程
 */
class FileReadThread extends Thread{
 private JTextAreaTest test;
 
 public FileReadThread(JTextAreaTest test) {
  this.test = test;
 }

 @Override
 public void run() {
  JFileChooser chooser=new JFileChooser("d:/");
  chooser.setFileFilter(new FileFilter() {//定义文件过滤器,仅显示文件夹和txt文本
   
   @Override
   public String getDescription() {
    return null;
   }
   
   @Override
   public boolean accept(File file) {
    if(file.isDirectory()||file.getName().endsWith(".txt"))   //文件存在,.并且文件的末尾的值是.txt
     return true;
    return false;
   }
  });
  int option=chooser.showOpenDialog(test);                
  if(option==JFileChooser.APPROVE_OPTION){   //选择确认（yes、ok）后返回该值。
   File selFile=chooser.getSelectedFile();   //返回选中文件
   try {
    BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(selFile),"gbk"));
    String line=null;
    while ((line=reader.readLine())!=null) {
     test.area.append(line+"\n");
     Thread.sleep(30);//线程暂停,以看到读取过程效果
    }
   } catch (Exception e1) {
    e1.printStackTrace();
   }
   JOptionPane.showMessageDialog(test, "读取完毕");
  }
  
 }
 
}