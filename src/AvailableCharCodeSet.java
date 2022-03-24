import java.util.HashMap;

import javax.swing.JOptionPane;

public class AvailableCharCodeSet {

    public static HashMap<String, String> charCodeMap;
    public static String[] charCodeList;
    public static String defaultCharCode = "UTF8";

    static {
        // charCodeList = new ArrayList<>(
        // Arrays.asList("ASCII", "Shift-JIS", "SJIS", "EUC-JP", "JIS", "UTF-8",
        // "UTF-16", "UTF-32"));
        charCodeList = new String[] { "ASCII", "Shift-JIS", "SJIS", "EUC-JP", "JIS", "UTF-8", "UTF-16", "UTF-32" };

        charCodeMap = new HashMap<>();

        // ASCII
        charCodeMap.put("ASCII", "US-ASCII");

        // Shift-JIS
        charCodeMap.put("Shift-JIS", "SJIS");

        // SJIS
        charCodeMap.put("SJIS", "SJIS");

        // EUC-JP
        charCodeMap.put("EUC-JP", "EUC_JP");

        // JIS
        charCodeMap.put("JIS", "ISO2022JP2");

        // UTF-8
        charCodeMap.put("UTF-8", "UTF8");

        // UTF-16
        charCodeMap.put("UTF-16", "UTF16");

        // UTF-32
        charCodeMap.put("UTF-32", "UTF32");
    }

    public static String showAvailableCharCode() {
        int value = JOptionPane.showOptionDialog(App.textFrame,
                "文字コードを選択してください。",
                "文字コード一覧",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                AvailableCharCodeSet.charCodeList,
                AvailableCharCodeSet.charCodeList[0]);
        String charCode = AvailableCharCodeSet.charCodeList[value];
        return AvailableCharCodeSet.charCodeMap.get(charCode);
    }
}
