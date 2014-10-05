package classloading.task1;

public interface Module {
    static StringBuffer counter = new StringBuffer("");

    String toString();

    void append(String string);
}
