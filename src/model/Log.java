package model;

import java.util.List;

public class Log {
    List<String> log ;

    public Log(List<String> log) {
        this.log = log;
    }

    public void salvar(String log) {
        this.log.add(log);
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return "Log [log=" + log + "]";
    }
    
    
    
}
