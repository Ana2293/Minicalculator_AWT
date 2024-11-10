import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MiniCalculator extends Frame {

    Frame f = new Frame("MiniCalculator");

    double number1;
    double number2;

    MiniCalculator() {


        GridBagLayout gridBagLayout = new GridBagLayout();
        f.setLayout(gridBagLayout);
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        Label lbl1 = new Label("First number:");
        f.add(lbl1, c);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        TextField textField1 = new TextField("     ");
        f.add(textField1, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        Label lbl2 = new Label("Choose operation:");
        f.add(lbl2, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        Label lbl3 = new Label("Second number:");
        f.add(lbl3, c);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        TextField textField2 = new TextField("     ");
        f.add(textField2, c);


        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        Button b = new Button("=");
        f.add(b, c);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        Label lbl4 = new Label("Result");
        f.add(lbl4, c);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        TextField textField3 = new TextField();
        textField3.setEnabled(false);
        f.add(textField3, c);
        textField3.setPreferredSize(new Dimension(270,25));



        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        final Choice operator = new Choice();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        f.add(operator, c);

        f.setSize(500, 200);


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    number1 = Double.parseDouble(textField1.getText());
                    textField1.setText(" ");
                    number2 = Double.parseDouble(textField2.getText());
                    textField2.setText(" ");

                    String operatorValue = operator.getSelectedItem();
                    if (operatorValue.equals("+")) {
                        textField3.setText(String.valueOf(number1 + number2));
                    } else if (operatorValue.equals("-")) {
                        textField3.setText(String.valueOf(number1 - number2));
                    } else if (operatorValue.equals("*")) {
                        textField3.setText(String.valueOf(number1 * number2));
                    } else if (operatorValue.equals("/")) {
                        if (number2 == 0)
                            textField3.setText("Impartirea prin 0 este imposibila");
                        else
                            textField3.setText(String.valueOf(number1 / number2));
                    }

                } catch (NumberFormatException e) {
                    textField3.setText("Valoarea unuia din operanzi nu este numerica");
                }

            }
        });

        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setPreferredSize(new Dimension(500, 300));
        f.pack();
        f.setVisible(true);

    }
    public static void main (String[] args){

        MiniCalculator mini = new MiniCalculator();

    }

}
