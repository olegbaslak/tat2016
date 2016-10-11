package com.rct.homework.lesson2.task08.commands;

import com.rct.homework.lesson2.task08.commands.options.CommandOptionsProvider;
import com.rct.homework.lesson2.task08.exceptions.InvalidParamsNumberException;

import java.util.ArrayList;

/**
 * Class that stores chain of builders and builds corresponds to
 * options command
 *
 * @author Oleg Baslak
 * @version 1.0
 * @since 10.10.2016
 */
public class CommandBuilder {

    private ArrayList<Command.Builder> builders = new ArrayList<>();

    /**
     * Adds builder to the builders chain
     *
     * @param builder builder to add to the chain
     * @return CommandBuilder object back to continue adding Builders
     * to the chain
     */
    public CommandBuilder add(Command.Builder builder) {
        builders.add(builder);
        return this;
    }

    /**
     * Performing build of command
     *
     * @return built command that corresponds inputted options
     */
    public Command build(CommandOptionsProvider options) throws InvalidParamsNumberException {

        for (Command.Builder builder : builders) {
            if (builder.canBuild(options)) {
                return builder.build(options);
            }
        }
        throw new InvalidParamsNumberException("Unsupported command");
    }

}
