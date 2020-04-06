package org.acme.getting.started;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
//import io.quarkus.runtime.annotations.DefaultMain;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@QuarkusMain
@Command(name = "topcmd", mixinStandardHelpOptions = true, version = "@|green 1.0.0|@",
        description = "this is the description")
public class ToplevelCommand implements Callable<Integer>, QuarkusApplication {

    @Override
    public Integer call() throws Exception {
        System.out.println("Hi from ToplevelCmd...");
        return 123;
    }

    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(this).execute(args);
    }

    public static void main(String[] args) {
        Quarkus.run(ToplevelCommand.class, args);
    }
}