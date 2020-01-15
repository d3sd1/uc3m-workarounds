import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom; //Range random number generator
import java.util.concurrent.TimeUnit; //Sleeper
public class HeridosYMuertos {
    Scanner input = new Scanner(System.in);
    /* Begin text colors */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[] args)
    {
        HeridosYMuertos.createGame();
    }
    public static void createGame()
    {
        HeridosYMuertos caller = new HeridosYMuertos();
        Scanner input = new Scanner(System.in); //Needed for static method main
        caller.buildMeme("welcome");
        System.out.println(ANSI_PURPLE + "¡Bienvenid@ a Heridos y Muertos!" + ANSI_RESET);
        System.out.println("Para comenzar el juego, has de seleccionar un nivel de dificultad.");
        int userLevel = caller.selectLevel();
        int startNum = 0, endNum = 0, attempts = 0, lastNum = 0;
        switch(userLevel)
        {
            case 1:
                startNum = 0;
                endNum = 10;
                attempts = 9;
            break;
            case 2:
                startNum = 0;
                endNum = 100;
                attempts = 50;
            break;
            case 3:
                startNum = 0;
                endNum = 100;
                attempts = 20;
            break;
            case 4:
                startNum = 0;
                endNum = 1000;
                attempts = 10;
            break;
            case 5:
                startNum = 0;
                endNum = 1000;
                attempts = 5;
            break;
            case 6:
                startNum = 0;
                endNum = 1000;
                attempts = 1;
            break;
            case 7: //Personalized
                int[] personalizedLevel = caller.personalizeLevel();
                startNum = personalizedLevel[0];
                endNum = personalizedLevel[1];
                attempts = personalizedLevel[2];
            break;
        }
        boolean validNum = false;
        int secretNum = new HeridosYMuertos().generateSecretNum(startNum, endNum);
        System.out.println(secretNum);
        caller.buildMeme("startgame");
        System.out.println("Condiciones -> número de intentos máximo: " + attempts + ", número mínimo: " + startNum + " y número máximo: " + endNum);
        System.out.println("¡La partida va a empezar! ¡Mucha suerte!");
        for(int i = 10; i > 0; i--) //Delay game for 10s
        {
            try {
                Thread.sleep(1000); //Sleep a second there
            } catch (InterruptedException e) {}
            if(i > 3)
            {
                System.out.println(i);
            }
            else if(i == 3)
            {
                System.out.println(ANSI_GREEN + i + ANSI_RESET);
            }
            else if(i == 2)
            {
                System.out.println(ANSI_YELLOW + i + ANSI_RESET);
            }
            else if(i == 1)
            {
                System.out.println(ANSI_RED + i + ANSI_RESET);
            }
        }
        int medAttempts = attempts/2;
        for(int attempt = 1; attempt <= attempts; attempt++)
        {
            int lessAttempts = attempts-attempt;
            if(lessAttempts == medAttempts)
            {
                caller.buildMeme("halfattempts");
                System.out.println("¡Te quedan la mitad de los intentos!");
            }
            if(attempt == attempts)
            {
                caller.buildMeme("lastchance");
                System.out.println("¡Es tu último intento!");
            }
            
            System.out.println("[Intento " + attempt + " de " + attempts + "] Introduce tu número...");
            int timeOut = 10;
            lastNum = input.nextInt();
            if(lastNum == secretNum)
            {
                caller.buildMeme("winner");
                System.out.println("¡Enhorabuena, has ganado!");
                caller.playAgain();
            }
            else
            {
                System.out.println("");
                /* Secret num */
                String secretNumStr = Integer.toString(secretNum);
                /* Given num */
                String givenNumStr = Integer.toString(lastNum);
                String minNumStr;
                if(secretNum >= lastNum)
                {
                    minNumStr = givenNumStr;
                }
                else
                {
                    minNumStr = secretNumStr;
                }
                int timesFound = 0;
                boolean showLengthError = false;
                for(int thisLoop = 0; thisLoop < minNumStr.length(); thisLoop++)
                {
                    if(secretNumStr.length() == givenNumStr.length()) // Fix for if the user gives a 2 char number and the secret number is 3 and viceversa
                    {
                        String actualNumber = "" + givenNumStr.charAt(thisLoop);
                        timesFound = secretNumStr.length() - secretNumStr.replaceAll(actualNumber,"").length(); //Search if the num is repeteated
                        if(secretNumStr.charAt(thisLoop) == givenNumStr.charAt(thisLoop) && timesFound > 0)
                        {
                            System.out.print(ANSI_GREEN + givenNumStr.charAt(thisLoop) + ANSI_RESET);
                        }
                        else if(timesFound > 0) 
                        {
                            System.out.print(ANSI_YELLOW + givenNumStr.charAt(thisLoop) + ANSI_RESET);
                        }
                        else if(timesFound == 0)
                        {
                            System.out.print(givenNumStr.charAt(thisLoop));
                        }
                    }
                    else
                    {
                        showLengthError = true;
                    }
                }
                if(showLengthError == true)
                {
                    System.out.println("Pista: El número contiene " + secretNumStr.length() + " cifras.");
                }
                System.out.println("");
            }
        }
    }
    public int generateSecretNum(int startNum, int endNum) {
        int secretNum = 0;
        boolean  repeteated = false;
            secretNum = ThreadLocalRandom.current().nextInt(startNum, endNum + 1); //Generate a num under max and min. Plus 1 for the given 0 of the array.
            String secretNumStr = Integer.toString(secretNum);
            for(int i = 0; i < secretNumStr.length(); i++)
            {
                String actualNumber = "" + secretNumStr.charAt(i); //Convert char to str
                int timesFound = 0;
                //se busca la primera vez que aparece
                timesFound = secretNumStr.length() - secretNumStr.replaceAll(actualNumber,"").length(); //Search if the num is repeteated
                if(timesFound > 1)
                {
                    repeteated = true;
                    break;
                }
                else
                {
                    repeteated = false;
                }
            }
            if(repeteated == true)
            {
                generateSecretNum(startNum, endNum); //Iterate if the num was not valid. Get a valid one!
            }
        return secretNum;
    }
    public void playAgain()
    {
        System.out.println("¿Quieres jugar de nuevo? (S/N)");
        char playAgain = input.next().charAt(0);
        if(playAgain == 'S' || playAgain == 's')
        {
            HeridosYMuertos.createGame();
        }
        else
        {
            System.out.println("¡Que te vaya bien! Nos vemos pronto.");
        }
    }
    public int[] personalizeLevel()
    {
        int[] levelValues = new int[3];
        System.out.println("Introduce el primer número del rango.");
        levelValues[0] = input.nextInt();
        System.out.println("Introduce el último número del rango.");
        levelValues[1] = input.nextInt();
        System.out.println("Introduce el número de intentos.");
        levelValues[2] = input.nextInt();
        return levelValues;
    }
    public void showInfo()
    {
        System.out.println("El juego consiste en adivinar el número comprendido en un rango.");
        System.out.println("Ambos números del rango estarán incluidos en el juego.");
        System.out.println("Si un número se avidina, se tratará como herido. Si se acierta el número y su posición dentro del número oculto, se tratará como muerto.");
        System.out.println("El número herido se mostrará en amarillo, mientras que el muerto en verde (si los hay).");
        System.out.println("");
        System.out.println("a) Nivel muy fácil - Número entre 1 y 10. 9 Intentos.");
        System.out.println("b) Nivel fácil - Número entre 0 y 100. 50 Intentos.");
        System.out.println("c) Nivel medio - Número entre 0 y 100. 20 Intentos.");
        System.out.println("d) Nivel avanzado - Número entre 0 y 1000. 10 Intentos.");
        System.out.println("e) Nivel experto - Número entre 0 y 1000. 5 Intentos");
        System.out.println("f) Nivel extremo - Número entre 0 y 1000. 1 Intento.");
        System.out.println("f) Nivel personalizado - Elige el rango y el número de intentos.");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("");
        selectLevel();
    }
    public int selectLevel()
    {
        System.out.println("a) Nivel muy fácil");
        System.out.println("b) Nivel fácil");
        System.out.println("c) Nivel medio");
        System.out.println("d) Nivel avanzado");
        System.out.println("e) Nivel experto");
        System.out.println("f) Nivel extremo");
        System.out.println("g) Nivel personalizado");
        System.out.println("h) Mostrar más información");
        System.out.println("");
        char level = input.next().charAt(0);
        int levelInt = 0;
        switch(level)
        {
            case 'a':
                levelInt = 1;
            break;
            case 'A':
                levelInt = 1;
            break;
            case 'b':
                levelInt = 2;
            break;
            case 'B':
                levelInt = 2;
            break;
            case 'c':
                levelInt = 3;
            break;
            case 'C':
                levelInt = 3;
            break;
            case 'd':
                levelInt = 4;
            break;
            case 'D':
                levelInt = 4;
            break;
            case 'e':
                levelInt = 5;
            break;
            case 'E':
                levelInt = 5;
            break;
            case 'f':
                levelInt = 6;
            break;
            case 'F':
                levelInt = 6;
            break;
            case 'g':
                levelInt = 7;
            break;
            case 'G':
                levelInt = 7;
            break;
            case 'h':
                showInfo();
            break;
            case 'H':
                showInfo();
            break;
        }
        return levelInt;
    }
    public void buildMeme(String type)
    {
        switch(type)
        {
            case "welcome":
                System.out.println(ANSI_BLUE + "            (.,------...__\n" +
                ANSI_BLUE + "         _.'\"             `.\n" +
                ANSI_BLUE + "       .'  .'   `, `. `.    `\n" +
                ANSI_BLUE + "      . .'   .'/''--...__`.  \\\n" +
                ANSI_BLUE + "     . .--.`.  ' \"-.     '.  |\n" +
                ANSI_BLUE + "     ''  .'  _.' .())  .--\":/\n" +
                ANSI_BLUE + "     ''(  \\_\\      '   (()(\n" +
                ANSI_BLUE + "     ''._'          (   \\ '\n" +
                ANSI_BLUE + "     ' `.            `--'  '\n" +
                ANSI_BLUE + "      `.:    .   `-.___.'  '\n" +
                ANSI_BLUE + "       `.     .    _  _  .'\n" +
                ANSI_BLUE + "         )       .____.-'\n" +
                ANSI_BLUE + "       .'`.        (--..\n" +
                ANSI_BLUE + "     .' \\  /\\      / /  `.\n" +
                ANSI_BLUE + "   .'    \\(  \\    /|/     `.\n" +
                ANSI_BLUE + " .'           \\__/          `.\n" +
                ANSI_BLUE + "/      |        o      |      \\\n" +
                ANSI_BLUE + "       |               |      |" + ANSI_RESET);
            break;
            case "winner":
                System.out.println(ANSI_BLUE + "      .----------------------------------------------------.\n" +
                ANSI_BLUE + "      |                                                    |\n" +
                ANSI_BLUE + "      |       _  .-\"-.  .-\"-. .--.    _   _      _   ____  |\n" +
                ANSI_BLUE + "      |    ,'` | | ._ `.| ._ \\|  /  ,' '\\| | _ .' ) |   _|_|__\n" +
                ANSI_BLUE + "     _|_  / /| | | | \\ '| | \\ | ;  / ., || || || ;  |  |_(]___`\\\n" +
                ANSI_BLUE + "   /___[)' | | | | '-`/ | '-`/| | / /_| || || | \\ `\\|  '(]____ '\n" +
                ANSI_BLUE + "  | ____[) '-' | | |-'  | .-' | |/      || `' |  ;  |  |\"(]___ |\n" +
                ANSI_BLUE + "  ; ___[)| .-. | | |    | |   | '-./`|  ||    | /  /|  |__(]_ /\n" +
                ANSI_BLUE + "   \\ _[) |_| \\_' '_|    ._|   '---'  '--'`.__.'(_,' |_____||-`\n" +
                ANSI_BLUE + "    `-|                                                    |\n" +
                ANSI_BLUE + "      '----------------------------------------------------'\n" +
                ANSI_BLUE + "       \\      '   /|//  /|/\\,>7/|\\>/\\ \\         /      ,'\n" +
                ANSI_BLUE + "        \\     '; |/|;  |  .--.  .--. \\ |       /     ,'\n" +
                ANSI_BLUE + "         '     |  |\\| /  '__________' ||   ,-'     ,'\n" +
                ANSI_BLUE + "         |     | .-' [    \\\"\" /:  \"/  ]'.,'       /\n" +
                ANSI_BLUE + "         '.    '|     |    `-'  \\-'  |  |       ,'\n" +
                ANSI_BLUE + "          |     .'.__.'     |    |   '._'      /\n" +
                ANSI_BLUE + "          |      `\\||       \\    /    |      .`\n" +
                ANSI_BLUE + "          |        ||        `--'     |     /\n" +
                ANSI_BLUE + "          |        \\\\__  __           |     '\n" +
                ANSI_BLUE + "          '.        `===(__)`.__.'    ;     |\n" +
                ANSI_BLUE + "           |         \\ \\             /|     |\n" +
                ANSI_BLUE + "          .|          \\ `._        ,' |     |\n" +
                ANSI_BLUE + "          |            .   `-.__,-'   ;     .\n" +
                ANSI_BLUE + "          |             \\    ,\\_/\\   /      '\n" +
                ANSI_BLUE + "          |              `..' |\\\\ `-'   _.-\\ \\\n" +
                ANSI_BLUE + "         ,'._                 | :`.  .-`    \\ ;\n" +
                ANSI_BLUE + "         |   `                | '  \\ \\ __,-' \\|\n" +
                ANSI_BLUE + "         /                    |  \\  \\ \\      ||\n" +
                ANSI_BLUE + "         `-._                 |   '-'  \\   _,'|\n" +
                ANSI_BLUE + "             `--.             :   |     `'`  ,/\n" +
                ANSI_BLUE + "                 `--._        '.__;         _/ " + ANSI_RESET);
            break;
            case "lastchance":
                System.out.println(ANSI_BLUE + "               /` './`\\\n" +
                ANSI_BLUE + "              ;     \\  \\  ___\n" +
                ANSI_BLUE + "              |      ' .'`    `.\n" +
                ANSI_BLUE + "             .        /  O  o   |\n" +
                ANSI_BLUE + "         ___ |_       | _|`'/   ;\n" +
                ANSI_BLUE + "     .-''   `| `'----/ o\"..-`o /          _   _\n" +
                ANSI_BLUE + "    (        `._   .'    o'_.-' _ __ _  _| |_( )___ _ __\n" +
                ANSI_BLUE + "     `-.._____..-'___..--'`\\\\> | '_ \\ || |  _|// -_) '  \\\n" +
                ANSI_BLUE + "        |/  .-.\\| |  O||  O|`  | .__/\\_,_|\\__| \\___|_|_|_|\n" +
                ANSI_BLUE + "         |/|.-,\\/ '._.' _-' \\  |_|        _  _ _ __\n" +
                ANSI_BLUE + "          ' \\_, _/     '  ) ;   .-,_     | || | '_ \\\n" +
                ANSI_BLUE + "        ._.-. _\\ \\    `'-' /    \\ \\'\\     \\_,_| .__/\n" +
                ANSI_BLUE + "   .--.  `-,_(_); `-..__.-'  _   | ; |.-,     |_|\n" +
                ANSI_BLUE + "  /    `'-/_.'|\\| `7.---.   (_ `-/ | ' /\n" +
                ANSI_BLUE + "  |   `|-._   \\ `--'     \\    `-,   _.'\n" +
                ANSI_BLUE + "   \\   `.  `'. `._       ;      /  '\n" +
                ANSI_BLUE + "    `.__/-.   \\   `-.   / \\,_.-'`-;\n" +
                ANSI_BLUE + "   _.,7    `-._|     \\ /  ;_    _.'\n" +
                ANSI_BLUE + "  (   , | /.-n_)      v   | '-.'\n" +
                ANSI_BLUE + "   `-'| ; |_   \\      |  _/_.._)\n" +
                ANSI_BLUE + "       \\_\\ \\`|.-.   _./-'|__\n" +
                ANSI_BLUE + "         `-'/   |`-|  \\_.'  `-.\n" +
                ANSI_BLUE + "          _.-\\  |'-'-'`        `.\n" +
                ANSI_BLUE + "        .'    |_|                \\\n" +
                ANSI_BLUE + "       /      '_b _.-\"'-._        `>\n" +
                ANSI_BLUE + "      <,       . /        \\ -      ;\n" +
                ANSI_BLUE + "      /         '         `|        \\\n" +
                ANSI_BLUE + "      |        ;           ;_      ;\n" +
                ANSI_BLUE + "      ;        |           |        >\n" +
                ANSI_BLUE + "      <,      _;           ;       ,\\\n" +
                ANSI_BLUE + "       /       |          _|       _\\\n" +
                ANSI_BLUE + "       |_,      \\__     ((/_       `\\mx\n" +
                ANSI_BLUE + "        /_       \\))    /`=c`'-;/'-._>\n" +
                ANSI_BLUE + "   _ ___'/'^'`'^`c='    |  |\\     `.__\n" +
                ANSI_BLUE + "  | \\         _,  /     '--' `.       />\n" +
                ANSI_BLUE + "   `'-..__.''` '--'            `''---'`" + ANSI_RESET);
            break;
            case "loser":
                System.out.println(ANSI_BLUE + "                                           _\n" +
                ANSI_BLUE + "                                         ,;;;\n" +
                ANSI_BLUE + "                                       .;;||:.\n" +
                ANSI_BLUE + "                                      :;;|||::\n" +
                ANSI_BLUE + "                                    ,;;;;;||::.\n" +
                ANSI_BLUE + "                                   ,;;;;;||||||:.\n" +
                ANSI_BLUE + "                                  ,;;;;|||||||||||.\n" +
                ANSI_BLUE + "                                 ,;;;||!!!!!!!|||||.\n" +
                ANSI_BLUE + "                                ,;;;;|!!!!!!!!!|||||\n" +
                ANSI_BLUE + "                                ;;;;!!!!!!!!!!!!|||||\n" +
                ANSI_BLUE + "                               |;;;;;/~\\!!!,'~\\!!||||\n" +
                ANSI_BLUE + "                              :;;;;;|   |!!|   |!!|||\n" +
                ANSI_BLUE + "                              :;;;;;;-._;!!`._/!!!!|`.\n" +
                ANSI_BLUE + "                              |;;;;;;|||!!;;;!!||!!|||\n" +
                ANSI_BLUE + "         ____                  |;;;;;|||!!;;;|||!!||,'\n" +
                ANSI_BLUE + "       ,- _ _`,                 |;;;|||!!!;;|||!!||/ ~-.__\n" +
                ANSI_BLUE + "     /'/~; ; ; )             _--`;;;|||!!!;;|||!!,' \"\" __.--.\\\n" +
                ANSI_BLUE + "    | ( .---~~--._       _.-~:\"\" `:;|||!!;;;|||/' \".-~~      `.\\\n" +
                ANSI_BLUE + "    `. ((.;~---._ `-.  ,'     :\"\"  `:|!!;;;;/' \"  ;            :|.\n" +
                ANSI_BLUE + "     : ((;##### `-. :,'       :\"\"\"\"  |!!;;;/ \"\" .'  __         ;||\n" +
                ANSI_BLUE + "      :   #####| `;  `-._     :\"\"\"\"  ||!!;/ \"\" .' .'          ,:||\n" +
                ANSI_BLUE + "       |   ###  | `.     `-._:\"\"\"\"\"  `!!!:  \"  :              ';||\n" +
                ANSI_BLUE + "       |   ###   .  `-.      `-._____.----'~~~`'`.           '|\"|\n" +
                ANSI_BLUE + "      |    ###   :    `.                         ;          .'\"||\n" +
                ANSI_BLUE + "      |    ###   ;     `._                                .'\"|||\n" +
                ANSI_BLUE + "      |    ###  |     ,-' `-._         _                 / \"||||\n" +
                ANSI_BLUE + "       |   ###     ,-'    |\"  `-._      `-.            ,' \"|||:|\n" +
                ANSI_BLUE + "       |   ###   ,'       |\"\"     `-.___   `.       _/   \"|||:::|\n" +
                ANSI_BLUE + "        `_ ###_.'         |\"\"\"\"\"        `---'-____.'    \"\"\"||||||\n" +
                ANSI_BLUE + "           ###            `.\"\"\"\"\"\"\"\"\"\"\"\"             \"\"\"\"\"\"\"||||\n" +
                ANSI_BLUE + "           ###             |\"\"\" \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|||\"\"\"\"|\n" +
                ANSI_BLUE + "           ###             |\"\"\"\"\"\" \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|||\"\"\"\"\"|\n" +
                ANSI_BLUE + "           ###             `.\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"__|\n" +
                ANSI_BLUE + "           ###              `.\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"____.---'   \\\n" +
                ANSI_BLUE + "    /|     ###               `.\"\"\"\"\"\"\"\"\"____.----'    //-\\    |\\\n" +
                ANSI_BLUE + "  .||      ###                `--.__,--' //|| \\\\     //   \\  //~|\n" +
                ANSI_BLUE + "  ||:      ###                / /\\ \\    // ||  \\\\   //     \\// :|\n" +
                ANSI_BLUE + "  |||.     ###               / /  \\ \\  //  ||   \\\\ //____.-/  :: \\\n" +
                ANSI_BLUE + "  |||||.   ###              //_____\\ \\//   ||    \\\\/       ::  ::||\n" +
                ANSI_BLUE + "  |||||||  ###              ~~|     ~~\\____/~\\_.-~~  :::       ::||\n" +
                ANSI_BLUE + "  |||||||| ###                `.                              ::|||\n" +
                ANSI_BLUE + "  |||||||||||||.   |          ||                               :|||\n" +
                ANSI_BLUE + "  ||||||||||||||||||          |||                     : ___   ::`||\n" +
                ANSI_BLUE + "  ||||||||||||||||||          `||:: `._             _.-':::::::::||\n" +
                ANSI_BLUE + "  ||||||||||||||||||           |||||   `-._     _.-'       ::::::|'\n" +
                ANSI_BLUE + "  ||||||||||||||||||           |||||::     `\\/~'              ::|'\n" +
                ANSI_BLUE + "  |||||||||||||'   |           `||||:        \\                  |\n" +
                ANSI_BLUE + "  |||||||  ###                  ||::::        |                 |\n" +
                ANSI_BLUE + "  |||||/~~~~~~~~~.              `||:::         |               |'\n" +
                ANSI_BLUE + "  ||||   /\\   /\\  `.             ||::::         |              |\n" +
                ANSI_BLUE + "  ||| :  ~~ II~~ :  |            ||:::::        |             |'\n" +
                ANSI_BLUE + "  ||  : ________ :  |            `||:::::       |             |\n" +
                ANSI_BLUE + "  ||    \\##_#_#/   .'             |||:::::      |             |\n" +
                ANSI_BLUE + "   \\| ____________'\n" +
                ANSI_BLUE + "                    " + ANSI_RESET);
            break;
            case "startgame":
                System.out.println(ANSI_BLUE + "                              ,,,\n" +
                ANSI_BLUE + "                              i i'\n" +
                ANSI_BLUE + "                              \\~;\\\n" +
                ANSI_BLUE + "                               \\; \\\n" +
                ANSI_BLUE + "                                \\ ;\\    ====\n" +
                ANSI_BLUE + "                                 \\ ;\\  ==== \\\n" +
                ANSI_BLUE + "                            __,--';;;\\-' (  0\n" +
                ANSI_BLUE + "                      __,--';;; ;;; ;;\\      >\n" +
                ANSI_BLUE + "               __,--'\\\\ ;;; ;;; ;;; ;;;\\--__<\n" +
                ANSI_BLUE + "        _ _,--' __,--'\\\\  ;;; __,~~' \\ ;\\\n" +
                ANSI_BLUE + "       (_)|_,--' __,--'\\\\;,~~'        \\ ;\\\n" +
                ANSI_BLUE + "       |(_)|_,--'       ~~             \\; \\\n" +
                ANSI_BLUE + "       || |                             \\ ;\\\n" +
                ANSI_BLUE + "        |_/                              !~!,\n" +
                ANSI_BLUE + "                                     .---'''---.\n" +
                ANSI_BLUE + "                                     |         |\n" +
                ANSI_BLUE + "                                     |         |\n" +
                ANSI_BLUE + "                                     |         |\n" +
                ANSI_BLUE + "                                     `---------'" + ANSI_RESET);
            break;
            case "halfattempts":
                System.out.println(ANSI_BLUE + "                             Z             \n" +
                ANSI_BLUE + "                       Z                   \n" +
                ANSI_BLUE + "        .,.,        z           \n" +
                ANSI_BLUE + "      (((((())    z             \n" +
                ANSI_BLUE + "     ((('_  _`) '               \n" +
                ANSI_BLUE + "     ((G   \\ |)                 \n" +
                ANSI_BLUE + "    (((`   \" ,                  \n" +
                ANSI_BLUE + "     .((\\.:~:          .--------------.    \n" +
                ANSI_BLUE + "     __.| `\"'.__      | \\              |     \n" +
                ANSI_BLUE + "  .~~   `---'   ~.    |  .             :     \n" +
                ANSI_BLUE  + " /                `   |   `-.__________)     \n" +
                ANSI_BLUE + "|             ~       |  :             :   \n" +
                ANSI_BLUE + "|                     |  :  |              \n" +
                ANSI_BLUE + "|    _                |     |   [ ##   :   \n" +
                ANSI_BLUE + " \\    ~~-.            |  ,   oo_______.'   \n" +
                ANSI_BLUE + "  `_   ( \\) _____/~~~~ `--___              \n" +
                ANSI_BLUE + "  | ~`-)  ) `-.   `---   ( - a:f -         \n" +
                ANSI_BLUE + "  |   '///`  | `-.                         \n" +
                ANSI_BLUE + "  |     | |  |    `-.                      \n" +
                ANSI_BLUE + "  |     | |  |       `-.                   \n" +
                ANSI_BLUE + "  |     | |\\ |                             \n" +
                ANSI_BLUE + "  |     | | \\|                             \n" +
                ANSI_BLUE + "   `-.  | |  |                             \n" +
                ANSI_BLUE + "      `-| '" + ANSI_RESET);
            break;
        }
    }
}
