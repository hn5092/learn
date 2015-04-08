package ri;
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
 * @date 2010-5-27, ����09:10:10
 */
public class JTextAreaTest extends JFrame implements ActionListener{
 JTextArea area=new JTextArea(20, 50);
 private JButton btn=new JButton("��ȡ�ļ���JTextArea...");

 public JTextAreaTest(String title) throws HeadlessException {
  super(title);
  setBounds(700,800,300,400);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  area.setFont(new Font("����", Font.PLAIN,16));
  area.setForeground(Color.red);
  add(new JScrollPane(area),BorderLayout.CENTER);
  JPanel panel=new JPanel();
  panel.add(btn);
  btn.addActionListener(this);
  area.setLineWrap(true);// �����Զ����й���
  add(panel,BorderLayout.SOUTH);
  validate();
 }
 
 public static void main(String[] args) {
  new JTextAreaTest("JTextArea����");
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btn){
   new FileReadThread(this).start();//�����ļ���ȡ�߳�
  }
 }
}










/**
 * �ļ���ȡ�߳�
 */
class FileReadThread extends Thread{
 private JTextAreaTest test;
 
 public FileReadThread(JTextAreaTest test) {
  this.test = test;
 }

 @Override
 public void run() {
  JFileChooser chooser=new JFileChooser("d:/");
  chooser.setFileFilter(new FileFilter() {//�����ļ�������,����ʾ�ļ��к�txt�ı�
   
   @Override
   public String getDescription() {
    return null;
   }
   
   @Override
   public boolean accept(File file) {
    if(file.isDirectory()||file.getName().endsWith(".txt"))   //�ļ�����,.�����ļ���ĩβ��ֵ��.txt
     return true;
    return false;
   }
  });
  int option=chooser.showOpenDialog(test);                
  if(option==JFileChooser.APPROVE_OPTION){   //ѡ��ȷ�ϣ�yes��ok���󷵻ظ�ֵ��
   File selFile=chooser.getSelectedFile();   //����ѡ���ļ�
   try {
    BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(selFile),"gbk"));
    String line=null;
    while ((line=reader.readLine())!=null) {
     test.area.append(line+"\n");
     Thread.sleep(30);//�߳���ͣ,�Կ�����ȡ����Ч��
    }
   } catch (Exception e1) {
    e1.printStackTrace();
   }
   JOptionPane.showMessageDialog(test, "��ȡ���");
  }
  
 }
 
}