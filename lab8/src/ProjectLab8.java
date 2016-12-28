import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ProjectLab8 extends JFrame implements ActionListener {

    private JButton fillButton, resetButton, displayButton, displayBackButton,
            setElementButton, findSmallestButton, findLargestButton, 
            getElementButton,
            replaceButton, sumButton, countBelowButton;

    private JLabel elementLabel1, elementLabel2, getLabel1, replaceLabel1,
            replaceLabel2, countLabel1;  // JLabels
    private JTextField field1, field2, field3, field4, field5, field6;
// text fields
    private JTextArea output = new JTextArea(10, 50);
    private Comp132Array array = new Comp132Array();

    public static void main(String[] args) {
        ProjectLab8 frame = new ProjectLab8();
        frame.setSize(700, 500);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout(FlowLayout.LEFT));
        window.add(output);
        
        //  for filling array with random numbers button
        fillButton = new JButton("Fill Array");
        window.add(fillButton);
        fillButton.addActionListener(this);

        // button to display array 
        displayButton = new JButton("Display Array");
        window.add(displayButton);
        displayButton.addActionListener(this);

        // for resetting array to zeros button
        resetButton = new JButton("Reset Array");
        window.add(resetButton);
        resetButton.addActionListener(this);

        // button to display array backward
        displayBackButton = new JButton("Display Backwards");
        window.add(displayBackButton);
        displayBackButton.addActionListener(this);

        // button to display smallest number in the array 
        findSmallestButton = new JButton("Find Smallest");
        window.add(findSmallestButton);
        findSmallestButton.addActionListener(this);

        // find largest button
        findLargestButton = new JButton("Find Largest");
        window.add(findLargestButton);
        findLargestButton.addActionListener(this);

        // sum button, add it to window and actionListener
        sumButton = new JButton("Find Sum");
        window.add(sumButton);
        sumButton.addActionListener(this);

        // button for setting an element in an array
        setElementButton = new JButton("Set Element");
        window.add(setElementButton);
        setElementButton.addActionListener(this);

        // add element JLabel and it's text area fields
        elementLabel1 = new JLabel("Element:");
        window.add(elementLabel1);
        field1 = new JTextField(5);
        window.add(field1);

        // add value 
        elementLabel2 = new JLabel("Value:");
        window.add(elementLabel2);
        field2 = new JTextField(5);
        window.add(field2);

        // get element button
        getElementButton = new JButton("Get Element");
        window.add(getElementButton);
        getElementButton.addActionListener(this);

        // add get element and it text area
        getLabel1 = new JLabel("Element:");
        window.add(getLabel1);
        field3 = new JTextField(5);
        window.add(field3);

        // replace an element button
        replaceButton = new JButton("Replace Element:");
        window.add(replaceButton);
        replaceButton.addActionListener(this);

        // add old value Label and it's text area
        replaceLabel1 = new JLabel("Old Value:");
        window.add(replaceLabel1);
        field4 = new JTextField(5);
        window.add(field4);

        // add new value label and it's text area
        replaceLabel2 = new JLabel("New Value:");
        window.add(replaceLabel2);
        field5 = new JTextField(5);
        window.add(field5);

        // button to count element that are below a certain number
        countBelowButton = new JButton("Find Count Below"); // count below button
        window.add(countBelowButton);
        countBelowButton.addActionListener(this);

        // add value label and it's text area
        countLabel1 = new JLabel("Value:");
        window.add(countLabel1);
        field6 = new JTextField(5);
        window.add(field6);

    }
    public void actionPerformed(ActionEvent e) {
        Object input = e.getSource();
        if (input == fillButton) { 
            array.fillArray();  // fill the array
            }else if (input == displayButton){ 
            array.display(output);   // display the array
            
        }else if (input == resetButton){ 
            array.resetArray();     // reset the array, check by display button above
            
       
        }else if (input == displayBackButton){ 
            array.displayBackwards(output);   // display array backward
            
        }else if (input == setElementButton){ 
            int a1 = Integer.parseInt(field1.getText());
            int a2 = Integer.parseInt(field2.getText());
            array.setElementAt(a1,a2);
            
        }else if (input == findSmallestButton) { // smallest check here
            output.append("The smallest is: " + array.findSmallest() + "\n");
            
        }else if (input == findLargestButton) { // largest check here
            output.append("The largest is: " + array.findLargest() + "\n");
            
        }else if (input == getElementButton) { // get element
            int f1 = Integer.parseInt(field3.getText());
            output.append("" + array.getElementAt(f1) + "\n");
            
        }else if (input == replaceButton) { // replace here
            int a1 = Integer.parseInt(field4.getText());
            int a2 = Integer.parseInt(field5.getText());
            array.replace(a1, a2);
            
        }else if (input == sumButton) { // sum all button
            output.append("The sum is: " + array.findSum() + "\n");
            
        }else if (input == countBelowButton) { // count numbers below
            int a= Integer.parseInt(field6.getText());
            output.append("" + array.countBelow(a) +
                    " numbers are below " + a + ".\n");
        }

    }
}

     class Comp132Array {

        private int[] array = new int[10];
        Random random = new Random(); // for generating random array elements

        public Comp132Array() {
            for (int i = 0; i < array.length; i++) {
                array[i] = 0;
            }

        }

        public void fillArray() {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(101);
            }
        }

        public int findSum() {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            return sum;
        }

        public int findSmallest() {
            int Smallest = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < Smallest) {
                    Smallest = array[i];
                }
            }
            return Smallest;
        }

        public int findLargest() {
            int Largest = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > Largest) {
                    Largest = array[i];
                }
            }
            return Largest;
        }

        public int getElementAt(int position) {
            return array[position];
        }

        public void setElementAt(int position, int num) {
            array[position] = num;
        }

        public void display(JTextArea t) {
            for (int i = 0; i < array.length; i++) {
                t.append(" " + array[i] + " ");
            }
            t.append("\n");
        }

        public void resetArray() {
            for (int i = 0; i < array.length; i++) {
                array[i] = 0;
            }
        }

        public void displayBackwards(JTextArea t) {
            for (int i = (array.length - 1); i >= 0; i--) {
                t.append("" + array[i] + " ");
            }
            t.append("\n");
        }

        public void replace(int Key, int newValue) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == Key) {
                    array[i] = newValue;
                }
            }
        }

        public int countBelow(int limit) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < limit) {
                    count++;
                }
            }
            return count;
        }

    }
