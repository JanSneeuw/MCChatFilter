package jansneeuw.vdzwet.dev.simplechatfilter.converters;

public class SymbolConverter {
    public static String deobfuscateSymbols(String in) {
        return in.replace('@', 'a').replace('<', 'c').replace('(', 'c').replace('[', 'c').replace('{', 'c')
                .replace('3', 'e').replace('#', 'h').replace('!', 'l').replace('1', 'l')
                .replace('0', 'o').replace('$', 's').replace('5', 's').replace('+', 't');
    }
}
