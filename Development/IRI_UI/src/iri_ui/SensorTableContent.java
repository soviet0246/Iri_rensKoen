/*
 * If you own this file you are free to edit and share it.
 * You are, however, not allowed to mass-distribute it
 * E.g.: Mailing a copy is O.K., 
 * mirroring/hosting this or a modified version is not O.K.
 * Exemptions to this are assigned at will by the author only.
 */
package iri_ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Koen
 */
public class SensorTableContent extends AbstractTableModel {

    /**
     * ID to identify this TableContent
     */
    private static final long serialVersionUID = 1L;
    /**
     * The content of the Table, used for storage. Outer HashMap is used for
     * columns, inner one for rows.
     */
    private HashMap<Integer, HashMap<Integer, String>> content = new HashMap<>(16);

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            content.get(columnIndex).put(rowIndex, (String) aValue);
        } catch (NullPointerException nullEx) {
            content.put(columnIndex, new HashMap<Integer, String>(16));

            content.get(columnIndex).put(rowIndex, (String) aValue);
        } finally {
            this.fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() { //TODO: fix bug that this only returns 0
        int rowCount = 0;
        for (int i = 0; i < this.getColumnCount(); i++) {
            int index = 0;
            int rowIndex = 0;
            while (index < 300) {
                try {
                    if (content.get(i).containsKey(rowIndex) && rowCount < rowIndex) {
                        rowCount = rowIndex;
                        index = 0;
                    } else {
                        index++;
                    }
                } catch (NullPointerException ex) {
                    index++;
                }
            }
        }
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        int culumnCount = 0;
        int collumnIndex = 0;
        int i = 0;
        while (i < 300) {
            if (content.containsKey(collumnIndex) && culumnCount < collumnIndex) {
                culumnCount = collumnIndex;
                i = 0;
            } else {
                i++;
            }
            collumnIndex++;
        }
        return culumnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HashMap<Integer, String> rows = content.get(columnIndex);
        if (rows == null) {
            return "";
        } else {
            String result = rows.get(rowIndex);
            if (result == null) {
                return "";
            } else {
                return result;
            }
        }
    }
    /**
     * Logger for debugging and stuff.
     */
    private static final Logger LOG = Logger.getLogger(SensorTableContent.class.getName());
}
