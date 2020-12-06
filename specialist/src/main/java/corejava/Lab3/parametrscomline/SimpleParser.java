package corejava.Lab3.parametrscomline;

public class SimpleParser extends ComLineParserBase {

    private String inFile;
    private String outFile;

    public SimpleParser(String[] keys) {
        super(keys);
    }

    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    @Override
    protected void OnUsage(String errorKey) {
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    protected SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;
        switch (key) {
            case "?":
                status = SwitchStatus.ShowUsage;
                break;
            case "r":
                if (keyValue.length() > 1) {
                    inFile = keyValue;
                } else {
                    System.out.println("Ошибка! Нет имени входного файла.");
                    status = SwitchStatus.Error;
                }
                break;
            case "w":
                if (keyValue.length() > 1) {
                    outFile = keyValue;
                } else {
                    System.out.println("Ошибка! Нет имени выходного файла.");
                    status = SwitchStatus.Error;
                }
                break;
            default:
                status = SwitchStatus.Error;
                break;
        }
        System.out.println(key + " " + keyValue);
        return status;
    }

    public static void main(String[] args) {

        SimpleParser sp = new SimpleParser(new String[]{"?", "r", "w"});

        sp.Parse(args);

        System.out.println(sp.getInFile() + " " + sp.getOutFile());

    }
}
