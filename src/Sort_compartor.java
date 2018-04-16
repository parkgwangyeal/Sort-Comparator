import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.util.*;
import java.awt.TextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Sort_compartor extends JFrame {

   private JPanel contentPane;
   private JTextField textField1;
   private JTextField textField2;
   static int k;
   int startNum;
   static int Num;
   static int[] data = new int[Num];
   String sort;
   long end;
   long start;
   private final Action action = new SwingAction();

   
   public static void main(String[] args) {

	   
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	Sort_compartor frame = new Sort_compartor();
               frame.setVisible(true);

            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Sort_compartor() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 621, 393);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      textField1 = new JTextField();
      textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
      textField1.setHorizontalAlignment(SwingConstants.CENTER);
      textField1.setText("10000");
      textField1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            startNum = Integer.parseInt(textField1.getText());

         }
      });
      textField1.setBounds(397, 11, 186, 30);
      contentPane.add(textField1);
      textField1.setColumns(10);

      textField2 = new JTextField();
      textField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
      textField2.setHorizontalAlignment(SwingConstants.CENTER);
      textField2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            k = Integer.parseInt(textField2.getText());
         }
      });
      textField2.setText("5000");
      textField2.setBounds(397, 62, 186, 30);
      contentPane.add(textField2);
      textField2.setColumns(10);

      JLabel label = new JLabel("\uCD08\uAE30 \uB370\uC774\uD130 \uC218");
      label.setBounds(315, 11, 72, 30);
      contentPane.add(label);

      JLabel lblNewLabel = new JLabel("\uB370\uC774\uD130 \uC99D\uAC00\uB7C9");
      lblNewLabel.setBounds(315, 66, 72, 22);
      contentPane.add(lblNewLabel);

      JComboBox comboBox1 = new JComboBox();
      comboBox1.setModel(new DefaultComboBoxModel(new String[] {"\uC120\uD0DD\uC815\uB82C", "\uC0BD\uC785\uC815\uB82C", "\uC258\uC815\uB82C", "\uAE30\uC218\uC815\uB82C", "\uD569\uBCD1\uC815\uB82CTD", "\uD569\uBCD1\uC815\uB82CBU"}));
      comboBox1.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {

            sort = String.valueOf(comboBox1.getSelectedItem());

         }
      });

      comboBox1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      comboBox1.setBounds(131, 16, 133, 22);
      contentPane.add(comboBox1);

      JLabel label_1 = new JLabel("\uC815\uB82C \uC54C\uACE0\uB9AC\uC998");
      label_1.setBounds(23, 3, 85, 46);
      contentPane.add(label_1);

      JLabel label_2 = new JLabel("\uC2E4\uD589 \uACB0\uACFC:");
      label_2.setBounds(10, 120, 151, 22);
      contentPane.add(label_2);

      JLabel lblNewLabel_1 = new JLabel("\uC2E4\uD5D8 \uC774\uB825:");
      lblNewLabel_1.setBounds(315, 128, 102, 14);
      contentPane.add(lblNewLabel_1);

      JComboBox comboBox2 = new JComboBox();
      comboBox2.setModel(new DefaultComboBoxModel(
            new String[] { "\uBB34\uC791\uC704", "\uC624\uB984\uCC28\uC21C", "\uB0B4\uB9BC\uCC28\uC21C" }));
      comboBox2.setBounds(131, 49, 133, 20);
      contentPane.add(comboBox2);

      TextArea textArea1 = new TextArea();
      textArea1.setBounds(10, 148, 269, 196);
      contentPane.add(textArea1);

      TextArea textArea2 = new TextArea();
      textArea2.setBounds(314, 148, 269, 196);
      contentPane.add(textArea2);

      JButton btnNewButton = new JButton("\uC54C\uACE0\uB9AC\uC998 \uC2E4\uD589");
      btnNewButton.setFont(new Font("굴림", Font.BOLD, 17));
      btnNewButton.setForeground(Color.RED);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)  {
            Mysort a = new Mysort();
            int d = Integer.parseInt(textField1.getText());
            int b = Integer.parseInt(textField2.getText());
            String g = String.valueOf(comboBox1.getSelectedItem());
            String h = String.valueOf(comboBox2.getSelectedItem());
            if (g == "선택정렬" && h == "무작위") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.s(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");
                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
                  

               }
            
            else if (g == "선택정렬" && h == "오름차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  
                  start = System.currentTimeMillis();
                  Mysort.s(dat);
                  end = System.currentTimeMillis();
                  
                  long time = end - start;
                  textArea1.append(i+"개 "+g+":"+ (double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "선택정렬" && h == "내림차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.s(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "삽입정렬" && h == "무작위") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.Insert(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "삽입정렬" && h == "오름차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.Insert(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "삽입정렬" && h == "내림차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.Insert(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "쉘정렬" && h == "무작위") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.shell(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }

            else if (g == "쉘정렬" && h == "오름차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.shell(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }

            else if (g == "쉘정렬" && h == "내림차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.shell(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "기수정렬" && h == "무작위") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.r(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }

            else if (g == "기수정렬" && h == "오름차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.r(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }

            else if (g == "기수정렬" && h == "내림차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.r(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "합병정렬TD" && h == "무작위") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.MergeTD(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");
                  if(i==55000){
                  textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                  }
               }
               textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "합병정렬TD" && h == "오름차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.MergeTD(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "합병정렬TD" && h == "내림차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.MergeTD(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "합병정렬BU" && h == "무작위") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.MergeBU(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

               }
            }
            else if (g == "합병정렬BU" && h == "오름차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.MergeBU(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }
            else if (g == "합병정렬BU" && h == "내림차순") {

               for (int i = d; i < d + (b * 10); i += b) {
                  int dat[] = a.select(i, h);
                  start = System.currentTimeMillis();
                  Mysort.MergeBU(dat);
                  end = System.currentTimeMillis();
                  long time = end - start;
                  textArea1.append(i+"개 "+g+ ":"+(double) time / 1000 + "\n");

                  if(i==55000){
                     textArea2.append(i+"개 "+g+"를 "+h+"로 했을떄:"+(double) time / 1000 + "\n");
                     }
                  }
                  textArea1.append("\n"+"=============================="+"\n\n");
            }


         }
      });
      btnNewButton.setBounds(43, 75, 231, 42);
      contentPane.add(btnNewButton);
      
      JLabel label_3 = new JLabel("\uCD08\uAE30 \uB370\uC774\uD130 \uC120\uD0DD");
      label_3.setBounds(23, 35, 108, 46);
      contentPane.add(label_3);
      
      JLabel lblNewLabel_2 = new JLabel("New label");
      lblNewLabel_2.setBounds(218, -18, 46, 22);
      contentPane.add(lblNewLabel_2);
   }
   private class SwingAction extends AbstractAction {
      public SwingAction() {
         putValue(NAME, "SwingAction");
         putValue(SHORT_DESCRIPTION, "Some short description");
      }
      public void actionPerformed(ActionEvent e) {
      }
   }
}
class Mysort {
	   static int Num = 0;

	   static int[] data;

	   public int[] select(int d, String k) {
	   
	      data = null;
	      Num = d;
	      data = new int[Num];

	      Random random = new Random();

	      for (int i = 0; i < Num; i++) {
	         data[i] = Math.abs(random.nextInt());
	      }
	      if (k == "무작위") {

	      } else if (k == "오름차순") {
	         Arrays.sort(data);
	      } else if (k == "내림차순") {
	         Arrays.sort(data);

	         for (int i = 0; i < (data.length / 2); i++) {
	            int temp = data[i];
	            data[i] = data[data.length - i - 1];
	            data[data.length - i - 1] = temp;
	         }
	      }
	      return data;
	   }
	   public static void s(int[] a) {
	      int N = a.length;
	      for (int i = 0; i < N; i++) {
	      int min = i;
	      for (int j = i+1; j < N; j++) {
	      if ((a[j]< a[min]))
	      min = j;
	      }
	      int t = a[min];
	      a[min] = a[i];
	      a[i] = t;
	      
	      }
	      }

	   static void Insert(int data[]) {

	      for (int i = 0; i < data.length; i++) {
	         int temp = data[i];
	         int j = i - 1;
	         while ((j >= 0) && (data[j] > temp)) {
	            data[j + 1] = data[j];
	            j--;
	         }
	         data[j + 1] = temp;
	      }

	   }

	   static void shell(int a[]) {

	      int N = a.length;
	      int h = 1;
	      while (h < N / 3)
	         h = 3 * h + 1; 
	      while (h >= 1) { 
	         for (int i = h; i < N; i++)
	            for (int j = i; j >= h && (a[j]<a[j-h]); j -= h){
	               int t = a[j-h];
	               a[j-h] = a[j];
	               a[j] = t;
	            }
	               
	         h /= 3;
	            
	      }
	   }

	   static void r(int data[]) {

	      int i, m = data[0], exp = 1, n = data.length;
	      int[] B = new int[n];
	      for (i = 1; i < n; i++)
	         if (data[i] > m)
	            m = data[i];
	      while (m / exp > 0) {
	         int[] C = new int[10];
	         for (i = 0; i < n; i++)
	            C[(data[i] / exp) % 10]++;
	         for (i = 1; i < 10; i++)
	            C[i] += C[i - 1];
	         for (i = n - 1; i >= 0; i--)
	            B[--C[(data[i] / exp) % 10]] = data[i];
	         for (i = 0; i < n; i++)
	            data[i] = B[i];
	         exp *= 10;
	      }

	   }

	   static void MergeTD(int a[]) {
	      int[] aux = new int[a.length];
	      sort(a, aux, 0, a.length - 1);
	   }

	   private static void sort(int[] a, int[] aux, int lo, int hi) {
	      if (hi <= lo)
	         return;
	      int mid = lo + (hi - lo) / 2;
	      sort(a, aux, lo, mid); // 아랫부분 정렬
	      sort(a, aux, mid + 1, hi); // 윗부분 정렬
	      merge(a, aux, lo, mid, hi); // 두 부분을 병합
	   }

	   private static void merge(int a[], int aux[], int lo, int mid, int hi) {
	   
	      for (int k = lo; k <= hi; k++)
	         aux[k] = a[k];
	      int i = lo, j = mid + 1;
	      for (int k = lo; k <= hi; k++) {
	         if (i > mid)
	            a[k] = aux[j++];
	         else if (j > hi)
	            a[k] = aux[i++];
	         else if (aux[j]<aux[i])
	            a[k] = aux[j++];
	         else
	            a[k] = aux[i++];
	      }
	   }

	   public static void MergeBU(int a[]){
	         int[] src = a, dst = new int[a.length], tmp;
	         int N = a.length;
	         for (int n = 1; n < N; n *= 2) { // n: 병합할 부분 배열의 크기
	         for (int i = 0; i < N; i += 2*n) // i: 병합할 부분 배열의 위치
	         merge1(src, dst, i, i+n-1, Math.min(i+2*n-1, N-1));
	         tmp = src; src = dst; dst = tmp;
	         }
	         if (src != a) {
	        	 for(int z=0;z<src.length;z++)
	        		 a[z]=src[z];
	         }
	   }
	   private static void merge1(int[] in, int[] out, int lo, int mid, int hi) {
	      int i = lo, j = mid+1;
	      for (int k = lo; k <= hi; k++) {
	      if (i > mid) out[k] = in[j++];
	      else if (j > hi) out[k] = in[i++];
	      else if (in[j]<in[i]) out[k] = in[j++];
	      else out[k] = in[i++];
	      } 
	      }	   	       	      	 
	}

