package corejava.Lab2.ParametrsCommandString;

/*
Задача состоит в написании класса, который разбирает командную строку, переданную на вход программе.
При создании объекта этого класса, он получает набор разделителей и набор самих ключей, который допустим
в командной строке. Например: «-t  -r», здесь «-» это разделитель, а «t» и «r» ключи
 */
public class ComLineParser {

    private String[] keys;
    private String[] delimeters;

    public enum SwitchStatus {NoError, Error, ShowUsage}

    public ComLineParser(String[] keys) {
        this(keys, new String[]{"/", "-"});
    }

    public ComLineParser(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }

    public void OnUsage(String errorKey) {
        if (errorKey != null) {
            System.out.println("Command-line switch error:" + errorKey);
        }

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>][-w<output-fileName>]");
        System.out.println("    -? показать Help файл");
        System.out.println("    -r задать имя входного файла");
        System.out.println("    -w выполнить вывод в указанный файл");

    }

    public SwitchStatus OnSwitch(String key, String keyValue) {
        System.out.println(key + " " + keyValue);

        return SwitchStatus.NoError;
    }

    public Boolean Parse(String[] args) {
        SwitchStatus ss = SwitchStatus.NoError;
        int argNum;

        for (argNum = 0; (ss == SwitchStatus.NoError) && (argNum < args.length); argNum++) {
            //проверка наличия правильного разделителя
            boolean isDelimeter = false;

            for (int n = 0; !isDelimeter && (n < delimeters.length); n++) {
                isDelimeter = args[argNum].regionMatches(0, delimeters[n], 0, 1);
            }

            if (isDelimeter) {
                //проверка наличия правильного ключа
                boolean isKey = false;
                int i;
                for (i = 0; !isKey && (i < keys.length); i++) {
                    isKey = args[argNum].toUpperCase().regionMatches(1, keys[i].toUpperCase(), 0, keys[i].length());

                    if (isKey) {
                        break;
                    }
                }
                if (!isKey) {
                    ss = SwitchStatus.Error;
                    break;
                }else {
                    ss = OnSwitch(keys[i].toLowerCase(), args[argNum].substring(1 + keys[i].length()));
                }
            } else {
                ss = SwitchStatus.Error;
                break;
            }
        }
        // завершение разбора командной строки
        if (ss == SwitchStatus.ShowUsage) {
            OnUsage(null);
        }
        if (ss == SwitchStatus.Error) {
            OnUsage((argNum == args.length) ? null : args[argNum]);
        }

        return ss == SwitchStatus.NoError;
    }

    public static void main(String[] args) {

        ComLineParser comLineParser = new ComLineParser(new String[]{"?", "r", "w"});

        comLineParser.Parse(args);

    }
}
