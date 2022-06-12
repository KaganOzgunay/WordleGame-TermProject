package WordleGame;

/*
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class TxtLimit extends PlainDocument {
	private int limit;
	  TxtLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  TxtLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
}

public class Drag_n_Drop implements ActionListener{
    public static JTextField txt = new JTextField();
    public static JFrame frame = new JFrame("Testing");
    public static JButton testButton;
    public static void main(String[] args) {
        new Drag_n_Drop();
    }

    public Drag_n_Drop(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                             UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                    btn.bttn();

                    JPanel pANEl = new JPanel();
                    pANEl.setLayout(new GridLayout(1, 2));
                    pANEl.add(ScratchPane.createLeftPanel());
                    pANEl.add(ScratchPane.createRightPanel());


                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.add(pANEl);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);



            }


        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == testButton) {
            System.out.println("sa");
            System.out.println(txt.getText());
        }
    }

    public class ScratchPane{



        public static JPanel createLeftPanel() {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            //burası tuşların konulacağı yer.
            for (int index = 0; index < 10; index++) {
                JButton btn = new JButton(Integer.toString(index + 1));
                panel.add(btn, gbc);
                btn.setTransferHandler(new ValueExportTransferHandler(Integer.toString(index + 1)));

                btn.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        TransferHandler handle = button.getTransferHandler();
                        handle.exportAsDrag(button, e, TransferHandler.COPY);
                    }
                });
            }
            return panel;
        }

        public static JPanel createRightPanel() {
            
            
            JPanel panel = new JPanel(new GridBagLayout());
            JLabel label = new JLabel(); //txt.field[row][col]

            //JLabel labele = new JLabel("Drop in2");
            txt.setBounds(60,80,40,40);
            
            label.setBorder(new CompoundBorder(new LineBorder(Color.CYAN), new EmptyBorder(20, 20, 20, 20)));
            label.setTransferHandler(new ValueImportTransferHandler());
            txt.setText(label.getText());
            txt.setDocument(new TxtLimit(1));
            frame.add(txt);
            //labele.setBorder(new CompoundBorder(new LineBorder(Color.RED), new EmptyBorder(20, 20, 20, 20)));
            //labele.setTransferHandler(new ValueImportTransferHandler());
            //panel.add(labele);

            return panel;
        }




   }

   public static class btn{
        public static void bttn(){
            testButton = new JButton();
            testButton.setBounds(60,20,20,20);
            System.out.println("sa");
            frame.add(testButton);
        }


   }

    public static class ValueExportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
        private String value;

        public ValueExportTransferHandler(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable t = new StringSelection(getValue());
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            super.exportDone(source, data, action);
            // Bıraktıktan sonra karar verme.
        }

    }

    public static class ValueImportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public ValueImportTransferHandler() {
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (value instanceof String) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel) component).setText(value.toString());
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }
    }

}*/
